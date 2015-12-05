package cz.mufi.PA165.RentalConstructionMachinery.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 * @author Matej Jakimov
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerFacade customerFacade;

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customer/index";
    }
}
