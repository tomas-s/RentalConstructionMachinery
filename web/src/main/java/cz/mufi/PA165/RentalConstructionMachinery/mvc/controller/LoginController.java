package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cz.mufi.PA165.RentalConstructionMachinery.dto.LoginDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.LoginFacade;

/**
 * @author Matej Jakimov
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private LoginFacade loginFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("login/login");
        model.addObject("loginDTO", new LoginDTO());
        return model;
    }

    @RequestMapping(value = "/failure")
    public ModelAndView failure(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = login(request, response);
        request.setAttribute("message", "Wrong credentials");
        return model;
    }

    @RequestMapping(value = "/denied")
    public String denied(){
        return "login/denied";
    }

}
