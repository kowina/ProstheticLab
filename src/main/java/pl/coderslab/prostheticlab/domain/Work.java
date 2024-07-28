package pl.coderslab.prostheticlab.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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

    //    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    //    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finished;

    @ManyToOne
    private Offer offer;

    @NotNull
    @Min(1)
    private int quantity;

    @Column(name = "total_price")
    private int totalPrice;

    @NotBlank
    @Size(min = 2)
    private String patient;

    @ManyToOne
    private Laboratory laboratory;

    @ManyToOne
    private DentalOffice dentalOffice;

    @ManyToOne
    private Dentist dentist;

    public Work() {
    }

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

    public LocalDate getFinished() {
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


    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public @NotBlank @Size(min = 2) String getPatient() {
        return patient;
    }

    public void setPatient(@NotBlank @Size(min = 2) String patient) {
        this.patient = patient;
    }

    @NotNull
    @Min(1)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull @Min(1) int quantity) {
        this.quantity = quantity;
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
                ", laboratory=" + laboratory +
                ", dentalOffice=" + dentalOffice +
                ", dentist=" + dentist +
                '}';
    }
}
