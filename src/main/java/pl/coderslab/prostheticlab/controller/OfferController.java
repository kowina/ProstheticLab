package pl.coderslab.prostheticlab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.Offer;
import pl.coderslab.prostheticlab.domain.SampleOffer;
import pl.coderslab.prostheticlab.service.LaboratoryService;
import pl.coderslab.prostheticlab.service.OfferService;
import pl.coderslab.prostheticlab.service.SampleOfferService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/app/offers")
public class OfferController {

    private final OfferService offerService;

    private final LaboratoryService laboratoryService;

    private final SampleOfferService sampleOfferService;


    public OfferController(OfferService offerService, LaboratoryService laboratoryService, SampleOfferService sampleOfferService) {
        this.offerService = offerService;
        this.laboratoryService = laboratoryService;
        this.sampleOfferService = sampleOfferService;
    }

    @ModelAttribute("sampleOffers")
    public List<SampleOffer> getSampleOffers() {
        return sampleOfferService.getSampleOffers();
    }

    @GetMapping("/add/{id}")
    public String addOffer(@PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        model.addAttribute("offer", new Offer());
        return "offer/addForm";
    }

    @PostMapping("/add/{id}")
    public String add(@Valid Offer offer, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "offer/addForm";
        }
        Laboratory laboratory = laboratoryService.findById(id);
        Set<Offer> offers = laboratory.getOffers();
        offers.add(offer);
        laboratory.setOffers(offers);
        offerService.save(offer);
        return "redirect:/app/offers/list/"+laboratory.getId();
    }

    @GetMapping("/edit/{id}/{labId}")
    public String edit(@PathVariable("id") Long offerId,
                       @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("offer", offerService.getById(offerId));
        return "offer/editForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Offer offer, BindingResult bindingResult, @PathVariable Long id, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(id));
        if (bindingResult.hasErrors()) {
            return "offer/editForm";
        }
        offerService.update(offer);
        return "redirect:/app/offers/list/"+id;
    }

    @GetMapping("/list/{id}")
    public String listOffersbyLaboratory(@PathVariable Long id, Model model) {
        model.addAttribute("offers", laboratoryService.findById(id).getOffers());
        model.addAttribute("laboratory", laboratoryService.findById(id));
        return "offer/list";
    }

    @GetMapping("/delete/{id}/{labId}")
    public String delete(@PathVariable("id") Long offerId,
                         @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("offer", offerService.getById(offerId));

        offerService.delete(offerService.getById(offerId));
        return "redirect:/app/offers/list/"+laboratoryId;
    }

    @GetMapping("/confirmDelete/{id}/{labId}")
    public String confirmDelete(@PathVariable("id") Long offerId,
                                @PathVariable("labId") Long laboratoryId, Model model) {
        model.addAttribute("laboratory", laboratoryService.findById(laboratoryId));
        model.addAttribute("offer", offerService.getById(offerId));
        return "offer/confirmDel";
    }

}
