package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.Work;
import pl.coderslab.prostheticlab.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/works")
public class WorkController {

    private final WorkService workService;

    private final LaboratoryService laboratoryService;

    private final DentalOfficeService dentalOfficeService;

    private final DentistService dentistService;

    private final OfferService offerService;

    public WorkController(WorkService workService, LaboratoryService laboratoryService, DentalOfficeService dentalOfficeService, DentistService dentistService, OfferService offerService) {
        this.workService = workService;
        this.laboratoryService = laboratoryService;
        this.dentalOfficeService = dentalOfficeService;
        this.dentistService = dentistService;
        this.offerService = offerService;
    }


    @GetMapping("/add/{id}")
    public String addWork(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("work", new Work());
        model.addAttribute("dentalOffices", dentalOfficeService.findByLaboratoryId(id));
        model.addAttribute("dentists", dentistService.findByLaboratoryId(id));
        model.addAttribute("offers", offerService.findByLaboratoryId(id));

        return "work/addForm";
    }

    @PostMapping("/add/{id}")
    public String add(@Valid Work work, BindingResult bindingResult, @PathVariable Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("laboratory", laboratoryService.findById(id));
            model.addAttribute("dentalOffices", dentalOfficeService.findByLaboratoryId(id));
            model.addAttribute("dentists", dentistService.findByLaboratoryId(id));
            model.addAttribute("offers", offerService.findByLaboratoryId(id));
            return "work/addForm";
        }
        Laboratory laboratory = laboratoryService.findById(id);
        List<Work> works = laboratory.getWorks();
        works.add(work);
        laboratory.setWorks(works);

        int totalPrice = work.getQuantity() * work.getOffer().getUnitPrice();
        work.setTotalPrice(totalPrice);

        Long numberOfWorks = workService.countWorksBylaboratory(id);
        if (numberOfWorks == 0) {
            work.setWorkNumber(1L);
        } else {
            work.setWorkNumber(workService.findLastAddedWork(id).getWorkNumber() + 1);
        }

        work.setLaboratory(laboratory);

        workService.save(work);
        return "redirect:/app/works/list/" + laboratory.getId();
    }

    @GetMapping("/list/{id}")
    public String listWorksbyLaboratory(@PathVariable Long id, Model model) {
        model.addAttribute("works", laboratoryService.findById(id).getWorks());
        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("numberOfWorks", workService.countWorksBylaboratory(id));

        return "work/list";
    }


    @GetMapping("/edit/{id}/{labId}")
    public String edit(@PathVariable("id") Long workId,
                       @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("work", workService.findById(workId));
        model.addAttribute("dentalOffices", dentalOfficeService.findByLaboratoryId(laboratoryId));
        model.addAttribute("dentists", dentistService.findByLaboratoryId(laboratoryId));
        model.addAttribute("offers", offerService.findByLaboratoryId(laboratoryId));
        return "work/editForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Work work, BindingResult bindingResult, @PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        if (bindingResult.hasErrors()) {
            model.addAttribute("laboratory", laboratoryService.findById(id));
            model.addAttribute("dentalOffices", dentalOfficeService.findByLaboratoryId(id));
            model.addAttribute("dentists", dentistService.findByLaboratoryId(id));
            model.addAttribute("offers", offerService.findByLaboratoryId(id));
            return "work/editForm";
        }
        workService.update(work);
        return "redirect:/app/works/list/" + id;
    }

    @GetMapping("/delete/{id}/{labId}")
    public String delete(@PathVariable("id") Long workId,
                         @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("work", workService.findById(workId));

        workService.delete(workService.findById(workId));
        return "redirect:/app/works/list/" + laboratoryId;
    }

    @GetMapping("/confirmDelete/{id}/{labId}")
    public String confirmDelete(@PathVariable("id") Long workId,
                                @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("work", workService.findById(workId));
        return "work/confirmDel";
    }

    @PostMapping("/find/{id}")
    public String find(@PathVariable Long id, Model model, @RequestParam String name) {

        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("patientFound", workService.findPatientByLaboratoryId(name, id));
        return "work/find";

    }
}
