package cz.mufi.PA165.RentalConstructionMachinery.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;

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

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testTest() {
        System.out.println("dao: " + customerDao);

        // em.getTransaction().begin();

        Customer customer = new Customer();
        customer.setFirstName("A");
        customer.setLastName("B");
        customer.setCustomerType(CustomerType.LEGAL);
        customer.setPhoneNumber("666");

        customerDao.create(customer);

        System.out.println("dao: " + customer);
        Customer found = customerDao.findById(customer.getId());
        System.out.println("dao: " + found);

        // em.getTransaction().commit();
    }

}
