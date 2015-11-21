package cz.mufi.PA165.RentalConstructionMachinery.dao;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;


/**
 *
 * @author Matej Jakimov
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-dao.xml" })
@Transactional
public class RentDaoTest { // extends AbstractTestNGSpringContextTests {
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

    @Before
    public void prepareCustomerMachine()
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

        Rent r = new Rent();
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(r);
    }

    @Test
    public void testCreate() {

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
