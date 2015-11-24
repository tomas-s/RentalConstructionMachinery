package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

@Component
public interface RevisionFacade {

    /**
     * Revise machine. Each machine needs regular revisions.
     * 
     * @param revision
     */
    void reviseMachine(Long idMachine);

}
