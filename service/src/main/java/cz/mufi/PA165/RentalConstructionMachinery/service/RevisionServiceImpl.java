package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.RevisionDao;

import java.util.Date;
import java.util.List;

@Service
public class RevisionServiceImpl implements RevisionService {

    @Autowired
    private RevisionDao revisionDao;

    @Autowired
    private RentService rentService;

    public boolean revisionExistsBetween(Machine machine, Date from, Date to)
    {
        return revisionDao.revisionExists(machine, from, to);
    }

    public List<Revision> getRevisionsBetween(Date from, Date to) {
        return revisionDao.getRevisionsBetween(from, to);
    }

    public List<Revision> getMachineRevisionBetween(Machine machine, Date from, Date to)
    {
        return revisionDao.getRevisionsForMachineBetween(machine, from, to);
    }

    public Revision createRevision(Revision revision) throws ServiceException {

        if (rentService.hasConflict(revision.getMachine(), revision.getRevisionDate())) {
            throw new ServiceException("Cannot create new revision, conflict with rent");
        }

        return revisionDao.create(revision);
    }

    public void deleteRevision(Revision revision)
    {
        revisionDao.delete(revision);
    }

}
