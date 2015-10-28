package cz.mufi.PA165.RentalConstructionMachinery.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.Assert;
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
    @Transactional
    public void testCreate() {

        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);
        created.setPhoneNumber("666");

        customerDao.create(created);

        em.flush();
        em.clear();

        Customer found = customerDao.findById(created.getId());

        System.out.println("created: " + created);
        System.out.println("found: " + found);

        Assert.assertEquals(created, found);
    }

    @Test(expected = Exception.class)
    @Transactional
    public void testNullPhoneNumber() {

        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);

        customerDao.create(created);
    }

    @Test(expected = PersistenceException.class)
    @Transactional
    public void testUniquePhoneNumber() {

        Customer created1 = new Customer();
        created1.setFirstName("A");
        created1.setLastName("B");
        created1.setCustomerType(CustomerType.LEGAL);
        created1.setPhoneNumber("666");

        customerDao.create(created1);

        Customer created2 = new Customer();
        created2.setFirstName("C");
        created2.setLastName("D");
        created2.setCustomerType(CustomerType.LEGAL);
        created2.setPhoneNumber("666");

        customerDao.create(created2);
    }

}
