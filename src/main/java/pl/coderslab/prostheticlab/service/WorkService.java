package pl.coderslab.prostheticlab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Work;
import pl.coderslab.prostheticlab.repository.WorkRepository;

import java.util.List;

@Service
public class WorkService {

    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public void save(Work work) {
        workRepository.save(work);
    }

    public void update(Work work) {
        workRepository.save(work);
    }

    public Work findById(Long id) {
        return workRepository.findById(id).orElse(null);
    }

    public void delete(Work work) {
        workRepository.delete(work);
    }

    public List<Work> getAll() {
        return workRepository.findAll();
    }
}
