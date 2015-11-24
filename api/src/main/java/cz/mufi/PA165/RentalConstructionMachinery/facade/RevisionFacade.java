package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;

@Component
public interface RevisionFacade {

    /**
     * Revise machine. Each machine needs regular revisions.
     * 
     * @param revision
     */
    void reviseMachine(RevisionDTO revision);

}
