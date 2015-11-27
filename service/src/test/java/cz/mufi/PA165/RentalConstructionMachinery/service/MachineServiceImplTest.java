package cz.mufi.PA165.RentalConstructionMachinery.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.dao.MachineDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

/**
 * 
 * @author zdenek
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mainApplicationContext.xml" })
@Transactional
public class MachineServiceImplTest {

    @Autowired
    @InjectMocks
    private MachineService machineService;

    @Autowired
    @Mock
    private MachineDao machineDao;

    @Autowired
    @Mock
    private RentService rentService;

    @Autowired
    @Mock
    private RevisionService revisionService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAvailableMachines() throws Exception {

        List<Machine> allMachines = new ArrayList<Machine>();
        List<Rent> rents = new ArrayList<Rent>();

        // Create since and till date
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 9); // October
        final Date since = calendar.getTime();
        calendar.set(Calendar.MONTH, 11); // December
        final Date till = calendar.getTime();

        // Create machines
        Machine m1 = new Machine();
        m1.setId(new Long(1));
        m1.setMachineType(MachineType.CRANE);

        Machine m2 = new Machine();
        m2.setId(new Long(2));
        m2.setMachineType(MachineType.DIGGER);

        Machine m3 = new Machine();
        m3.setId(new Long(3));
        m3.setMachineType(MachineType.DUMPER);

        Machine m4 = new Machine();
        m4.setId(new Long(4));
        m4.setMachineType(MachineType.FEEDER);

        // Create customer
        Customer c1 = new Customer();
        c1.setId(new Long(1));

        // Create rent
        Rent r1 = new Rent();
        r1.setCustomer(c1);
        r1.setMachine(m1);
        r1.setId(new Long(1));

        // Set mocks
        when(machineDao.findAll()).thenReturn(allMachines);
        when(rentService.getMachineRentsBetween(m1, since, till)).thenReturn(rents);

        // No machine to offer
        assertEquals(0, machineService.getAvailableMachines(since, till).size());

        // Add machines
        allMachines.add(m1);
        allMachines.add(m2);
        allMachines.add(m3);
        allMachines.add(m4);

        // All machines should be returned, no one is rented or revisioned
        assertEquals(4, machineService.getAvailableMachines(since, till).size());

        // Add rent
        rents.add(r1);

        // 3 machines should be returned, one is rent
        assertEquals(3, machineService.getAvailableMachines(since, till).size());

        // Add revision for m2
        when(revisionService.revisionExistsBetween(m2, since, till)).thenReturn(true);

        // 2 machines should be returned, one is rent
        assertEquals(2, machineService.getAvailableMachines(since, till).size());
        assertEquals(m3, machineService.getAvailableMachines(since, till).get(0));
        assertEquals(m4, machineService.getAvailableMachines(since, till).get(1));
    }

    @Test
    public void testGetRentedMachines() throws Exception {

        List<Rent> rents = new ArrayList<Rent>();

        // Create machines
        Machine m1 = new Machine();
        m1.setId(new Long(1));
        m1.setMachineType(MachineType.CRANE);

        Machine m2 = new Machine();
        m2.setId(new Long(2));
        m2.setMachineType(MachineType.DIGGER);

        Machine m3 = new Machine();
        m3.setId(new Long(3));
        m3.setMachineType(MachineType.DUMPER);

        Machine m4 = new Machine();
        m4.setId(new Long(4));
        m4.setMachineType(MachineType.FEEDER);

        Rent r1 = new Rent();
        r1.setId(new Long(1));
        r1.setMachine(m1);

        Rent r2 = new Rent();
        r2.setId(new Long(2));
        r2.setMachine(m2);

        // Create since and till date
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 9); // October
        final Date since = calendar.getTime();
        calendar.set(Calendar.MONTH, 11); // December
        final Date till = calendar.getTime();

        // Set mocks
        when(rentService.getRentsBetween(since, till)).thenReturn(rents);

        // No rent
        assertEquals(0, machineService.getRentedMachines(since, till).size());

        // Add rent
        rents.add(r1);
        assertEquals(1, machineService.getRentedMachines(since, till).size());

        // Add one more rent
        rents.add(r2);
        assertEquals(2, machineService.getRentedMachines(since, till).size());
        assertEquals(m1, machineService.getRentedMachines(since, till).get(0));
        assertEquals(m2, machineService.getRentedMachines(since, till).get(1));

    }
}