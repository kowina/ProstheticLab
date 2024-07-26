package pl.coderslab.prostheticlab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.prostheticlab.domain.SampleOffer;
import pl.coderslab.prostheticlab.repository.SampleOfferRepository;

import java.util.List;

@Service
@Transactional
public class SampleOfferService {
    private final SampleOfferRepository sampleOfferRepository;

    public SampleOfferService(SampleOfferRepository sampleOfferRepository) {
        this.sampleOfferRepository = sampleOfferRepository;
    }

    public List<SampleOffer> getSampleOffers() {
        return sampleOfferRepository.findAll();
    }
    public SampleOffer getSampleOfferById(Long id) {
        return sampleOfferRepository.findById(id).orElse(null);
    }
}
