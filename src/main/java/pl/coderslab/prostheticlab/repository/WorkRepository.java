package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {

}
