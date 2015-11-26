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
    public void testCreateNewCustomer() {   //nejde vytvarat viac obiektov neviem preco....
        
        CustomerDTO customer1 = customerFacadeImpl.createNewCustomer(customer);
        Assert.assertEquals(customer, customer1);
//        CustomerDTO customer2 = new CustomerDTO();
//        customer2.setFirstName("aaa");
//        customer2.setLastName("xxx");
//        customerFacadeImpl.createNewCustomer(customer2);
    }   
    
    @Test
    public void testFindById(){
        CustomerDTO customer1 = customerFacadeImpl.createNewCustomer(customer);
        CustomerDTO customer2 = customerFacadeImpl.findById(customer1.getId());
        Assert.assertEquals(customer2, customer1);

    }
    
    @Test
    public void testDeleteCustomer(){
        CustomerDTO customer1 = customerFacadeImpl.createNewCustomer(customer);
        CustomerDTO customerFound = customerFacadeImpl.findById(customer1.getId());
        Assert.assertEquals(customer1, customerFound);
        
        customerFacadeImpl.deleteCustomer(customer1);
        
        List<CustomerDTO> listOfCustomersDto;
        listOfCustomersDto = customerFacadeImpl.getAllCustomers();
        Assert.assertEquals(0, listOfCustomersDto.size());
    }
    
    @Test
    public void testUpdateCustomer(){
        CustomerDTO customer1 = customerFacadeImpl.createNewCustomer(customer);
        customer1.setFirstName("Peter");
        customerFacadeImpl.updateCustomer(customer1);
        CustomerDTO customer2 = customerFacadeImpl.findById(customer1.getId());
        Assert.assertEquals(customer2, customer1);

    }
    
    @Test
    public void testGetAllCustomers(){
        customerFacadeImpl.createNewCustomer(customer);
        //customerFacadeImpl.createNewCustomer(customer);
        List<CustomerDTO> list ;
        list = customerFacadeImpl.getAllCustomers();
        Assert.assertEquals(1,list.size());
        
    }
    
    
}