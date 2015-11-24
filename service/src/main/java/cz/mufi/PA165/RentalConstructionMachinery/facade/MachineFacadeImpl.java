package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.MachineService;

@Component
public class MachineFacadeImpl implements MachineFacade {

    @Autowired
    private MachineService machineService;

    @Override
    public void addMachine(MachineDTO machine) {
        machineService.addMachine(machine);
    }

    @Override
    public void removeMachine(MachineDTO machine) {
        machineService.removeMachine(machine);

    }

    @Override
    public List<MachineDTO> getAvailableMachines(Date sinceDate, Date tillDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MachineDTO> getRentedMachines(Date sinceDate, Date tillDate) {
        // TODO Auto-generated method stub
        return null;
    }

}
