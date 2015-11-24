package cz.mufi.PA165.RentalConstructionMachinery.facade;

<<<<<<<HEAD

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;=======
import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDaoImpl;import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;>>>>>>>b4f7cc9dd269773d85278a595e2b66c54fb242c3
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import javax.transaction.Transactional;
import org.dozer.DozerBeanMapper;
import org.dozer.inject.Inject;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public void createNewCustomer(CustomerDTO customerDTO) {

        dozerBeanMapper = new DozerBeanMapper();
        Customer customer = dozerBeanMapper.map(customerDTO, Customer.class);

        System.out.println("nakopiroval som: " + customer);
        customerService.createCustomer(customer);
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
