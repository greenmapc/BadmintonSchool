package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.itis.greenmapc.form.SettingsForm;
import ru.kpfu.itis.greenmapc.model.RoleEnum;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.GroupService;
import ru.kpfu.itis.greenmapc.service.UserService;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    private UserService userService;
    private GroupService groupService;

    @GetMapping("/profile/{username}")
    public String personalProfile(@PathVariable(value = "username") String username,
                                  @AuthenticationPrincipal User user,
                                  ModelMap modelMap) {
        if(user != null) {
            modelMap.addAttribute("user", user);
        }

        User pageUser;

        if(user != null && user.getUsername().equals(username)) {
            pageUser = user;
            modelMap.addAttribute("page_user", user);
        } else {
            Optional<User> anotherUser = userService.findUserByLogin(username);
            if(anotherUser.isPresent()) {
                pageUser = anotherUser.get();
                modelMap.addAttribute("page_user", pageUser);
            } else {
                if(user != null) {
                    return "redirect: " + MvcUriComponentsBuilder.fromMappingName("UC#personalProfile").arg(0, user.getUsername()).build();
                } else {
                    return "redirect: " + MvcUriComponentsBuilder.fromMappingName("DC#index").build();
                }
            }
        }

        Set<String> roleName = new HashSet<>();
        for (RoleEnum roleEnum : pageUser.getRoles()) {
            roleName.add(roleEnum.getAuthority());
        }

        modelMap.addAttribute("roles", roleName);

        return "profile";
    }

    @GetMapping("/settings/{username:[A-Za-z0-9_]+}")
    public String userSettings(@PathVariable(value = "username") String username,
                               @ModelAttribute("form") SettingsForm form,
                               @AuthenticationPrincipal User user,
                               ModelMap modelMap) {
        if(!username.equals(user.getUsername())) {
            return "redirect: " + MvcUriComponentsBuilder.fromMappingName("UC#personalProfile").arg(0, user.getUsername()).build();
        }

        form.buildByUser(user);

       addOptionsForSettingsPage(user, modelMap);

        modelMap.addAttribute("user", user);
        return "settings";
    }

    @PostMapping("/settings/{username}")
    // BindingResult сразу после ModelAttribute
    public String changeSettings(@PathVariable String username,
                                 @Validated @ModelAttribute("form") SettingsForm form,
                                 BindingResult bindingResult,
                                 @AuthenticationPrincipal User user,
                                 ModelMap modelMap) {
        modelMap.addAttribute("user", user);

        //ToDO: сделать норм вывод ошибки
        FieldError emptyFieldsError = null;
        for(ObjectError error : bindingResult.getAllErrors()) {
            if(error.getCode() != null && error.getCode().equals(NotBlank.class.getSimpleName())) {
                emptyFieldsError = new FieldError(SettingsForm.class.getSimpleName(),
                        "emptyFieldsConstraint",
                        error.getDefaultMessage());
                break;
            }
        }

        if(emptyFieldsError != null) {
            bindingResult.addError(emptyFieldsError);
        }

        if (bindingResult.hasErrors()) {
            return "settings";
        } else {
            userService.update(user, form);

            addOptionsForSettingsPage(user, modelMap);

            modelMap.addAttribute("success", true);
        }

        return "settings";
    }

    private void addOptionsForSettingsPage(User user, ModelMap modelMap) {
        Set<String> roleName = new HashSet<>();
        for (RoleEnum roleEnum : user.getRoles()) {
            roleName.add(roleEnum.getAuthority());
        }

        modelMap.addAttribute("options", groupService.getAllEmptyGroupNumbersWithUsersGroup(user));
        modelMap.addAttribute("allOptions", groupService.getAllGroups());
        modelMap.addAttribute("roles", roleName);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

}
