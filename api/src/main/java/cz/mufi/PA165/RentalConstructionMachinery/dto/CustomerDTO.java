package cz.mufi.PA165.RentalConstructionMachinery.dto;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import javax.validation.constraints.NotNull;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
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

    private CustomerTypeDTO customerType;

    @XmlTransient
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

    public CustomerTypeDTO getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeDTO customerType) {
        this.customerType = customerType;
    }

    @XmlTransient
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTO that = (CustomerDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (customerType != that.customerType) return false;
        return !(rentHistory != null ? !rentHistory.equals(that.rentHistory) : that.rentHistory != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
        result = 31 * result + (rentHistory != null ? rentHistory.hashCode() : 0);
        return result;
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
