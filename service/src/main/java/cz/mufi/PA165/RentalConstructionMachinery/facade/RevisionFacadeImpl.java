package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class RevisionFacadeImpl implements RevisionFacade {

    @Autowired
    private RevisionService revisionService;

    @Autowired
    private BeanMappingService mappingService;

    public void createRevision(RevisionCreateDTO revision) throws ServiceException {
        revisionService.createRevision(mappingService.map(revision, Revision.class));
    }

    public void deleteRevision(long revisionId) {
        Revision r = revisionService.findRevisionById(revisionId);
        revisionService.deleteRevision(r);
    }

    public List<RevisionDTO> getRevisionsBetween(Date from, Date to) {
        return mappingService.map(revisionService.getRevisionsBetween(from ,to), RevisionDTO.class);
    }

}
