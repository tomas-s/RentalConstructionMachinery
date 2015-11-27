/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.CustomerDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.verify;

/**
 *
 * @author tomas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class CustomerServiceTest {
    
    @Mock
    private CustomerDao customerDao;
    
    @InjectMocks
    private CustomerServiceImpl customerService;

    Customer c;
    
    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
        Customer c = new Customer();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);
    }
    
   
    
    @Test
    public void testCreate() {
        
            when(customerDao.create(c)).thenReturn(c);
            assertEquals(c, customerService.createCustomer(c));
            verify(customerDao).create(c);
    }
    
    
    
    @Test
    public void testUpdate(){
        customerService.updateCustomer(c);
        verify(customerDao).update(c);
    }

    @Test
    public void testFindById() {
//        Customer customer = getCustomer();
        long id = 9;
        when(customerDao.findById(id)).thenReturn(c);
        assertEquals(customerService.findCustomerById(id), c);
        verify(customerDao).findById(id);
    }
    
    @Test
    public void testDelete(){
        customerService.deleteCustomer(c);
        verify(customerDao).delete(c);
    }
    
    
    
    
}
