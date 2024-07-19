package pl.coderslab.prostheticlab.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "imię musi mieć przynajmniej 3 litery")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3, message = "nazwisko musi mieć przynajmniej 3 litery")
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    private DentalOffice dentalOffice;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Laboratory laboratory;

    @OneToMany(mappedBy = "patient")
    private Set<Work> works = new HashSet<>();

    public Patient() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dentalOffice=" + dentalOffice +
                ", dentist=" + dentist +
                ", laboratory=" + laboratory +
                '}';
    }
}

