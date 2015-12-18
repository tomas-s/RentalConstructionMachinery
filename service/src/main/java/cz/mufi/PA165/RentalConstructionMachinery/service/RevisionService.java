package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.RevisionDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by jakac on 27.11.15.
 */
public interface RevisionService {

    boolean revisionExistsBetween(Machine machine, Date from, Date to);

    List<Revision> getRevisionsBetween(Date from, Date to);

    List<Revision> getMachineRevisionBetween(Machine machine, Date from, Date to);

    Revision createRevision(Revision revision) throws ServiceException;

    void deleteRevision(Revision revision);

    Revision findRevisionById(Long id);
    
    public List<Revision> getAllRevision();
    
    public void updateRevision(Revision revision);

}
