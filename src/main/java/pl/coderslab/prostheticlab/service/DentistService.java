package pl.coderslab.prostheticlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.repository.DentistRepository;

import java.util.List;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void save(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public void update(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public void delete(Dentist dentist) {
        dentistRepository.delete(dentist);
    }

    public Dentist findById(Long id) {
        return dentistRepository.findById(id).orElse(null);
    }

    public List<Dentist> getAll() {
        return dentistRepository.findAll();
    }
}
