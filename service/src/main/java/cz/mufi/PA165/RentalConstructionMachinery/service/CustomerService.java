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
    
    Customer createCustomer(Customer customer);
    
    void updateCustomer(Customer customer);
    
    void deleteCustomer(Customer customer);
    
    Customer findCustomerById(long id);
    
    List<Customer> findAll();

    Customer getCustomerByUsername(String username);
    
}
