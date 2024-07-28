package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.prostheticlab.domain.Dentist;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Long> {

    @Query(value = "SELECT * FROM dentists WHERE id_laboratory = ?1", nativeQuery = true)
    List<Dentist> findByLaboratoryId(Long laboratoryId);
}
