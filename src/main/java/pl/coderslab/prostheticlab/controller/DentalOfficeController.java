package pl.coderslab.prostheticlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.prostheticlab.domain.DentalOffice;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.service.DentalOfficeService;
import pl.coderslab.prostheticlab.service.LaboratoryService;
import pl.coderslab.prostheticlab.service.WorkService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/dentalOffices")
public class DentalOfficeController {


    private final DentalOfficeService dentalOfficeService;

    private final LaboratoryService laboratoryService;

    private final WorkService workService;

    public DentalOfficeController(DentalOfficeService dentalOfficeService, LaboratoryService laboratoryService, WorkService workService) {
        this.dentalOfficeService = dentalOfficeService;
        this.laboratoryService = laboratoryService;
        this.workService = workService;
    }


    @GetMapping("/add/{id}")
    public String addDentalOfficeToLaboratoryById(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("dentalOffice", new DentalOffice());

        return "dentalOffice/addForm";
    }

    @PostMapping("/add/{id}")
    public String add(@Valid DentalOffice dentalOffice, BindingResult bindingResult, Model model, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("laboratory", laboratoryService.findById(id));
            return "dentalOffice/addForm";
        }
        Laboratory laboratory = laboratoryService.findById(id);
        List<DentalOffice> dentalOffices = laboratory.getDentalOffices();
        dentalOffices.add(dentalOffice);
        laboratory.setDentalOffices(dentalOffices);
        dentalOfficeService.save(dentalOffice);
        return "redirect:/app/dentalOffices/list/" + laboratory.getId();
    }

    @GetMapping("/list/{id}")
    public String listDentalOfficesByLaboratory(@PathVariable Long id, Model model) {
        model.addAttribute("dentalOffices", laboratoryService.findById(id).getDentalOffices());
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "dentalOffice/list";
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        model.addAttribute("dentalOffices", dentalOfficeService.getAll());
        return "dentalOffice/adminList";
    }

    @GetMapping("/list/{id}/{labId}")
    public String AllWorksbyDentalOffice(@PathVariable("id") Long id,
                                         @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("works", workService.findAllWorkByDentalOffice(laboratoryId, id));
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("numberOfWorks", workService.countWorksByDentalOffice(laboratoryId, id));

        return "work/list";

    }

    @GetMapping("/edit/{id}/{labId}")
    public String edit(@PathVariable("id") Long dentalOfficeId,
                       @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentalOffice", dentalOfficeService.getById(dentalOfficeId));
        return "dentalOffice/editForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid DentalOffice dentalOffice, BindingResult bindingResult, @PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        if (bindingResult.hasErrors()) {
            return "dentalOffice/editForm";
        }
        dentalOfficeService.update(dentalOffice);
        return "redirect:/app/dentalOffices/get/" + dentalOffice.getId() + "/" + id;
    }

    @GetMapping("get/{id}/{labId}")
    public String get(@PathVariable("id") Long dentalOfficeId,
                      @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentalOffice", dentalOfficeService.getById(dentalOfficeId));
        model.addAttribute("lastThree", workService.findLastThreeAddedWorkByDentalOffice(laboratoryId, dentalOfficeId));
        model.addAttribute("numberOfWorks", workService.countWorksByDentalOffice(laboratoryId, dentalOfficeId));
        return "dentalOffice/details";
    }

    @GetMapping("/delete/{id}/{labId}")
    public String delete(@PathVariable("id") Long dentalOfficeId,
                         @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentalOffice", dentalOfficeService.getById(dentalOfficeId));

        dentalOfficeService.delete(dentalOfficeService.getById(dentalOfficeId));
        return "redirect:/app/dentalOffices/list/" + laboratoryId;
    }

    @GetMapping("/confirmDelete/{id}/{labId}")
    public String confirmDelete(@PathVariable("id") Long dentalOfficeId,
                                @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("dentalOffice", dentalOfficeService.getById(dentalOfficeId));
        return "dentalOffice/confirmDel";
    }

}

