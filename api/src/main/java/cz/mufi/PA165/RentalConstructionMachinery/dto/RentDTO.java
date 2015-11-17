package cz.mufi.PA165.RentalConstructionMachinery.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class RentDTO {

    private Long id;

    @NotNull
    private MachineDTO machine;

    @NotNull
    private CustomerDTO customer;

    @NotNull
    private Date rentSinceDate;

    @NotNull
    private Date rentTillDate;

}
