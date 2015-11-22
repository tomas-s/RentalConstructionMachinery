package cz.mufi.PA165.RentalConstructionMachinery.dto;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import javax.validation.constraints.NotNull;

public class MachineDTO {

    private Long id;

    @NotNull
    private MachineType machineType;

}
