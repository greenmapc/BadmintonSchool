package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kpfu.itis.greenmapc.exception.NotFoundException;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.GroupService;

import java.util.Optional;

@Controller
public class GroupController {

    private GroupService groupService;

    @GetMapping("/group/{groupNumber}")
    public String groupPage(@PathVariable int groupNumber,
                            @AuthenticationPrincipal User user,
                            ModelMap modelMap) {
        Optional<Group> group = groupService.getGroupByNumber(groupNumber);
        if(!group.isPresent()) {
            throw new NotFoundException("Группа " + groupNumber + " еще не существует!");
        }

        modelMap.addAttribute("user", user);
        modelMap.addAttribute("group", group.get());
        return "group";
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
