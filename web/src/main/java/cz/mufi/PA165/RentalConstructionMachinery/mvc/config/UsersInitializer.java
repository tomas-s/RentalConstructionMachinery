package cz.mufi.PA165.RentalConstructionMachinery.mvc.config;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.context.ContextLoaderListener;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;

/**
 * Created by jakac on 13.12.15.
 */
// @Component
public class UsersInitializer extends ContextLoaderListener {

    protected CustomerDTO admin;
    protected CustomerDTO user;

    // @Autowired
    public UsersInitializer(CustomerFacade customerFacade) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

        admin = new CustomerDTO();
        admin.setCustomerType(CustomerTypeDTO.LEGAL);
        admin.setFirstName("admin");
        admin.setLastName("adminovic");
        admin.setUsername("admin");
        admin.setPassword(encoder.encodePassword("admin", null));
        admin.setRole("ROLE_ADMIN");
        admin.setPhoneNumber("666");
        admin = customerFacade.createNewCustomer(admin);
        System.out.println("Imported user admin, password admin");

        user = new CustomerDTO();
        user.setCustomerType(CustomerTypeDTO.LEGAL);
        user.setFirstName("user");
        user.setLastName("userovic");
        user.setUsername("user");
        user.setPassword(encoder.encodePassword("user", null));
        user.setRole("ROLE_USER");
        user.setPhoneNumber("777");
        user = customerFacade.createNewCustomer(user);
        System.out.println("Imported user user, password user");
    }

}
