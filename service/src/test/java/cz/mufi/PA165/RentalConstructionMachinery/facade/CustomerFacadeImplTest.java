/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author tomas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
public class CustomerFacadeImplTest {
    
    @Autowired
    CustomerFacadeImpl customerFacadeImpl;

    @Test
    public void createNewCustomer() {
        
        
        customerFacadeImpl.createNewCustomer(initCustomer());
    }
    
    public CustomerDTO initCustomer(){
        RentDTO rent= new RentDTO();
        List<RentDTO> rentHistory = new ArrayList<>();
        rentHistory.add(rent);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(Long.getLong("1"));
        customerDTO.setFirstName("Tom");
        customerDTO.setLastName("xxx");
        customerDTO.setPhoneNumber("555");
        customerDTO.setCustomerType(CustomerType.NATURAL);
        customerDTO.setRentHistory(rentHistory);  
        return customerDTO;
    }
}