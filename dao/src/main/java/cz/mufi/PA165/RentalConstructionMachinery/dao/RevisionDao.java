package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;

import java.util.Date;
import java.util.List;
/*
*@author Tomas
*/
public interface RevisionDao extends Dao<Revision> {

    List<Revision> getRevisionsForMachineBetween(Machine machine, Date from, Date to);

    List<Revision> getRevisionsBetween(Date from, Date to);

    boolean revisionExists(Machine machine, Date from, Date to);
}
