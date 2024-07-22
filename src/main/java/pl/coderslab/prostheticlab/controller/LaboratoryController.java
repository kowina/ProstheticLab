package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.service.LaboratoryService;

import javax.validation.Valid;

@Controller
@RequestMapping("/laboratories")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @GetMapping("/add")
    public String addLaboratory(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        return "laboratory/addForm";
    }

    @PostMapping("/add")
    public String add(@Valid Laboratory laboratory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "laboratory/addForm";
        }
        laboratoryService.save(laboratory);
        return "redirect:/laboratories/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "laboratory/editForm";
    }

    @PostMapping("/edit")
    public String edit(@Valid Laboratory laboratory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "laboratory/editForm";
        }
        laboratoryService.update(laboratory);
        return "redirect:/laboratories/list";
    }

    @GetMapping("/list")
    public String listLaboratory(Model model) {
        model.addAttribute("laboratories", laboratoryService.getAll());
        return "laboratory/list";
    }
}
