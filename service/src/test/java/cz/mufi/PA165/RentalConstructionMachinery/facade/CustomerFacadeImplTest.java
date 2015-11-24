/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;

import javax.transaction.Transactional;

/**
 *
 * @author tomas
 */
@RunWith(SpringJUnit4ClassRunner.class)
<<<<<<< HEAD
@ContextConfiguration(locations = { "/applicationContext-service.xml" }) // /mainApplicationContext.xml
=======
@ContextConfiguration(locations = { "/mainApplicationContext.xml" }) // /mainApplicationContext.xml
>>>>>>> 813a956d5e46c606d99c3aa67b466875dd81a3e9
@Transactional
public class CustomerFacadeImplTest {

    @Autowired
    private CustomerFacadeImpl customerFacadeImpl;

    /** Instance of fresh initialized object. */
    private CustomerDTO customerDTO;

    @Before
    public void initCustomer() {
        RentDTO rent = new RentDTO();
        List<RentDTO> rentHistory = new ArrayList<>();
        rentHistory.add(rent);
        customerDTO = new CustomerDTO();
        customerDTO.setId(Long.getLong("1"));
        customerDTO.setFirstName("Tom");
        customerDTO.setLastName("xxx");
        customerDTO.setPhoneNumber("555");
        customerDTO.setCustomerType(CustomerType.NATURAL);
        customerDTO.setRentHistory(rentHistory);
    }

    @Test
    public void createNewCustomer() {

        customerFacadeImpl.createNewCustomer(customerDTO);
    }
}