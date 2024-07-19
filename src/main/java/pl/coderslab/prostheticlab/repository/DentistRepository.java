package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Long> {


}
