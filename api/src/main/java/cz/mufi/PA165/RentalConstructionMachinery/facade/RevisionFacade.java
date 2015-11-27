package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;

import java.util.Date;

public interface RevisionFacade {

    /**
     * Revise machine. Each machine needs regular revisions.
     * 
     * @param revision
     */
    void reviseMachine(Long machineId, Date revision_date) throws ServiceException;

}
