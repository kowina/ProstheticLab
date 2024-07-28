package pl.coderslab.prostheticlab.service;


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

    public Work findLastAddedWork(Long id) {
        return workRepository.findLastAddedWork(id);
    }

    public Long countWorksBylaboratory(Long laboratoryId) {
        return workRepository.countWorksBylab(laboratoryId);
    }

    public List<Work> findLastThreeAddedWork(Long laboratoryId) {
        return workRepository.findLastThreeAddedWork(laboratoryId);
    }

    public List<Work> findPatientByLaboratoryId(String name, Long laboratoryId) {
        return workRepository.findPatientByLaboratoryId(name, laboratoryId);
    }

    public List<Work> findLastThreeAddedWorkByDentist(Long laboratoryId, Long dentistId) {
        return workRepository.findLastThreeAddedWorkByDentist(laboratoryId, dentistId);
    }

    public Long countWorksByDentist(Long laboratoryId, Long dentistId) {
        return workRepository.countWorksByDentist(laboratoryId, dentistId);
    }

    public List<Work> findAllWorkByDentist(Long laboratoryId, Long dentistId) {
        return workRepository.findAllWorkByDentist(laboratoryId, dentistId);
    }

    public List<Work> findLastThreeAddedWorkByDentalOffice(Long laboratoryId, Long dentalOfficeId) {
        return workRepository.findLastThreeAddedWorkByDentalOffice(laboratoryId, dentalOfficeId);
    }

    public Long countWorksByDentalOffice(Long laboratoryId, Long dentalOfficeId) {
        return workRepository.countWorksByDentalOffice(laboratoryId, dentalOfficeId);
    }

    public List<Work> findAllWorkByDentalOffice(Long laboratoryId, Long dentalOfficeId) {
        return workRepository.findAllWorkByDentalOffice(laboratoryId, dentalOfficeId);
    }
}
