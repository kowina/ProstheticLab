package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.SampleOffer;

public interface SampleOfferRepository extends JpaRepository<SampleOffer, Long> {
}
