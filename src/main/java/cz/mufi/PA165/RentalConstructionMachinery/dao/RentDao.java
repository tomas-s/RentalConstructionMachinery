package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import java.util.List;

public interface RentDao {
    
    public void create(Rent revision);
    
    public void delete(Rent revision);
    
    public Rent update(Rent revision);
    
    public Rent findById(Rent revision);

    public List<Rent> findAll();
}
