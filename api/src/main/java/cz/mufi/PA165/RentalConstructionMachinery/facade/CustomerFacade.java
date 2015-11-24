package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;

@Component
public interface CustomerFacade {

    void createNewCustomer(CustomerDTO customer);

    void deleteCustomer(CustomerDTO customer);
    
    void updateCustomer(CustomerDTO customer);
    
    void getAllCustomers();
}
