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
    //@ResponseBody
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")

    public String about(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("user", customUser.getUser());
        if(customUser.getUsername().equals("admin")) {
            return "redirect:admin/panel";
        }else {

            return "about";
        }
    }
}
