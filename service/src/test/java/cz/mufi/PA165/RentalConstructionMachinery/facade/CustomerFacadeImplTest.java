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
import org.junit.Assert;

/**
 *
 * @author tomas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mainApplicationContext.xml" }) // applicationContext-service.xml
@Transactional
public class CustomerFacadeImplTest {

    @Autowired
    private CustomerFacadeImpl customerFacadeImpl;

    /** Instance of fresh initialized object. */
    private CustomerDTO customer;

    @Before
    public void initCustomer() {
        RentDTO rent = new RentDTO();
        List<RentDTO> rentHistory = new ArrayList<RentDTO>();
        rentHistory.add(rent);
        customer = new CustomerDTO();
        customer.setId(Long.getLong("1"));
        customer.setFirstName("Tom");
        customer.setLastName("xxx");
        customer.setPhoneNumber("555");
        customer.setCustomerType(CustomerType.NATURAL);
        customer.setRentHistory(rentHistory);
    }

    @Test
    public void testCreateNewCustomer() {

        CustomerDTO customer1 = new CustomerDTO();
        customer1 = customerFacadeImpl.createNewCustomer(customer);
        Assert.assertEquals(customer.getFirstName(),customer1.getFirstName());
        Assert.assertEquals(customer.getLastName(),customer1.getLastName());
        Assert.assertEquals(customer.getPhoneNumber(),customer1.getPhoneNumber());
    }
}