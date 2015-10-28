package cz.mufi.PA165.RentalConstructionMachinery.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Matej Jakimov
 */
@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Machine machine;

    @ManyToOne(optional=false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (id != null ? !id.equals(rent.id) : rent.id != null) return false;
        if (machine != null ? !machine.equals(rent.machine) : rent.machine != null) return false;
        if (customer != null ? !customer.equals(rent.customer) : rent.customer != null) return false;
        if (rentSinceDate != null ? !rentSinceDate.equals(rent.rentSinceDate) : rent.rentSinceDate != null)
            return false;
        return !(rentTillDate != null ? !rentTillDate.equals(rent.rentTillDate) : rent.rentTillDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (machine != null ? machine.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (rentSinceDate != null ? rentSinceDate.hashCode() : 0);
        result = 31 * result + (rentTillDate != null ? rentTillDate.hashCode() : 0);
        return result;
    }
}
