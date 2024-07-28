package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.prostheticlab.domain.DentalOffice;

import java.util.List;

public interface DentalOfficeRepository extends JpaRepository<DentalOffice, Long> {

    @Query(value = "SELECT * FROM dental_offices WHERE id_laboratory = ?1", nativeQuery = true)
    List<DentalOffice> findByLaboratoryId(Long laboratoryId);
}
