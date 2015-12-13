package cz.mufi.PA165.RentalConstructionMachinery.dto;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import javax.validation.constraints.NotNull;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO implements UserDetails {

    public class Role implements GrantedAuthority {
        private String role;

        public Role(String role) {
            this.role = role;
        }

        public String getAuthority() {
            return role;
        }
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String role;


    private String phoneNumber;

    private CustomerType customerType;

    private List<RentDTO> rentHistory = new ArrayList<RentDTO>();

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

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public List<RentDTO> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<RentDTO> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public void addRent(RentDTO rent) {
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
        if (!(obj instanceof CustomerDTO))
            return false;
        CustomerDTO other = (CustomerDTO) obj;
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
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType +
                ", rentHistory=" + rentHistory +
                '}';
    }

    @Override
    public List<Role> getAuthorities(){
        List<Role> role = new ArrayList<>();
        role.add(new Role(this.role));
        return role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
