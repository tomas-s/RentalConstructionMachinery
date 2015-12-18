package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class RevisionFacadeImpl implements RevisionFacade {

    @Autowired
    private RevisionService revisionService;

    @Autowired
    private BeanMappingService mappingService;

    @Override
    public void createRevision(RevisionCreateDTO revision) throws ServiceException {
        revisionService.createRevision(mappingService.map(revision, Revision.class));
    }

    @Override
    public void deleteRevision(long revisionId) {
        Revision r = revisionService.findRevisionById(revisionId);
        revisionService.deleteRevision(r);
    }
    
    @Override
    public List<RevisionDTO> getAllRevisions() {
    	return mappingService.map(revisionService.getAllRevision(), RevisionDTO.class);
    }

    @Override
    public List<RevisionDTO> getRevisionsBetween(Date from, Date to) {
        return mappingService.map(revisionService.getRevisionsBetween(from ,to), RevisionDTO.class);
    }
    
    @Override
    public RevisionDTO findById(long id){
        Revision r = revisionService.findRevisionById(id);
        return mappingService.map(r, RevisionDTO.class);
    }
    
    @Override
    public void updateRevision(RevisionDTO revision){
        Revision r = mappingService.map(revision, Revision.class);
        revisionService.updateRevision(r);
    }

}
