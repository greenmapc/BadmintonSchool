package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.greenmapc.exception.CreatingException;
import ru.kpfu.itis.greenmapc.form.SignUpForm;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Controller
public class SignController {

    private UserService userService;


    @GetMapping("/signin")
    public String signIn(HttpServletRequest request,
                         ModelMap modelMap) {
        if(request.getParameterMap().containsKey("error")) {
            modelMap.put("error", "Неверный логин или пароль");
        }
        return "signIn";
    }

    @GetMapping("/signup")
    public String signUpPage(ModelMap modelMap) {
        modelMap.put("signUpForm", new SignUpForm());
        return "signUp";
    }


    @PostMapping("/signup")
    public String signUp(@Validated @ModelAttribute("signUpForm") SignUpForm signUpForm,
                         BindingResult bindingResult) {
        for(ObjectError error : bindingResult.getAllErrors()) {
            if(error.getCode() != null &&
                    (error.getCode().equals(NotBlank.class.getSimpleName()) || error.getCode().equals(NotNull.class.getSimpleName()))) {
                bindingResult.rejectValue("emptyFieldsConstraint", "emptyFields");
                break;
            }
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "signUp";
        }

        try {
            userService.signUp(signUpForm);
            return "redirect:signin";
        } catch (CreatingException e) {
            bindingResult.rejectValue("login", "exit.user");
            return "signUp";
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
