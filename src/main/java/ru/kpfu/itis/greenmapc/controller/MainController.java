package ru.kpfu.itis.greenmapc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.service.MainPageService;

import java.util.List;

@Controller
public class MainController {

    private MainPageService mainPageService;

    @RequestMapping(value = "/")
    public String index(@AuthenticationPrincipal User user,
                        ModelMap modelMap) {
        if(user != null) {
            modelMap.addAttribute("user", user);
        }
        return "mainPage";
    }

    @GetMapping("/coaches")
    public String getCoaches(@RequestParam(value = "criteria", required = false) String criteria,
                             @AuthenticationPrincipal User user,
                             ModelMap modelMap) {
        List<User> userList;
        if(criteria != null && !criteria.isEmpty()) {
            userList = mainPageService.getAllCoachesByCriteria(criteria);
            modelMap.addAttribute("criteria", criteria);
        } else {
            userList = mainPageService.getAllCoaches();
        }

        modelMap.addAttribute("user", user);
        modelMap.addAttribute("pageTitle", "Наши тренеры");
        modelMap.addAttribute("users", userList);
        modelMap.addAttribute("page", "getCoaches");

        return "userList";
    }

    @GetMapping("/athletes")
    public String getAthletes(@RequestParam(value = "criteria", required = false) String criteria,
                              @AuthenticationPrincipal User user,
                              ModelMap modelMap) {
        List<User> userList;
        if(criteria != null && !criteria.isEmpty()) {
            userList = mainPageService.getAllAthletesByCriteria(criteria);
            modelMap.addAttribute("criteria", criteria);
        } else {
            userList = mainPageService.getAllAthletes();
        }

        modelMap.addAttribute("user", user);
        modelMap.addAttribute("pageTitle", "Наши спортсмены");
        modelMap.addAttribute("users", userList);
        modelMap.addAttribute("page", "getAthletes");

        return "userList";
    }

    @Autowired
    public void setMainPageService(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }
}
