package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.MachineServiceImpl;

@Component
public class MachineFacadeImpl implements MachineFacade {

    @Autowired
    private MachineServiceImpl machineService;

    @Autowired
    private BeanMappingService mappingService;

    @Override
    public void addMachine(MachineDTO machineDTO) {

        Machine machine = mappingService.map(machineDTO, Machine.class);
        machineService.addMachine(machine);
    }

    @Override
    public void removeMachine(Long id) {
        Machine machine = machineService.findMachineById(id);
        machineService.removeMachine(machine);

    }

    @Override
    public List<MachineDTO> getAvailableMachines(Date sinceDate, Date tillDate) {
        return mappingService.map(machineService.getAvailableMachines(sinceDate, tillDate), MachineDTO.class);
    }

    @Override
    public List<MachineDTO> getRentedMachines(Date sinceDate, Date tillDate) {
        return mappingService.map(machineService.getRentedMachines(sinceDate, tillDate), MachineDTO.class);
    }

}
