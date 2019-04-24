package ru.kpfu.itis.greenmapc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.greenmapc.model.User;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getAdminPage(@AuthenticationPrincipal User user,
                               ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "admin/adminMain";
    }
}
