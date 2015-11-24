package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    /**
     * The only allowed changes of state are: RECIEVED - CANCELED RECEIVED -
     * SHIPPED SHIPPED - DONE
     */
    private Set<CustomerType> allowedTransitions = new HashSet<CustomerType>();

    {
        allowedTransitions.add(CustomerType.LEGAL);
        allowedTransitions.add(CustomerType.NATURAL);
    }

    public void createNewCustomer(CustomerDTO customer) {
        customerService.createCustomer(customer);
    }

    public void deleteCustomer(CustomerDTO customer) {
        throw new NotImplementedException();
    }

    public Set<CustomerType> getCustomerTypes() {

    }
}
