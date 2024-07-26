package pl.coderslab.prostheticlab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Offer;
import pl.coderslab.prostheticlab.repository.OfferRepository;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public List<Offer> getAll() {
        return offerRepository.findAll();
    }

    public Offer getById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

     public void delete(Offer offer) {
        offerRepository.delete(offer);
     }

     public void deleteById(Long id) {
        offerRepository.deleteById(id);
     }
     public void update(Offer offer) {
        offerRepository.save(offer);
     }
}
