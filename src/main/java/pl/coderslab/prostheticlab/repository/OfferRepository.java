package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.prostheticlab.domain.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {


    @Query(value = "SELECT * FROM offers WHERE id_laboratory = ?1", nativeQuery = true)
    List<Offer> findByLaboratoryId(Long laboratoryId);
}
