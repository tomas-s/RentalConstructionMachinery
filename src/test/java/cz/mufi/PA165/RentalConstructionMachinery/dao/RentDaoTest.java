package cz.mufi.PA165.RentalConstructionMachinery.dao;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.junit.Test;
import javax.persistence.PersistenceException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.EntityManager;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;

/**
 *
 * @author Matej Jakimov
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-main.xml" })
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RentDaoTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RentDao rentDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private MachineDao machineDao;

    private Customer c;
    private Machine m;

    private void prepareCustomerMachine()
    {
        c = new Customer();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);

        customerDao.create(c);

        m = new Machine();
        m.setMachineType(MachineType.LORRY);

        machineDao.create(m);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateWithoutCustomerMachine() {
        prepareCustomerMachine();

        Rent r = new Rent();
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(r);
    }

    @Test
    public void testCreate() {
        prepareCustomerMachine();

        Rent r = new Rent();
        r.setCustomer(c);
        r.setMachine(m);
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());


        rentDao.create(r);
        Rent r2 = rentDao.findById(r.getId());

        Assert.assertEquals(r, r2);
    }

    @Test
    public void testDelete()
    {
        prepareCustomerMachine();

        Rent r = new Rent();
        r.setCustomer(c);
        r.setMachine(m);
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(r);
        rentDao.delete(r);
        Rent ret = rentDao.findById(r.getId());

        Assert.assertNull(ret);
    }

    @Test
    public void testUpdate()
    {
        prepareCustomerMachine();

        Rent r = new Rent();
        r.setCustomer(c);
        r.setMachine(m);
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(r);

        Machine m2 = new Machine();
        m2.setMachineType(MachineType.CRANE);
        machineDao.create(m2);

        r.setMachine(m2);
        rentDao.update(r);

        Assert.assertEquals(rentDao.findById(r.getId()), r);
    }

}
