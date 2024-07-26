package pl.coderslab.prostheticlab.domain;


import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dental_offices")
public class DentalOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, message = "nazwa musi mieć przynajmniej 2 znaki")
    private String name;

    @NotBlank
    @NIP
    private String nip;

    @NotBlank
    @Size(min = 2, message = "nazwa ulicy musi mieć przynajmniej 2 znaki")
    private String street;

    @NotBlank
    @Column(name = "street_number")
    @Min(1)
    @Max(4)
    private String streetNumber;

    @Column(name = "locale_number")
    private String localeNumber;

    @NotBlank
    @Size(min = 5, max = 6, message = "niewłaściwy kod pocztowy")
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Size(min = 3, message = "nazwa miasta nie może mieć mniej niż 3 litery")
    private String city;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 9, max = 9, message = "podaj poprawny numer telefonu")
    private String phone;

    @OneToMany(mappedBy = "dentalOffice")
    private Set<Work> works = new HashSet<>();


    public DentalOffice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip( String nip) {
        this.nip = nip;
    }

    public  String getStreet() {
        return street;
    }

    public void setStreet( String street) {
        this.street = street;
    }

    public  String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocaleNumber() {
        return localeNumber;
    }

    public void setLocaleNumber(String localeNumber) {
        this.localeNumber = localeNumber;
    }

    public  String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "DentalOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", localeNumber='" + localeNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
