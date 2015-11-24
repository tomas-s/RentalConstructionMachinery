package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

@Component
public interface RentFacade {

    /**
     * Rent machine.
     * 
     * @param idMachine
     * @param idCustomer
     */
    void rentMachine(Long idMachine, Long idCustomer);

}
