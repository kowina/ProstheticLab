package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
