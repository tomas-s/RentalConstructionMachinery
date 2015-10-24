package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private CustomerType customerType;
    private List<Rent> rentHistory;

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
}
