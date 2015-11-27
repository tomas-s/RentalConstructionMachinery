/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author tomas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class CustomerFacadeImplTestMock {
    
    @Mock
    private CustomerServiceImpl customerService;
    
    @Mock
    private BeanMappingService mapperService;
    
    @InjectMocks
    private CustomerFacadeImpl customerFacade;
    
    private CustomerDTO customerDto;
    
    @Before
    public void initMocks()
    {
        customerDto = new CustomerDTO();
        customerDto.setFirstName("A");
        customerDto.setLastName("B");
        customerDto.setPhoneNumber("0");
        customerDto.setCustomerType(CustomerType.LEGAL);
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testCreate(){
        Customer customer = new Customer();
        when(mapperService.map(customerDto, Customer.class)).thenReturn(customer);
        when(customerService.createCustomer(customer)).thenReturn(customer);
        
        customerFacade.createNewCustomer(customerDto);
        verify(customerService).createCustomer(customer);
    }
    
    @Test
    public void testDelete(){
            Customer customer = new Customer();
            when(mapperService.map(customerDto, Customer.class)).thenReturn(customer);
            customerFacade.deleteCustomer(customerDto);
            verify(customerService).deleteCustomer(customer);
    }
    
    @Test
    public void testUpdate(){
        Customer customer = new Customer();
            when(mapperService.map(customerDto, Customer.class)).thenReturn(customer);

            customerFacade.updateCustomer(customerDto);
            verify(customerService).updateCustomer(customer);
    }
    
    @Test
    public void testFindbyId(){
        Customer customer = new Customer();
            when(mapperService.map(customerDto, Customer.class)).thenReturn(customer);
            when(customerService.findCustomerById(Long.MIN_VALUE)).thenReturn(customer);
            
            customerFacade.findById(Long.MIN_VALUE);
            verify(customerService).findCustomerById(Long.MIN_VALUE);
            
            
    }
    
    
    
}
