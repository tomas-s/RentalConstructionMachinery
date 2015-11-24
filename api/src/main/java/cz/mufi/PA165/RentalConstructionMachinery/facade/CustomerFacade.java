package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import java.util.List;

public interface CustomerFacade {

    /**
     * Create a new customer in our company.
     * 
     * @param customer
     */
    CustomerDTO createNewCustomer(CustomerDTO customer);

    /**
     * Delete a customer from our company.
     * 
     * @param customer
     */
    void deleteCustomer(Long id);

    void updateCustomer(CustomerDTO customer);

    List<CustomerDTO> getAllCustomers();
}
