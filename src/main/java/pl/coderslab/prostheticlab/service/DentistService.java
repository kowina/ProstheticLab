package pl.coderslab.prostheticlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.repository.DentistRepository;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void save(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public List<Dentist> getAll() {
        return dentistRepository.findAll();
    }

    public void delete(Dentist dentist) {
        dentistRepository.delete(dentist);
    }
}
