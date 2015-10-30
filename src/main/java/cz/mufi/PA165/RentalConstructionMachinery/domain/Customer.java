package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;

/**
 * 
 * @author zdenek
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Rent> rentHistory = new ArrayList<Rent>();

    /*
     * Generated
     */

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Rent> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<Rent> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public void addRent(Rent rent) {
        this.rentHistory.add(rent);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Customer))
            return false;
        Customer other = (Customer) obj;
        if (customerType != other.getCustomerType())
            return false;
        if (firstName == null) {
            if (other.getFirstName() != null)
                return false;
        } else if (!firstName.equals(other.getFirstName()))
            return false;
        if (lastName == null) {
            if (other.getLastName() != null)
                return false;
        } else if (!lastName.equals(other.getLastName()))
            return false;
        if (phoneNumber == null) {
            if (other.getPhoneNumber() != null)
                return false;
        } else if (!phoneNumber.equals(other.getPhoneNumber()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
                + phoneNumber + ", customerType=" + customerType + "]";
    }
}
