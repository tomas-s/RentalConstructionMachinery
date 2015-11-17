package cz.mufi.PA165.RentalConstructionMachinery.dto;

import javax.validation.constraints.NotNull;

public class CustomerDTO {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private CustomerType customerType;
}
