package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
