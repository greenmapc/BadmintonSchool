package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.itis.greenmapc.dto.GroupScheduleDto;
import ru.kpfu.itis.greenmapc.exception.CreatingException;
import ru.kpfu.itis.greenmapc.form.ScheduleForm;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.GroupService;
import ru.kpfu.itis.greenmapc.service.ScheduleService;
import ru.kpfu.itis.greenmapc.util.SelectListCreator;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private GroupService groupService;
    private ScheduleService scheduleService;

    @GetMapping("/")
    public String getAdminPage(@AuthenticationPrincipal User user,
                               ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "admin/adminMain";
    }

    @GetMapping("/groups")
    public String getGroupList(@AuthenticationPrincipal User user,
                              ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groups", groupService.getAllGroups());
        return "admin/groupList";
    }

    @GetMapping("/settings/group/{groupNumber}")
    public String getGroupSettings(@PathVariable int groupNumber,
                                   @ModelAttribute("group") Group group,
                                   @AuthenticationPrincipal User user,
                                   ModelMap modelMap) {
        Optional<Group> optionalGroup = groupService.getGroupByNumber(groupNumber);
        if(!optionalGroup.isPresent()) {
            return "redirect: " + MvcUriComponentsBuilder.fromMappingName("AC#getGroupList").build();
        }

        groupService.createPrototype(optionalGroup.get(), group);

        modelMap.addAttribute("schedule", SelectListCreator.scheduleCreate(scheduleService.findAll()));
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groupNumber", groupNumber);

        return "admin/groupSettings";
    }

    @PostMapping("/settings/group/{groupNumber}")
    public String changeGroupSettings(@PathVariable int groupNumber,
                                      @Validated @ModelAttribute("group") Group group,
                                      BindingResult bindingResult,
                                      @AuthenticationPrincipal User user,
                                      ModelMap modelMap) {

        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("inputError", "Все поля должны быть корректно заполнены");
        } else {
            try {
                groupService.update(group);
                modelMap.addAttribute("success", "Информация обновлена");
            } catch (CreatingException e) {
                modelMap.addAttribute("error", "Группа с таким номером уже существует");
            }
        }

        modelMap.addAttribute("schedule", SelectListCreator.scheduleCreate(scheduleService.findAll()));
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groupNumber", groupNumber);

        return "admin/groupSettings";
    }

    @GetMapping("/create/group")
    public String getCreatingPage(@AuthenticationPrincipal User user,
                                  ModelMap modelMap) {
        modelMap.addAttribute("schedule", SelectListCreator.scheduleCreate(scheduleService.findAll()));
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("group", new Group());
        return "admin/newGroup";
    }

    @PostMapping("/create/group")
    public String createGroup(@AuthenticationPrincipal User user,
                              ModelMap modelMap,
                              @Validated @ModelAttribute("group") Group group,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            modelMap.addAttribute("inputError", "Все поля должны быть корректно заполнены");
        } else {
            try {
                groupService.save(group);
                modelMap.addAttribute("success", "Группа создана");
            } catch (CreatingException e) {
                modelMap.addAttribute("error", "Группа с таким номером уже существует");
            }
        }

        modelMap.addAttribute("schedule", SelectListCreator.scheduleCreate(scheduleService.findAll()));
        modelMap.addAttribute("user", user);
        return "admin/newGroup";
    }

    @GetMapping("/create/schedule")
    public String getCreatingSchedulePage(@AuthenticationPrincipal User user,
                                          ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("schedule", new ScheduleForm());
        modelMap.addAttribute("weekdays", SelectListCreator.weekdaysCreate());

        return "admin/newSchedule";
    }

    @PostMapping("/create/schedule")
    public String createSchedule(@AuthenticationPrincipal User user,
                                 @Validated @ModelAttribute("schedule") ScheduleForm schedule,
                                 BindingResult bindingResult,
                                 ModelMap modelMap) {
        try {
            scheduleService.saveFromForm(schedule);
            modelMap.addAttribute("success", "Расаписание создано");
        } catch (CreatingException e) {
            //ToDo:catch exception
        }

        modelMap.addAttribute("user", user);
        modelMap.addAttribute("weekdays", SelectListCreator.weekdaysCreate());

        return "admin/newSchedule";
    }

    @GetMapping("/schedule")
    public String getSchedule(@RequestParam(required = false, name = "sortBy") String sortBy,
                              @AuthenticationPrincipal User user,
                              ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        List<GroupScheduleDto> schedule = groupService.getSchedule(sortBy);
        modelMap.addAttribute("schedule", schedule);

        return "admin/schedule";
    }



    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
}
