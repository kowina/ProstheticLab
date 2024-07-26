package pl.coderslab.prostheticlab.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sample_offer")
public class SampleOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, message = "nazwa musi mieć przynajmniej 2 znaki")
    private String name;

    public SampleOffer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 2, message = "nazwa musi mieć przynajmniej 2 znaki") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 2, message = "nazwa musi mieć przynajmniej 2 znaki") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SampleOffer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
