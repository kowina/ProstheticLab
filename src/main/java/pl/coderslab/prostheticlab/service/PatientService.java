package pl.coderslab.prostheticlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.Patient;
import pl.coderslab.prostheticlab.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
