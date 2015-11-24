package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.springframework.beans.factory.annotation.Autowired;

import cz.mufi.PA165.RentalConstructionMachinery.dao.MachineDao;
import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;

public class MachineService {

    @Autowired
    private MachineDao machineDao;

    public void addMachine(Machine machine) {
        machineDao.create(machine);
    }

    public void removeMachine(Machine machine) {
        machineDao.delete(machine);
    }

    public Machine findMachineById(long id) {
        return machineDao.findById(id);
    }
}
