package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;

@Component
public interface RentFacade {

    void rentMachine(RentDTO revision);

}
