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
        admin.setRole("ADMIN");
        admin.setPhoneNumber("666");
        customerFacade.createNewCustomer(admin);
        System.out.println("Imported user admin, password admin");

        CustomerDTO user = new CustomerDTO();
        user.setCustomerType(CustomerType.LEGAL);
        user.setFirstName("user");
        user.setLastName("userovic");
        user.setUsername("user");
        user.setPassword(encoder.encodePassword("user", null));
        user.setRole("USER");
        user.setPhoneNumber("777");
        customerFacade.createNewCustomer(user);
        System.out.println("Imported user user, password user");
    }

}
