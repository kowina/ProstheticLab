package pl.coderslab.prostheticlab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.WorkItem;
import pl.coderslab.prostheticlab.repository.WorkItemRepository;

@Service
public class WorkItemService {

    @Autowired
    private final WorkItemRepository workItemRepository;

    public WorkItemService(WorkItemRepository workItemRepository) {
        this.workItemRepository = workItemRepository;
    }

    public void save(WorkItem workItem) {
        workItemRepository.save(workItem);
    }
}
