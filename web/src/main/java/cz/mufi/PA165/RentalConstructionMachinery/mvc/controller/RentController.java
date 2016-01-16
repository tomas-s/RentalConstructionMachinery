package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RentDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RentFacade;

/**
 * 
 * @author zdenek skerik
 *
 */
@Controller
@RequestMapping("/rent")
public class RentController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RentFacade rentFacade;

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private MachineFacade machineFacade;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAll(Model model) {

        List<RentDTO> rents;

        try {
            rents = rentFacade.getRentsBetween(sdf.parse("2000-01-01"), sdf.parse("2100-01-01"));
            logger.info(rents.size());
            model.addAttribute("rents", rents);
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("rents", new ArrayList<RentDTO>());
        }

        return "rent/list";
    }

    @RequestMapping(value = "/list/{idCustomer}", method = RequestMethod.GET)
    public String listAll(@PathVariable long idCustomer, Model model) {

        final CustomerDTO customer = customerFacade.findById(idCustomer);
        logger.info(customer);

        List<RentDTO> rents;
        try {
            rents = rentFacade.getRentsByCustomer(customer, sdf.parse("2000-01-01"), sdf.parse("2100-01-01"));
            logger.info(rents.size());
            model.addAttribute("rents", rents);
        } catch (ParseException e1) {
            e1.printStackTrace();
            model.addAttribute("rents", new ArrayList<RentDTO>());
        }

        return "rent/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newRent(Model model, Principal principal) {

        // Get active user
        CustomerDTO activeUser = (CustomerDTO) ((Authentication) principal).getPrincipal();

        // Create new rent
        RentCreateDTO rent = new RentCreateDTO();
        rent.setCustomer(activeUser);

        List<MachineDTO> machines = machineFacade.getAllMachines();

        model.addAttribute("rent", rent);
        model.addAttribute("machines", machines);
        return "rent/new";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newRentPost(@Valid @ModelAttribute("rent") RentCreateDTO rent, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Principal principal) {

        // Get active user
        CustomerDTO activeUser = (CustomerDTO) ((Authentication) principal).getPrincipal();

        rent.setCustomer(activeUser);

        rentFacade.rentMachine(rent);

        return "redirect:" + uriBuilder.path("/rent/list/" + rent.getCustomer().getId()).toUriString();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
