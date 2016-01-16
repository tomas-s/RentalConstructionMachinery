package cz.mufi.PA165.RentalConstructionMachinery.rest.conversion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;

/**
 * 
 * @author zdenek
 *
 */
@Component
public class StringToMachineConverter implements Converter<String, MachineDTO> {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private MachineFacade machineFacade;

    public MachineDTO convert(String id) {
        try {
            Long ID = Long.parseLong(id);
            MachineDTO m = machineFacade.getMachineById(ID);
            return m;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
