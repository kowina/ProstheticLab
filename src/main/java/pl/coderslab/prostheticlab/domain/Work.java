package pl.coderslab.prostheticlab.domain;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_number")
    private Long workNumber;

    @Size(max = 600)
    private String description;

    @NotBlank
    private LocalDate created;

    @NotBlank
    @Future
    private LocalDate finished;

    @Column(name = "total_price")
    private int totalPrice;

    @OneToMany
    @JoinColumn(name = "id_work")
    private Set<WorkItem> workItems = new HashSet<>();

    @ManyToOne
    private Laboratory laboratory;

    @ManyToOne
    private DentalOffice dentalOffice;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Patient patient;

    public Work() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Long workNumber) {
        this.workNumber = workNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public  LocalDate getFinished() {
        return finished;
    }

    public void setFinished(LocalDate finished) {
        this.finished = finished;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<WorkItem> getWorkItems() {
        return workItems;
    }

    public void setWorkItems(Set<WorkItem> workItems) {
        this.workItems = workItems;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public DentalOffice getDentalOffice() {
        return dentalOffice;
    }

    public void setDentalOffice(DentalOffice dentalOffice) {
        this.dentalOffice = dentalOffice;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workNumber=" + workNumber +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", finished=" + finished +
                ", totalPrice=" + totalPrice +
                ", workItems=" + workItems +
                ", laboratory=" + laboratory +
                ", dentalOffice=" + dentalOffice +
                ", dentist=" + dentist +
                ", patient=" + patient +
                '}';
    }
}