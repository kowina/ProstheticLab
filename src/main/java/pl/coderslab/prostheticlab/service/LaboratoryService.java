package pl.coderslab.prostheticlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.prostheticlab.domain.Laboratory;
import pl.coderslab.prostheticlab.domain.User;
import pl.coderslab.prostheticlab.repository.LaboratoryRepository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class LaboratoryService {

    private final LaboratoryRepository laboratoryRepository;

    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    public void save(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public void update(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public void delete(Laboratory laboratory) {
        laboratoryRepository.delete(laboratory);
    }
    public void deleteById(Long id) {
        laboratoryRepository.deleteById(id);
    }

    public Laboratory findById(Long id) {
        return laboratoryRepository.findById(id).orElse(null);
    }

    public List<Laboratory> getAll(){
        return laboratoryRepository.findAll();
    }

}
