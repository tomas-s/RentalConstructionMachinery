package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Customer;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;

@Component
public interface RentFacade {

    /**
     * Rent machine.
     * 
     * @param rent
     *            holds information about {@link Machine} to rent and
     *            {@link Customer} who wants to rent a machine.
     */
    void rentMachine(RentDTO rent);

}
