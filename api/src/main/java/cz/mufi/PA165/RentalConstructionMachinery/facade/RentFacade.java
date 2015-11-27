package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

public interface RentFacade {

    /**
     * Rent machine.
     * 
     * @param idMachine
     * @param idCustomer
     */
    void rentMachine(RentCreateDTO rentCreateDTO) throws ServiceException;

    void deleteRent(Long rentId);

    List<RentDTO> getRentsForNextWeek();

    List<RentDTO> getRentsBetween(Date from, Date to);

}
