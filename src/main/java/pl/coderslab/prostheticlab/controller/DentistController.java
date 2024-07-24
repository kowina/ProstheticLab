package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.service.DentistService;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/dentists")
public class DentistController {
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }


    @GetMapping("/add")
    public String addDentist(Model model) {
        model.addAttribute("dentist", new Dentist());
        return "dentist/addForm";
    }

    @PostMapping("/add")
    public String add(@Valid Dentist dentist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dentist/addForm";
        }
        dentistService.save(dentist);
        return "redirect:/app/dentists/list";
    }

    @GetMapping("/edit/{id}")
    public String editDentist(@PathVariable Long id, Model model) {
        model.addAttribute("dentist", dentistService.findById(id));
        return "dentist/editForm";
    }

    @PostMapping("/edit")
    public String edit(@Valid Dentist dentist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dentist/editForm";
        }
        dentistService.update(dentist);
        return "redirect:/app/dentists/list";
    }

    @GetMapping("/list")
    public String listDentists(Model model) {
        model.addAttribute("dentists", dentistService.getAll());
        return "dentist/list";
    }

}
