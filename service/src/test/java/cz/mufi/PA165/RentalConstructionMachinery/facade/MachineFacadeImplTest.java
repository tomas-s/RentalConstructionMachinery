package cz.mufi.PA165.RentalConstructionMachinery.facade;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Machine;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.MachineService;

/**
 * 
 * @author zdenek
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mainApplicationContext.xml" })
@Transactional
public class MachineFacadeImplTest {

    @InjectMocks
    private MachineFacadeImpl machineFacade;

    @Autowired
    @Mock
    private MachineService machineService;

    @Autowired
    @Mock
    private BeanMappingService mappingService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMachine() throws Exception {

        Machine machine = new Machine();
        MachineDTO machineDTO = new MachineDTO();

        when(mappingService.map(machineDTO, Machine.class)).thenReturn(machine);
        doNothing().when(machineService).addMachine(machine);

        machineFacade.addMachine(machineDTO);

        verify(machineService).addMachine(machine);
    }

    @Test
    public void testRemoveMachine() throws Exception {
        Long id = new Long(1);
        Machine machine = new Machine();

        when(machineService.findMachineById(id)).thenReturn(machine);
        doNothing().when(machineService).removeMachine(machine);

        machineFacade.removeMachine(id);

        verify(machineService).removeMachine(machine);
    }

    @Test
    public void testGetAvailableMachines() throws Exception {

        List<Machine> machines = new ArrayList<>();
        List<MachineDTO> machineDTOs = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 9); // October
        final Date sinceDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 11); // December
        final Date tillDate = calendar.getTime();

        when(machineService.getAvailableMachines(sinceDate, tillDate)).thenReturn(machines);
        when(mappingService.map(machines, MachineDTO.class)).thenReturn(machineDTOs);

        machineFacade.getAvailableMachines(sinceDate, tillDate);

        verify(machineService).getAvailableMachines(sinceDate, tillDate);
    }

    @Test
    public void testGetRentedMachines() throws Exception {
        List<Machine> machines = new ArrayList<>();
        List<MachineDTO> machineDTOs = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 9); // October
        final Date sinceDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 11); // December
        final Date tillDate = calendar.getTime();

        when(machineService.getRentedMachines(sinceDate, tillDate)).thenReturn(machines);
        when(mappingService.map(machines, MachineDTO.class)).thenReturn(machineDTOs);

        machineFacade.getRentedMachines(sinceDate, tillDate);

        verify(machineService).getRentedMachines(sinceDate, tillDate);
    }

}
