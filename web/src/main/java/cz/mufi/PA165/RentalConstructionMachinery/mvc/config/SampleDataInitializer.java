package cz.mufi.PA165.RentalConstructionMachinery.mvc.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RentFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;

/**
 * 
 * @author zdenek skerik
 *
 */
@Component
public class SampleDataInitializer extends ContextLoaderListener {

    private MachineFacade machineFacade;
    private RentFacade rentFacade;
    private CustomerFacade customerFacade;
    private RevisionFacade revisionFacade;

    final ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public SampleDataInitializer(MachineFacade machineFacade, RentFacade rentFacade, CustomerFacade customerFacade,
            RevisionFacade revisionFacade) throws ParseException {

        this.machineFacade = machineFacade;
        this.rentFacade = rentFacade;
        this.customerFacade = customerFacade;
        this.revisionFacade = revisionFacade;

        /*
         * Users
         */

        CustomerDTO admin = createCustomer(CustomerTypeDTO.LEGAL, "admin", "adminovic", "admin", "admin", "ROLE_ADMIN",
                "666");

        CustomerDTO user = createCustomer(CustomerTypeDTO.LEGAL, "user", "userovic", "user", "user", "ROLE_USER",
                "777");

        /*
         * Machines
         */

        MachineDTO m1 = createMachine(MachineType.CRANE);
        MachineDTO m2 = createMachine(MachineType.CRANE);
        MachineDTO m3 = createMachine(MachineType.LORRY);
        MachineDTO m4 = createMachine(MachineType.DIGGER);
        MachineDTO m5 = createMachine(MachineType.DUMPER);
        MachineDTO m6 = createMachine(MachineType.FEEDER);
        MachineDTO m7 = createMachine(MachineType.LORRY);

        /*
         * Revision
         */

        RevisionCreateDTO r1 = createRevision(m1, sdf.parse("2015-06-01"));
        RevisionCreateDTO r2 = createRevision(m1, sdf.parse("2014-11-18"));
        RevisionCreateDTO r3 = createRevision(m2, sdf.parse("2015-10-18"));
        RevisionCreateDTO r4 = createRevision(m3, sdf.parse("2014-09-18"));
        RevisionCreateDTO r5 = createRevision(m5, sdf.parse("2013-10-18"));
        RevisionCreateDTO r6 = createRevision(m6, sdf.parse("2014-07-18"));
        RevisionCreateDTO r7 = createRevision(m7, sdf.parse("2013-06-18"));

        /*
         * Rent
         */

        // RentCreateDTO rent1 = createRent(user, m1, sdf.parse("2015-06-02"),
        // sdf.parse("2015-12-31"));
        // RentCreateDTO rent2 = createRent(user, m2, sdf.parse("2015-06-01"),
        // sdf.parse("2015-12-05"));
        // RentCreateDTO rent3 = createRent(user, m3, sdf.parse("2014-05-05"),
        // sdf.parse("2014-07-22"));
    }

    private RevisionCreateDTO createRevision(MachineDTO m, Date revisionDate) {

        RevisionCreateDTO r = new RevisionCreateDTO();
        r.setMachine(m);
        r.setRevisionDate(revisionDate);
        revisionFacade.createRevision(r);

        System.out.println("Create revision: " + r);

        return r;
    }

    private RentCreateDTO createRent(CustomerDTO c, MachineDTO m, Date since, Date till) {

        RentCreateDTO rent = new RentCreateDTO();
        rent.setCustomer(c);
        rent.setMachine(m);
        rent.setRentSinceDate(since);
        rent.setRentTillDate(till);

        rentFacade.rentMachine(rent);

        System.out.println("Create rent: " + rent);

        return rent;
    }

    private CustomerDTO createCustomer(CustomerTypeDTO type, String firstName, String lastName, String userName,
            String pswd, String role, String phoneNumber) {

        CustomerDTO user = new CustomerDTO();

        user.setCustomerType(type);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(userName);
        user.setPassword(encoder.encodePassword(pswd, null));
        user.setRole(role);
        user.setPhoneNumber(phoneNumber);
        user = customerFacade.createNewCustomer(user);
        System.out.println("Create customer: " + user);

        return user;

    }

    private MachineDTO createMachine(MachineType machineType) {

        MachineDTO m = new MachineDTO();
        m.setMachineType(machineType);
        m = machineFacade.addMachine(m);
        System.out.println("Create machine: " + m);

        return m;
    }
}
