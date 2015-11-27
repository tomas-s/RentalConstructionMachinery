package cz.mufi.PA165.RentalConstructionMachinery.dao;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class RentDaoImpl extends DaoGenericImpl<Rent> implements RentDao {

    public List<Rent> getMachineRentsBetween(Machine machine, Date from, Date to) {
        return em.createQuery("SELECT r FROM Rent r WHERE r.machine = ?1 " +
                "AND r.rentTillDate > ?2 AND r.rentSinceDate < ?3", Rent.class)
                .setParameter(1, machine)
                .setParameter(2, from)
                .setParameter(3, to).getResultList();
    }

    public List<Rent> getRentsBetween(Date from, Date to) {
        return em.createQuery("SELECT r FROM Rent r WHERE " +
                " r.rentTillDate > ?2 AND r.rentSinceDate < ?3", Rent.class)
                .setParameter(2, from)
                .setParameter(3, to).getResultList();
    }

    public boolean hasConflict(Machine machine, Date from, Date to) {
        return getMachineRentsBetween(machine, from, to).size() > 0;
    }

    public boolean hasConflict(Machine machine, Date at) {
        return getMachineRentsBetween(machine, at, at).size() > 0;
    }
}
