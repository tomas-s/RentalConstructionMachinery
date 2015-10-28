package cz.mufi.PA165.RentalConstructionMachinery.dao;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

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
@ContextConfiguration(locations = { "/applicationContext-main.xml" })
public class RentDaoTest {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private MachineDao machineDao;

    private Customer c;
    private Machine m;

    private void prepareCustomerMachine() {

    }

    @Test
    @Transactional
    public void testCreate() {
        c = new Customer();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);

        customerDao.create(c);

        m = new Machine();
        m.setMachineType(MachineType.LORRY);

        machineDao.create(m);

        Rent r = new Rent();
        r.setCustomer(c);
        r.setMachine(m);
        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());

        rentDao.create(r);
        Rent r2 = rentDao.findById(r.getId());

        Assert.assertEquals(r, r2);

    }

}
