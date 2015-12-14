package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Matej Jakimov on 12.12.15.
 */
@Component("loginFacade")
@Transactional
public class LoginFacadeImpl implements LoginFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BeanMappingService mappingService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Customer customer = customerService.getCustomerByUsername(username);
            if(customer == null)
            {
                throw new UsernameNotFoundException("User " + username + " not found");
            }
            UserDetails ud = mappingService.map(customer, CustomerDTO.class);
            return ud;
        } catch(Exception e) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }
}
