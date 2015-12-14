package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;

import java.util.Date;
import java.util.List;

/**
 * @author Matej Jakimov
 */
public interface RentDao extends Dao<Rent> {

    List<Rent> getMachineRentsBetween(Machine machine, Date from, Date to);

    List<Rent> getRentsBetween(Date from, Date to);

    boolean hasConflict(Machine machine, Date from, Date to);

    boolean hasConflict(Machine machine, Date at);
}
