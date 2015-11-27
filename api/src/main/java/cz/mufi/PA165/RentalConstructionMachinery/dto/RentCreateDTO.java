package cz.mufi.PA165.RentalConstructionMachinery.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jakac on 26.11.15.
 */
public class RentCreateDTO {

    @NotNull
    private MachineDTO machine;

    @NotNull
    private CustomerDTO customer;

    @NotNull
    private Date rentSinceDate;

    @NotNull
    private Date rentTillDate;

    public MachineDTO getMachine() {
        return machine;
    }

    public void setMachine(MachineDTO machine) {
        this.machine = machine;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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

        RentCreateDTO that = (RentCreateDTO) o;

        if (machine != null ? !machine.equals(that.machine) : that.machine != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (rentSinceDate != null ? !rentSinceDate.equals(that.rentSinceDate) : that.rentSinceDate != null)
            return false;
        return !(rentTillDate != null ? !rentTillDate.equals(that.rentTillDate) : that.rentTillDate != null);

    }

    @Override
    public int hashCode() {
        int result = machine != null ? machine.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (rentSinceDate != null ? rentSinceDate.hashCode() : 0);
        result = 31 * result + (rentTillDate != null ? rentTillDate.hashCode() : 0);
        return result;
    }
}
