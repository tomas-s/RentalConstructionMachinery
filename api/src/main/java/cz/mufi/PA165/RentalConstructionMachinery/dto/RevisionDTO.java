package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class RevisionDTO {

    @NotNull
    private Date revisionDate;

    @NotNull
    private MachineDTO machine;

}
