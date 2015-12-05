package cz.mufi.PA165.RentalConstructionMachinery.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Matej Jakimov
 */
@Controller
public class LoginController {

    @RequestMapping(method=RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
}
