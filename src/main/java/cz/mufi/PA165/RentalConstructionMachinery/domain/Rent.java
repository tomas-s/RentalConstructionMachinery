package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RENT")
public class Rent {

    private Long id;
    private Machine machine;
    private Customer customer;
    private Date rentSinceDate;
    private Date rentTillDate;

    public Integer getLengthOfRent() {

        throw new UnsupportedOperationException();

        // if (rentSinceDate == null || rentTillDate == null) {
        // return null;
        // }

        // TODO: till - since = length
    }

    /*
     * Generated
     */

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
