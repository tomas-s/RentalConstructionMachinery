package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class RentDTO implements Serializable {

    @NotNull
    private Long id;
    
    @NotNull
    private MachineDTO machine;

    @NotNull
    @XmlTransient
    private CustomerDTO customer;

    @NotNull
    private Date rentSinceDate;

    @NotNull
    private Date rentTillDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public void setMachine(MachineDTO machine) {
        this.machine = machine;
    }

    @XmlTransient
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RentDTO rentDTO = (RentDTO) o;

        if (id != null ? !id.equals(rentDTO.id) : rentDTO.id != null)
            return false;
        // if (machine != null ? !machine.equals(rentDTO.machine) :
        // rentDTO.machine != null) return false;
        // if (customer != null ? !customer.equals(rentDTO.customer) :
        // rentDTO.customer != null) return false;
        if (rentSinceDate != null ? !rentSinceDate.equals(rentDTO.rentSinceDate) : rentDTO.rentSinceDate != null)
            return false;
        return !(rentTillDate != null ? !rentTillDate.equals(rentDTO.rentTillDate) : rentDTO.rentTillDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        // result = 31 * result + (machine != null ? machine.hashCode() : 0);
        // result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (rentSinceDate != null ? rentSinceDate.hashCode() : 0);
        result = 31 * result + (rentTillDate != null ? rentTillDate.hashCode() : 0);
        return result;
    }

}
