package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.prostheticlab.domain.WorkItem;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
}
