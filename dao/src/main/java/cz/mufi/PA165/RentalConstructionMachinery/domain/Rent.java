package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Matej Jakimov
 */
@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = { CascadeType.MERGE })
    private Machine machine;

    // @ManyToOne(optional = false, cascade = { CascadeType.MERGE })
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((machine == null) ? 0 : machine.hashCode());
        result = prime * result + ((rentSinceDate == null) ? 0 : rentSinceDate.hashCode());
        result = prime * result + ((rentTillDate == null) ? 0 : rentTillDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Rent))
            return false;
        Rent other = (Rent) obj;
        if (customer == null) {
            if (other.getCustomer() != null)
                return false;
        } else if (!customer.equals(other.getCustomer()))
            return false;
        if (machine == null) {
            if (other.getMachine() != null)
                return false;
        } else if (!machine.equals(other.getMachine()))
            return false;
        if (rentSinceDate == null) {
            if (other.getRentSinceDate() != null)
                return false;
        } else if (!rentSinceDate.equals(other.getRentSinceDate()))
            return false;
        if (rentTillDate == null) {
            if (other.getRentTillDate() != null)
                return false;
        } else if (!rentTillDate.equals(other.getRentTillDate()))
            return false;
        return true;
    }
}
