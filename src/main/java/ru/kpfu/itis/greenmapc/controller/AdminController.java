package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.GroupService;

@Controller
public class AdminController {

    private GroupService groupService;

    @GetMapping("/admin")
    public String getAdminPage(@AuthenticationPrincipal User user,
                               ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "admin/adminMain";
    }

    @GetMapping("/admin/groups")
    public String getGroupList(@AuthenticationPrincipal User user,
                              ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groups", groupService.getAllGroups());
        return "admin/groupList";
    }



    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
