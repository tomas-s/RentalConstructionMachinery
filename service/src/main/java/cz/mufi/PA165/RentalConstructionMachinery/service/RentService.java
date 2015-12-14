package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

/**
 * Created by Matej Jakimov on 27.11.15.
 */
public interface RentService {

    Rent createRent(Rent rent) throws ServiceException;

    void deleteRent(Rent rent);

    Rent findRentById(Long id);

    List<Rent> getRentsBetween(Date from, Date to);

    List<Rent> getMachineRentsBetween(Machine machine, Date from, Date to);

    boolean hasConflict(Machine machine, Date at);

    List<Rent> getRentsForNextWeek();
}
