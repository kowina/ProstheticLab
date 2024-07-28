package pl.coderslab.prostheticlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.prostheticlab.domain.Work;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 ORDER BY works.id DESC LIMIT 1", nativeQuery = true)
    Work findLastAddedWork(Long id);

    @Query(value = "SELECT COUNT(*) FROM works WHERE laboratory_id = ?1", nativeQuery = true)
    Long countWorksBylab(Long laboratoryId);

    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 ORDER BY works.id DESC LIMIT 3", nativeQuery = true)
    List<Work> findLastThreeAddedWork(Long id);

    @Query(value = "SELECT * FROM works where patient LIKE %?1% AND laboratory_id = ?2", nativeQuery = true)
    List<Work> findPatientByLaboratoryId(String name, Long laboratoryId);

    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 AND dentist_id = ?2 ORDER BY works.id DESC LIMIT 3", nativeQuery = true)
    List<Work> findLastThreeAddedWorkByDentist(Long laboratoryId, Long dentistId);

    @Query(value = "SELECT COUNT(*) FROM works WHERE laboratory_id = ?1 AND dentist_id = ?2", nativeQuery = true)
    Long countWorksByDentist(Long laboratoryId, Long dentistId);

    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 AND dentist_id = ?2 ORDER BY works.id DESC", nativeQuery = true)
    List<Work> findAllWorkByDentist(Long laboratoryId, Long dentistId);


    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 AND dental_office_id = ?2 ORDER BY works.id DESC LIMIT 3", nativeQuery = true)
    List<Work> findLastThreeAddedWorkByDentalOffice(Long laboratoryId, Long dentalOfficeId);

    @Query(value = "SELECT COUNT(*) FROM works WHERE laboratory_id = ?1 AND dental_office_id = ?2", nativeQuery = true)
    Long countWorksByDentalOffice(Long laboratoryId, Long dentalOfficeId);

    @Query(value = "SELECT *  FROM works  WHERE laboratory_id = ?1 AND dental_office_id = ?2 ORDER BY works.id DESC", nativeQuery = true)
    List<Work> findAllWorkByDentalOffice(Long laboratoryId, Long dentalOfficeId);

}



