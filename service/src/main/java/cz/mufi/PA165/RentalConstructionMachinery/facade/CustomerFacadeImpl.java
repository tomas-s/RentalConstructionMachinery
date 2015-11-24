package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        System.out.println("dostal som sa sem");
        Customer customer = dozerBeanMapper.map(customerDTO, Customer.class);
        //System.out.println("nakopiroval som: " + customer);
        Customer c ;
         c = customerService.createCustomer(customer);
         return dozerBeanMapper.map(c, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(CustomerDTO customerDTO) {
        Customer customer = dozerBeanMapper.map(customerDTO, Customer.class);
        customerService.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = dozerBeanMapper.map(customerDTO, Customer.class);
        customerService.updateCustomer(customer);
        
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        System.out.println("zacinam getall");
        List<Customer> list ;
              list = customerService.findAll();
        List<CustomerDTO> customerDtoList = new ArrayList<CustomerDTO>();
        for(Customer customerTmp:list){
            customerDtoList.add(dozerBeanMapper.map(customerTmp, CustomerDTO.class));
        }
        return customerDtoList;
    }

    @Override
    public CustomerDTO findById(Long id) {
         Customer customerTmp = customerService.findCustomerById(id);
         return dozerBeanMapper.map(customerTmp, CustomerDTO.class);
         
    }
}
