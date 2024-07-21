package pl.coderslab.prostheticlab.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.service.CurrentUser;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/panel")
    public String panel(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("user", customUser.getUser());
        return "admin/panel";
    }

}
