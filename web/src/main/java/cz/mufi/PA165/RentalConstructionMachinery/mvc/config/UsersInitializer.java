package cz.mufi.PA165.RentalConstructionMachinery.mvc.config;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.CustomerType;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * Created by jakac on 13.12.15.
 */
@Component
public class UsersInitializer extends ContextLoaderListener {


    @Autowired
    public UsersInitializer(CustomerFacade customerFacade) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

        CustomerDTO admin = new CustomerDTO();
        admin.setCustomerType(CustomerType.LEGAL);
        admin.setFirstName("admin");
        admin.setLastName("adminovic");
        admin.setUsername("admin");
        admin.setPassword(encoder.encodePassword("admin", null));
        admin.setRole("admin");
        admin.setPhoneNumber("666");
        customerFacade.createNewCustomer(admin);
        System.out.println("Imported admin");
    }

}
