package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
