package cz.mufi.PA165.RentalConstructionMachinery.facade;

public interface RentFacade {

    /**
     * Rent machine.
     * 
     * @param idMachine
     * @param idCustomer
     */
    void rentMachine(Long idMachine, Long idCustomer);

}
