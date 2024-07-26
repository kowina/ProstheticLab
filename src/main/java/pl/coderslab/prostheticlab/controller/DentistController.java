package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.domain.DentalOffice;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.service.DentistService;
import pl.coderslab.prostheticlab.service.LaboratoryService;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/app/dentists")
public class DentistController {

    private final DentistService dentistService;

    private final LaboratoryService laboratoryService;

    public DentistController(DentistService dentistService, LaboratoryService laboratoryService) {
        this.dentistService = dentistService;
        this.laboratoryService = laboratoryService;
    }


    @GetMapping("/add/{id}")
    public String addDentist(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("dentist", new Dentist());
        return "dentist/addForm";
    }

    @PostMapping("/add/{id}")
    public String add(@Valid Dentist dentist, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "dentist/addForm";
        }
        Laboratory laboratory = laboratoryService.findById(id);
        Set<Dentist> dentists = laboratory.getDentists();
        dentists.add(dentist);
        laboratory.setDentists(dentists);
        dentistService.save(dentist);
        return "redirect:/app/dentists/list/" + laboratory.getId();
    }

    @GetMapping("/edit/{id}/{labId}")
    public String edit(@PathVariable("id") Long dentistId,
                       @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentist", dentistService.findById(dentistId));
        return "dentist/editForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Dentist dentist, BindingResult bindingResult, @PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        if (bindingResult.hasErrors()) {
            return "dentist/editForm";
        }
        dentistService.update(dentist);
        return "redirect:/app/dentists/get/"+dentist.getId()+"/"+id;
    }

    @GetMapping("/list")
    public String listDentists(Model model) {
        model.addAttribute("dentists", dentistService.getAll());
        return "dentist/list";
    }
    @GetMapping("/list/{id}")
    public String listDentistsbyLaboratory(@PathVariable Long id, Model model) {
        model.addAttribute("dentists", laboratoryService.findById(id).getDentists());
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "dentist/list";
    }

    @GetMapping("get/{id}/{labId}")
    public String get(@PathVariable("id") Long dentistId,
                      @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentist", dentistService.findById(dentistId));
        return "dentist/details";
    }

    @GetMapping("/delete/{id}/{labId}")
    public String delete(@PathVariable("id") Long dentistId,
                         @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentist", dentistService.findById(dentistId));

        dentistService.delete(dentistService.findById(dentistId));
        return "redirect:/app/dentists/list/"+laboratoryId;
    }

    @GetMapping("/confirmDelete/{id}/{labId}")
    public String confirmDelete(@PathVariable("id") Long dentistId,
                                @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentist", dentistService.findById(dentistId));
        return "dentist/confirmDel";
    }

}
