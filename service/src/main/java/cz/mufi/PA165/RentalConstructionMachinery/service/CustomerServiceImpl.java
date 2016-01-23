package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.exception.ProjectDataAccesException;
import java.util.List;

/**
 *
 * @author tomas
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * create customer
     * @param customer
     * @return
     */
    @Override
    public Customer createCustomer(Customer customer) {        
        return customerDao.create(customer);

    }
    
    /**
     * update customer
     * @param customer
     */
    @Override
    public void updateCustomer(Customer customer){
        
         customerDao.update(customer);
        
        
    }
    
    /**
     * delte customer
     * @param customer
     */
    @Override
    public void deleteCustomer(Customer customer) { 
            customerDao.delete(customer);
        
    }

    /**
     * find customer by Id 
     * @param id
     * @return
     */
    @Override
    public Customer findCustomerById(long id) {
        return customerDao.findById(id);
    }
    
    /**
     * find all customers
     * @return
     */
    @Override
    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    /**
     * find customer by Username
     * @param username 
     * @return
     */
    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
    
}
