package cz.mufi.PA165.RentalConstructionMachinery.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Machine machine;

    @ManyToOne
    private Customer customer;

    @Column(nullable = false)
    private Date rentSinceDate;

    @Column(nullable = false)
    private Date rentTillDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getRentSinceDate() {
        return rentSinceDate;
    }

    public void setRentSinceDate(Date rentSinceDate) {
        this.rentSinceDate = rentSinceDate;
    }

    public Date getRentTillDate() {
        return rentTillDate;
    }

    public void setRentTillDate(Date rentTillDate) {
        this.rentTillDate = rentTillDate;
    }
}
