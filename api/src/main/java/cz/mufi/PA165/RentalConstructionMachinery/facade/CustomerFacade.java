package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;

@Component
public interface CustomerFacade {

    /**
     * Create a new customer in our company.
     * 
     * @param customer
     */
    void createNewCustomer(CustomerDTO customer);

    /**
     * Delete a customer from our company.
     * 
     * @param customer
     */
    void deleteCustomer(CustomerDTO customer);
}
