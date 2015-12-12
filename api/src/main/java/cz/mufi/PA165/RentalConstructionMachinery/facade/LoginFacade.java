package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.LoginDTO;

/**
 * Created by Matej Jakimov on 12.12.15.
 */
public interface LoginFacade {

    boolean isLoginValid(String login, String password);
}
