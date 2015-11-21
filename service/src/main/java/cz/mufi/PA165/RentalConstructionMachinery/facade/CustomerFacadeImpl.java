package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    public void createNewCustomer(CustomerDTO customer){
        throw new NotImplementedException();
    }

    public void deleteCustomer(CustomerDTO customer) {
        throw new NotImplementedException();
    }
}
