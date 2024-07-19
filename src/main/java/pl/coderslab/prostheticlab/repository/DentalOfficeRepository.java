package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.DentalOffice;

public interface DentalOfficeRepository extends JpaRepository<DentalOffice, Long> {

}
