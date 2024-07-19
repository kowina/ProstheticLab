package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Laboratory;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

}
