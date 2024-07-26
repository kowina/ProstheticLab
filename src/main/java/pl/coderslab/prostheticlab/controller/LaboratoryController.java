package pl.coderslab.prostheticlab.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.User;
import pl.coderslab.prostheticlab.service.LaboratoryService;
import pl.coderslab.prostheticlab.service.user.CurrentUser;
import pl.coderslab.prostheticlab.service.user.UserServiceImpl;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/app/laboratories")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    private final UserServiceImpl userService;

    public LaboratoryController(LaboratoryService laboratoryService, UserServiceImpl userService) {
        this.laboratoryService = laboratoryService;
        this.userService = userService;
    }


    @ModelAttribute("users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/choice/{id}")
    public String choice(@PathVariable Long id, Model model) {
        Set<Laboratory> userLaboratories = userService.findById(id).getLaboratories();
        model.addAttribute("laboratories", userLaboratories);
        if(userLaboratories.size() == 1){
            Laboratory userLaboratory = userLaboratories.iterator().next();
            model.addAttribute("laboratory", userLaboratory);
        return "redirect:/app/laboratories/home/"+userLaboratory.getId();
        }
        return "laboratory/choice";
    }

    @GetMapping("/home/{id}")
    public String home(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "laboratory/homeLab";

    }

    @GetMapping("/add")
    public String addLaboratory(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("laboratory", new Laboratory());

        return "laboratory/addForm";

    }

    @PostMapping("/add")
    public String add(@Valid Laboratory laboratory, BindingResult bindingResult, @AuthenticationPrincipal CurrentUser customUser) {
        if (bindingResult.hasErrors()) {
            return "laboratory/addForm";
        }
        User user = customUser.getUser();
        Set<Laboratory> laboratories = user.getLaboratories();
        if (laboratories != null) {
            laboratories.add(laboratory);
        }else {
            laboratories = new HashSet<>();
            laboratories.add(laboratory);
        }
        user.setLaboratories(laboratories);
        userService.update(user);
        laboratoryService.save(laboratory);
        return "redirect:/app/laboratories/choice/"+user.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "laboratory/editForm";
    }

    @PostMapping("/edit")
    public String edit(@Valid Laboratory laboratory, BindingResult bindingResult, @AuthenticationPrincipal CurrentUser customUser) {
        if (bindingResult.hasErrors()) {
            return "laboratory/editForm";
        }
        laboratoryService.update(laboratory);
        return "redirect:/app/laboratories/get/"+laboratory.getId();
    }

    @GetMapping("/list")
    public String listLaboratory(Model model) {
        model.addAttribute("laboratories", laboratoryService.getAll());
        return "laboratory/adminList";
    }

    @GetMapping("/list/{id}")
    public String listLaboratoryByUser(@PathVariable Long id, Model model) {
        model.addAttribute("laboratories", userService.findById(id).getLaboratories());
        return "laboratory/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        Set<Laboratory> laboratories = userService.findById(user.getId()).getLaboratories();
        laboratories.remove(laboratoryService.findById(id));
        user.setLaboratories(laboratories);
        userService.update(user);

        laboratoryService.deleteById(id);
        return "redirect:/app/laboratories/choice/"+customUser.getUser().getId();
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "laboratory/confirmDel";
    }

    @GetMapping("get/{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
//        model.addAttribute("laboratoryName", laboratoryService.findById(id).getName());
        return "laboratory/details";
    }
}
