package pl.coderslab.prostheticlab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.DentalOffice;
import pl.coderslab.prostheticlab.domain.Dentist;
import pl.coderslab.prostheticlab.repository.DentalOfficeRepository;

import java.util.List;

@Service
public class DentalOfficeService  {

    private final DentalOfficeRepository dentalOfficeRepository;

    public DentalOfficeService(DentalOfficeRepository dentalOfficeRepository) {
        this.dentalOfficeRepository = dentalOfficeRepository;
    }

    public void save(DentalOffice dentalOffice) {
        dentalOfficeRepository.save(dentalOffice);
    }

    public void update(DentalOffice dentalOffice) {
        dentalOfficeRepository.save(dentalOffice);
    }


    public void delete(DentalOffice dentalOffice) {
        dentalOfficeRepository.delete(dentalOffice);
    }

    public DentalOffice getById(Long id) {
        return dentalOfficeRepository.findById(id).orElse(null);
    }

    public List<DentalOffice> getAll() {
        return dentalOfficeRepository.findAll();
    }
}
