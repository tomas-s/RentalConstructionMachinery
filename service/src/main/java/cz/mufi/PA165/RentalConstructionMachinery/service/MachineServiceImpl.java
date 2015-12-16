package cz.mufi.PA165.RentalConstructionMachinery.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.MachineDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Autowired
    private RentService rentService;

    @Autowired
    private RevisionService revisionService;

    @Override
    public void addMachine(Machine machine) {
        machineDao.create(machine);
    }

    @Override
    public void removeMachine(Machine machine) {
        machineDao.delete(machine);
    }

    @Override
    public Machine findMachineById(Long id) {
        return machineDao.findById(id);
    }

    @Override
    public List<Machine> getAllMachines() {
    	return machineDao.findAll();
    }
    
    @Override
    public List<Machine> getAvailableMachines(Date sinceDate, Date tillDate) {

        // Get all machines
        List<Machine> machines = machineDao.findAll();

        // Remove rented machines in this period
        Iterator<Machine> it = machines.iterator();
        while (it.hasNext()) {

            Machine machine = it.next();

            // Machine has rent, remove it
            if (rentService.getMachineRentsBetween(machine, sinceDate, tillDate).size() > 0) {
                it.remove();
            }
        }

        // Remove revisioned machines in this period
        it = machines.iterator();
        while (it.hasNext()) {

            Machine machine = it.next();

            // Machine has revision, remove it
            if (revisionService.revisionExistsBetween(machine, sinceDate, tillDate)) {
                it.remove();
            }
        }

        // Machines which left are available
        return machines;
    }

    @Override
    public List<Machine> getRentedMachines(Date sinceDate, Date tillDate) {

        // Get all rents from passed time period
        List<Rent> rents = rentService.getRentsBetween(sinceDate, tillDate);

        // Get machines from these rents
        List<Machine> machines = new ArrayList<Machine>();
        for (Rent rent : rents) {
            machines.add(rent.getMachine());
        }

        return machines;
    }
}
