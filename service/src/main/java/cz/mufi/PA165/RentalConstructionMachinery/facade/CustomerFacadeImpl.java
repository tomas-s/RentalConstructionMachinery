package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public void createNewCustomer(CustomerDTO customerDTO) {

        // dozerBeanMapper = new DozerBeanMapper();
        Customer customer = dozerBeanMapper.map(customerDTO, Customer.class);

        System.out.println("nakopiroval som: " + customer);
        customerService.createCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerService.findCustomerById(id);
        customerService.deleteCustomer(customer);
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
