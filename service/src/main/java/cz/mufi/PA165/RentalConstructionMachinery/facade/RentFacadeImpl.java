package cz.mufi.PA165.RentalConstructionMachinery.facade;

import cz.mufi.PA165.RentalConstructionMachinery.domain.Rent;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.exceptions.ServiceException;
import cz.mufi.PA165.RentalConstructionMachinery.service.BeanMappingService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentService;
import cz.mufi.PA165.RentalConstructionMachinery.service.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author Matej Jakimov
 */
@Component
@Transactional
public class RentFacadeImpl implements RentFacade {

    @Autowired
    private RentService rentService;

    @Autowired
    private BeanMappingService mappingService;

    @Override
    public void rentMachine(RentCreateDTO rentCreateDTO) throws ServiceException {
        rentService.createRent(mappingService.map(rentCreateDTO, Rent.class));
    }

    public void deleteRent(Long rentId) {
        Rent rent = rentService.findRentById(rentId);
        rentService.deleteRent(rent);
    }

    public List<RentDTO> getRentsForNextWeek() {
        return mappingService.map(rentService.getRentsForNextWeek(), RentDTO.class);
    }

    public List<RentDTO> getRentsBetween(Date from, Date to) {
        return mappingService.map(rentService.getRentsBetween(from, to), RentDTO.class);
    }

}
