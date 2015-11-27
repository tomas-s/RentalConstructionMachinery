package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentServiceImpl;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Calendar;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jakac on 26.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mainApplicationContext.xml"})
@Transactional
public class RentFacadeTest {

    @Mock
    private RentService rentService;

    @Mock
    private BeanMappingService mapperService;

    /**
     * Nedari se pouzit najednou Spring DI a Mockito DI
     */
    @InjectMocks
    private RentFacadeImpl rentFacade;

    @Before
    public void initMocks()
    {
        MockitoAnnotations.initMocks(this);
    }

    private static MachineDTO getMachine() {
        MachineDTO m = new MachineDTO();
        return m;
    }

    private static CustomerDTO getCustomer() {
        CustomerDTO c = new CustomerDTO();
        c.setFirstName("A");
        c.setLastName("B");
        c.setPhoneNumber("0");
        c.setCustomerType(CustomerType.LEGAL);

        return c;
    }

    private static RentCreateDTO getCreateRentDTO() {
        RentCreateDTO r = new RentCreateDTO();

        r.setRentSinceDate(Calendar.getInstance().getTime());
        r.setRentTillDate(Calendar.getInstance().getTime());
        r.setMachine(getMachine());
        r.setCustomer(getCustomer());

        return r;
    }

    @Test
    public void rent()
    {
        Rent rent = new Rent();

        RentCreateDTO rc = getCreateRentDTO();

        when(mapperService.map(rc, Rent.class)).thenReturn(rent);
        when(rentService.createRent(rent)).thenReturn(rent);
        rentFacade.rentMachine(rc);
        verify(rentService).createRent(rent);
    }

    @Test
    public void delete()
    {
        Rent rent = new Rent();
        long id = 123;
        when(rentService.findRentById(id)).thenReturn(rent);
        rentFacade.deleteRent(id);
        verify(rentService).deleteRent(rent);
    }
}
