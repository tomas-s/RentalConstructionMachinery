package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jakac on 27.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-service.xml"})
@Transactional
public class BeanMappingServiceTest {

    @Autowired
    private BeanMappingService mappingService;

    private final static long TESTED_ID = 123;
    private final static String TESTED_NAME = "A";

    private static Customer getCustomer() {
        Customer c = new Customer();
        c.setFirstName(TESTED_NAME);
        return c;
    }

    private static CustomerDTO getCustomerDTO() {
        CustomerDTO c = new CustomerDTO();
        c.setFirstName(TESTED_NAME);
        return c;
    }

    private static Rent getRent() {
        Rent r = new Rent();
        r.setId(TESTED_ID);
        r.setCustomer(getCustomer());
        return r;
    }

    private static RentDTO getRentDTO() {
        RentDTO r = new RentDTO();
        r.setId(TESTED_ID);
        r.setCustomer(getCustomerDTO());
        return r;
    }

    @Test
    public void testMap() {
        Assert.assertEquals(mappingService.map(getRent(), RentDTO.class), getRentDTO());
        Assert.assertEquals(mappingService.map(getRentDTO(), Rent.class), getRent());
    }

    @Test
    public void testCollection() {
        List<Rent> rents = new ArrayList<>();
        rents.add(getRent());

        List<RentDTO> dtos = new ArrayList<>();
        dtos.add(getRentDTO());

        Assert.assertEquals(mappingService.map(rents, RentDTO.class), dtos);
    }
}
