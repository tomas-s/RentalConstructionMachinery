package cz.mufi.PA165.RentalConstructionMachinery.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.mufi.PA165.RentalConstructionMachinery.dao.MachineDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Revision;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineState;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Autowired
    private RentService rentService;

    @Autowired
    private RevisionService revisionService;

    @Override
    public Machine addMachine(Machine machine) {
        return machineDao.create(machine);
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

        List<Machine> machines = machineDao.findAll();

        for (Machine machine : machines) {
            MachineState state = getCurrentState(machine);
            machine.setMachineState(state);
        }

        return machines;
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

    @Override
    public MachineState getCurrentState(Machine machine) {

        Calendar currentDate = Calendar.getInstance();
        return getState(machine, currentDate.getTime());
    }

    @Override
    public MachineState getState(Machine machine, Date date) {

        if (machine.getRentHistory().size() != 0) {

            // Rent
            final Rent lastRent = machine.getRentHistory().get(machine.getRentHistory().size() - 1);
            final Date from = lastRent.getRentSinceDate();
            final Date to = lastRent.getRentTillDate();

            if (from.before(date) && to.after(date)) {
                return MachineState.RENT;
            }

        }

        if (machine.getRevisionHistory().size() != 0) {

            // Revised
            final Revision lastRevision = machine.getRevisionHistory().get(machine.getRevisionHistory().size() - 1);
            final Date revisionDate = lastRevision.getRevisionDate();

            if (revisionDate.equals(date)) {
                return MachineState.REVISED;
            }
        }

        return MachineState.AVAILABLE;
    }
}
