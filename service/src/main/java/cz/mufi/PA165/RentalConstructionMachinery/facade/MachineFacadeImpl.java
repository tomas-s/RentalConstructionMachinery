package cz.mufi.PA165.RentalConstructionMachinery.facade;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.MachineService;

@Component
public class MachineFacadeImpl implements MachineFacade {

    @Autowired
    private MachineService machineService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public void addMachine(MachineDTO machineDTO) {

        Machine machine = dozerBeanMapper.map(machineDTO, Machine.class);
        machineService.addMachine(machine);
    }

    @Override
    public void removeMachine(Long id) {
        Machine machine = machineService.findMachineById(id);
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
