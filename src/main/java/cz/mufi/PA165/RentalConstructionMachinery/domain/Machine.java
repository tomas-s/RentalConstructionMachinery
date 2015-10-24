package cz.mufi.PA165.RentalConstructionMachinery.domain;

import java.util.Date;
import java.util.List;

import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;

public class Machine {
	
	private Long id;
	
	private List<Revision> revisionHistory;
	
	// Toto je tu navic, prislo mi to blby tu mit jen id :)
	private MachineType machineType;

}
