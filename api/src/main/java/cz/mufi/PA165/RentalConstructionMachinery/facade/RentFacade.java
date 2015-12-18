package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.Date;
import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;

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

    List<RentDTO> getRentsByCustomer(CustomerDTO customer, Date from, Date to);

}
