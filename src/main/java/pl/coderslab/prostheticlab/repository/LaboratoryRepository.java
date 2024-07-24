package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.User;

import java.util.List;
import java.util.Set;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

}
