/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface CustomerService {
    
    public Customer createCustomer(Customer customer);
    
    public void updateCustomer(Customer customer);
    
    public void deleteCustomer(Customer customer);
    
    public Customer findCustomerById(long id);
    
    public List<Customer> findAll();
    
}
