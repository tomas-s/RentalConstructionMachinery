package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.exception.ProjectDataAccesException;
import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerDao customerDao;

    public Customer createCustomer(Customer customer) {
        Customer c;
        try{
        c = customerDao.create(customer);    
        }
        catch(IllegalArgumentException ex){
            throw new ProjectDataAccesException("Vyvolanie DataAccesVynimky", ex);
        }
        return c;
    }
    
    public void updateCustomer(Customer customer){
        
        try{   
         customerDao.update(customer);
        }
        catch(IllegalArgumentException ex){
            throw new ProjectDataAccesException("Vyvolanie DataAccesVynimky", ex);
        }
        
    }
    

    public void deleteCustomer(Customer customer) {
        try{  
            customerDao.delete(customer);
        }
        catch(IllegalArgumentException ex){
            throw new ProjectDataAccesException("Vyvolanie DataAccesVynimky", ex);
        }
    }

    public Customer findCustomerById(long id) {
        return customerDao.findById(id);
    }
    
    public List<Customer> findAll(){
        return customerDao.findAll();
    }
}