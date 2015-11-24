package cz.mufi.PA165.RentalConstructionMachinery.facade;

public interface RevisionFacade {

    /**
     * Revise machine. Each machine needs regular revisions.
     * 
     * @param revision
     */
    void reviseMachine(Long idMachine);

}
