package cz.mufi.PA165.RentalConstructionMachinery.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;

/**
 * 
 * @author zdenek
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-main.xml" })
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testTest() {
        System.out.println("dao: " + customerDao);

        Customer customer = new Customer();
        customerDao.create(customer);
    }

}
