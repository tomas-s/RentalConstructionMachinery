package cz.mufi.PA165.RentalConstructionMachinery.service;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.RentDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private RevisionService revisionService;

    public Rent createRent(Rent rent) throws ServiceException {

        if (revisionService.revisionExistsBetween(rent.getMachine(),
                rent.getRentSinceDate(), rent.getRentTillDate())) {
            throw new ServiceException("Cannot create new rent due to planned revision");
        }

        if (rentDao.hasConflict(rent.getMachine(), rent.getRentSinceDate(),
                rent.getRentTillDate())) {
            throw new ServiceException("Cannot create new rent, conflict with another rent");
        }

        return rentDao.create(rent);
    }

    public void deleteRent(Rent rent) {
        rentDao.delete(rent);
    }

    public Rent findRentById(Long id) {
        return rentDao.findById(id);
    }

    public List<Rent> getRentsBetween(Date from, Date to) {
        return rentDao.getRentsBetween(from, to);
    }

    public List<Rent> getMachineRentsBetween(Machine machine, Date from, Date to) {
        return rentDao.getMachineRentsBetween(machine, from, to);
    }

    public boolean hasConflict(Machine machine, Date at) {
        return rentDao.hasConflict(machine, at);
    }

    public List<Rent> getRentsForNextWeek() {
        Calendar calendar = Calendar.getInstance();
        Date from = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date to = calendar.getTime();
        return rentDao.getRentsBetween(from, to);
    }

}
