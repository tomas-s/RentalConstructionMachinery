package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;

@Controller
@RequestMapping("/machine")
public class MachineController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private MachineFacade machineFacade;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        
        List<MachineDTO> machines = machineFacade.getAllMachines();
        
        model.addAttribute("machines", machines); 
        return "machine/list";
    }


}
