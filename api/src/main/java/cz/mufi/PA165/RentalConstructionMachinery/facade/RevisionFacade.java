package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

public interface RevisionFacade {

    /**
     * Revise machine. Each machine needs regular revisions.
     * 
     * @param revision
     */
    void createRevision(RevisionCreateDTO revision) throws ServiceException;

    void deleteRevision(long revisionId);

    List<RevisionDTO> getRevisionsBetween(Date from, Date to);
    
    public List<RevisionDTO> getAllRevisions();
    
    public RevisionDTO findById(long id);
    
    void updateRevision(RevisionDTO revision);

}
