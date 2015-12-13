package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.exception.ProjectDataAccesException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer createCustomer(Customer customer) {        
        return customerDao.create(customer);

    }
    
    @Override
    public void updateCustomer(Customer customer){
        
         customerDao.update(customer);
        
        
    }
    

    @Override
    public void deleteCustomer(Customer customer) { 
            customerDao.delete(customer);
        
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerDao.findById(id);
    }
    
    @Override
    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
