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
@ContextConfiguration(locations = { "/applicationContext-dao.xml" })
@Transactional
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testCreate() {

        // Create
        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);
        created.setPhoneNumber("666");
        customerDao.create(created);

        // Get
        Customer found = customerDao.findById(created.getId());
        Assert.assertEquals(created, found);
    }

    @Test
    public void testUpdate() {

        // Create
        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);
        created.setPhoneNumber("666");
        customerDao.create(created);

        // Update
        created.setFirstName("D");
        customerDao.update(created);

        // Get to compare
        Customer found = customerDao.findById(created.getId());
        Assert.assertEquals(found.getFirstName(), "D");
    }

    @Test
    public void testDelete() {

        // Create
        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);
        created.setPhoneNumber("666");
        customerDao.create(created);

        // Get
        Customer found = customerDao.findById(created.getId());
        Assert.assertEquals(created, found);

        // Delete
        customerDao.delete(found);
        found = customerDao.findById(created.getId());
        Assert.assertNull(found);
        Assert.assertTrue(customerDao.findAll().isEmpty());
    }

    @Test(expected = Exception.class)
    public void testNullPhoneNumber() {

        Customer created = new Customer();
        created.setFirstName("A");
        created.setLastName("B");
        created.setCustomerType(CustomerType.LEGAL);

        customerDao.create(created);
    }

    @Test(expected = PersistenceException.class)
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
