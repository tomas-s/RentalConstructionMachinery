package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;

@Component
public interface MachineFacade {

    void addMachine(MachineDTO machine);

    void removeMachine(MachineDTO machine);

    List<MachineDTO> getAvailableMachines(Date sinceDate, Date tillDate);

    List<MachineDTO> getRentedMachines(Date sinceDate, Date tillDate);
}
