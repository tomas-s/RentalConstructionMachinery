package cz.mufi.PA165.RentalConstructionMachinery.service;

import java.util.Date;
import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;

/**
 * 
 * @author zdenek
 *
 */
public interface MachineService {

    /**
     * Add a new machine to our offer.
     * 
     * @param machine
     */
    void addMachine(Machine machine);

    /**
     * Remove machine from our offer.
     * 
     * @param machine
     */
    void removeMachine(Machine machine);

    /**
     * Find machone by ID.
     * 
     * @param id
     * @return
     */
    Machine findMachineById(Long id);

    /**
     * Get all machines.
     * @return
     */
    List<Machine> getAllMachines();
    
    /**
     * Get available machines to rent in passed time period.
     * 
     * @param sinceDate
     * @param tillDate
     * @return
     */
    List<Machine> getAvailableMachines(Date sinceDate, Date tillDate);

    /**
     * Get rented machones in passed time period.
     * 
     * @param sinceDate
     * @param tillDate
     * @return
     */
    List<Machine> getRentedMachines(Date sinceDate, Date tillDate);

}
