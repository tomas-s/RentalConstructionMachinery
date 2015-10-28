package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import java.util.List;
/*
*@author Tomas
*/
public interface RevisionDao {
    
    public void create(Revision revision);
    
    public void delete(Revision revision);
    
    public Revision update(Revision revision);
    
    public Revision findById(Long id);
    
    public List<Revision> findAll();

}
