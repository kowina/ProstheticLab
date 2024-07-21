package pl.coderslab.prostheticlab.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentists")
public class Dentist {

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

    @OneToMany
    @JoinColumn(name = "id_dentist")
    private Set<Patient> patients = new HashSet<>();

    @OneToMany(mappedBy = "dentist")
    private Set<Work> works = new HashSet<>();

    public Dentist() {}

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

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patients=" + patients +
                '}';
    }
}
