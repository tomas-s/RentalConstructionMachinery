package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import java.util.List;
/*
*@author Tomas
*/
public interface RevisionDao {
    
    public List<Revision> getARevision();
    
    public void addRevision(Revision revision);
    
    public void deleteRevision(Revision revision);
    
    public Revision updateRevision(Revision revision);
    
    public Revision gedRevisionById(Revision revision);

}
