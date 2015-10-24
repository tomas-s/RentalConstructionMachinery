package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

public class Machine {

    private Long id;
    private List<Revision> revisionHistory;
    private List<Rent> rentHistory;
    private MachineType machineType;

}
