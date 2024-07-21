package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import pl.coderslab.prostheticlab.service.user.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


}
