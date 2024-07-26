package pl.coderslab.prostheticlab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.service.user.CurrentUser;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/app")
    public String app(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("user", customUser.getUser());

        if (customUser.getUsername().equals("admin")) {
            return "redirect:admin/panel";
        }

        if (customUser.getUser().getLaboratories().isEmpty()) {
            return "redirect:/app/laboratories/add";

        }else {
            return "redirect:/app/laboratories/choice/"+customUser.getUser().getId();

        }
    }

}
