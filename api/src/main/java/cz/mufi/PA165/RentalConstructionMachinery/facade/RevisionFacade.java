package cz.mufi.PA165.RentalConstructionMachinery.facade;

import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;

@Component
public interface RevisionFacade {

    void reviseMachine(RevisionDTO revision);

}
