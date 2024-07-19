package pl.coderslab.prostheticlab.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "work_items")
public class WorkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(value = 1, message = "musisz określić ilość")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(name = "price_per_quantity")
    private int pricePerQuantity;

    public WorkItem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public int getPricePerQuantity() {
        return pricePerQuantity;
    }

    public void setPricePerQuantity(int pricePerQuantity) {
        this.pricePerQuantity = pricePerQuantity;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", offer=" + offer +
                ", pricePerQuantity=" + pricePerQuantity +
                '}';
    }
}
