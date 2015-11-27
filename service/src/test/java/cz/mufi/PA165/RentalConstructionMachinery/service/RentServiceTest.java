package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.RentDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentCaptor;

/**
 * Created by jakac on 26.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class RentServiceTest {

    @Mock
    private RentDao rentDao;

    @Mock
    private RevisionServiceImpl revisionService;

    /**
     * Nedari se pouzit najednou Spring DI a Mockito DI
     */
    @InjectMocks
    private RentServiceImpl rentService;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }

    private static Machine getMachine() {
        Machine m = new Machine();
        m.setMachineType(MachineType.DIGGER);
        return m;
    }

    private static Customer getCustomer() {
        Customer c = new Customer();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);

        return c;
    }

    private static Rent getRent() {
        Rent r = new Rent();

        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());
        r.setMachine(getMachine());
        r.setCustomer(getCustomer());

        return r;
    }

    @Test
    public void testJustCreate() {
        Rent rent = getRent();

        when(revisionService.revisionExistsBetween(rent.getMachine(), rent.getRentSinceDate(),
                rent.getRentTillDate())).thenReturn(false);
        when(rentDao.hasConflict(rent.getMachine(), rent.getRentSinceDate(), rent.getRentTillDate()))
                .thenReturn(false);
        when(rentDao.create(rent)).thenReturn(rent);

        Assert.assertEquals(rentService.createRent(rent), rent);
    }

    @Test(expected = cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException.class)
    public void testCreateRevisionExist() {
        Rent rent = getRent();

        when(revisionService.revisionExistsBetween(rent.getMachine(), rent.getRentSinceDate(),
                rent.getRentTillDate())).thenReturn(true);
        when(rentDao.hasConflict(rent.getMachine(), rent.getRentSinceDate(), rent.getRentTillDate()))
                .thenReturn(false);

        rentService.createRent(rent);
    }

    @Test(expected = cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException.class)
    public void testCreateConflict() {
        Rent rent = getRent();

        when(revisionService.revisionExistsBetween(rent.getMachine(), rent.getRentSinceDate(),
                rent.getRentTillDate())).thenReturn(false);
        when(rentDao.hasConflict(rent.getMachine(), rent.getRentSinceDate(), rent.getRentTillDate()))
                .thenReturn(true);

        rentService.createRent(rent);
    }

    @Test
    public void testFindById() {
        Rent rent = getRent();
        long id = 123;
        when(rentDao.findById(id)).thenReturn(rent);
        Assert.assertEquals(rentService.findRentById(id), rent);
        verify(rentDao).findById(id);
    }

    @Test
    public void testGetRentsBetween() {
        Date time = Calendar.getInstance().getTime();
        List<Rent> list = new ArrayList<>();
        list.add(getRent());
        when(rentDao.getRentsBetween(time, time)).thenReturn(list);
        Assert.assertEquals(rentService.getRentsBetween(time, time), list);
        verify(rentDao).getRentsBetween(time, time);
    }

    @Test
    public void testGetMachineRentsBetween() {
        Date time = Calendar.getInstance().getTime();
        List<Rent> list = new ArrayList<>();
        Machine m = getMachine();
        list.add(getRent());
        when(rentDao.getMachineRentsBetween(m, time, time)).thenReturn(list);
        Assert.assertEquals(rentService.getMachineRentsBetween(m, time, time), list);
        verify(rentDao).getMachineRentsBetween(m, time, time);
    }

    @Test
    public void testHasConflict() {
        Machine m = getMachine();
        Date time = Calendar.getInstance().getTime();
        when(rentDao.hasConflict(m, time)).thenReturn(true);
        boolean with = rentService.hasConflict(m ,time);
        when(rentDao.hasConflict(m, time)).thenReturn(false);
        boolean without = rentService.hasConflict(m, time);

        assert with;
        assert !without;
    }

    @Test
    public void testGetRentsForNextWeek() {
        ArgumentCaptor<Date> from = ArgumentCaptor.forClass(Date.class);
        ArgumentCaptor<Date> to = ArgumentCaptor.forClass(Date.class);
        rentService.getRentsForNextWeek();
        verify(rentDao).getRentsBetween(from.capture(), to.capture());
        assert to.getValue().getTime() - from.getValue().getTime() == 1000 * 3600 * 24 * 7;
    }

    @Test
    public void testDelete() {
        Rent rent = getRent();
        rentService.deleteRent(rent);
        verify(rentDao).delete(rent);
    }
}
