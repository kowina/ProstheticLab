package pl.coderslab.prostheticlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.User;
import pl.coderslab.prostheticlab.repository.LaboratoryRepository;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private final LaboratoryRepository laboratoryRepository;

    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    public void save(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }
    public List<Laboratory> getAll(){
        return laboratoryRepository.findAll();
    }

    public void delete(Laboratory laboratory) {
        laboratoryRepository.delete(laboratory);
    }

}
