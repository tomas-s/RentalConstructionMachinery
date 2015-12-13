package cz.mufi.PA165.RentalConstructionMachinery.dao;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Calendar;
import java.util.Date;

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
    private Rent r;

    @Before
    public void prepare()
    {

        c = new Customer();
        c.setFirstName("A");
        c.setLastName("B");
        c.setUsername("user");
        c.setRole("ROLE");
        c.setPassword("");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);

        customerDao.create(c);

        m = new Machine();
        m.setMachineType(MachineType.LORRY);

        machineDao.create(m);

        r = new Rent();
        r.setCustomer(c);
        r.setMachine(m);
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

    }

    @Test(expected = PersistenceException.class)
    public void testCreateWithoutCustomerMachine() {
        Rent rent = new Rent();
        rent.setRentSinceDate(Calendar.getInstance().getTime());
        rent.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(rent);
    }

    @Test
    public void testCreate() {

        rentDao.create(r);
        Rent r2 = rentDao.findById(r.getId());

        Assert.assertEquals(r, r2);
    }

    @Test
    public void testDelete()
    {
        rentDao.create(r);
        rentDao.delete(r);
        Rent ret = rentDao.findById(r.getId());

        Assert.assertNull(ret);
    }

    @Test
    public void testUpdate()
    {
        rentDao.create(r);

        Machine m2 = new Machine();
        m2.setMachineType(MachineType.CRANE);
        machineDao.create(m2);

        r.setMachine(m2);
        rentDao.update(r);

        Assert.assertEquals(rentDao.findById(r.getId()), r);
    }

    @Test
    public void testGetMachineRentsBetween() {
        Calendar c = Calendar.getInstance();
        Date from = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 4);
        Date to = c.getTime();

        c.add(Calendar.DAY_OF_YEAR, -2);
        Date testFrom = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 10);
        Date testTo = c.getTime();

        r.setRentSinceDate(from);
        r.setRentTillDate(to);
        rentDao.create(r);

        Assert.assertTrue(rentDao.getMachineRentsBetween(m, testFrom, testTo).size() == 1);
        Assert.assertEquals(rentDao.getMachineRentsBetween(m, testFrom, testTo).get(0), r);
    }

    @Test
    public void testGetRentsBetween() {
        Calendar cal = Calendar.getInstance();
        Date from = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 4);
        Date to = cal.getTime();

        cal.add(Calendar.DAY_OF_YEAR, -2);
        Date testFrom = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        Date testTo = cal.getTime();

        r.setRentSinceDate(from);
        r.setRentTillDate(to);

        rentDao.create(r);

        Assert.assertTrue(rentDao.getRentsBetween(testFrom, testTo).size() == 1);
        Assert.assertEquals(rentDao.getRentsBetween(testFrom, testTo).get(0), r);
    }

    @Test
    public void testHasConflict() {
        Calendar cal = Calendar.getInstance();
        Date from = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 4);
        Date to = cal.getTime();

        r.setRentSinceDate(from);
        r.setRentTillDate(to);

        cal.add(Calendar.DAY_OF_YEAR, -2);
        Date testFrom = cal.getTime();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        Date testTo = cal.getTime();

        cal.add(Calendar.DAY_OF_YEAR, 50);
        Date testTo2 = cal.getTime();

        rentDao.create(r);

        Assert.assertTrue(rentDao.hasConflict(m, testFrom, testTo));
        Assert.assertTrue(rentDao.hasConflict(m, testFrom));
        Assert.assertTrue(!rentDao.hasConflict(m, testTo, testTo2));
        Assert.assertTrue(!rentDao.hasConflict(m, testTo2));
    }
}
