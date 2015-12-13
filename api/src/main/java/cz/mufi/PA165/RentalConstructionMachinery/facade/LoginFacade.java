package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.LoginDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Matej Jakimov on 12.12.15.
 */
public interface LoginFacade extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
