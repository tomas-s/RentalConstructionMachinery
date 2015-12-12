package cz.mufi.PA165.RentalConstructionMachinery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cz.mufi.PA165.RentalConstructionMachinery.dto.LoginDTO;
//import cz.mufi.PA165.RentalConstructionMachinery.facade.LoginFacade;


/**
 * @author Matej Jakimov
 */
@Controller
public class LoginController
{
    //@Autowired
    //private LoginFacade loginFacade;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("login");
        model.addObject("loginDTO", new LoginDTO());
        return model;
    }


    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response
                                     //@ModelAttribute("loginDTO") LoginDTO loginDTO)
    )
    {
        LoginDTO loginDTO = null;
        ModelAndView model= null;
        try
        {
            //boolean isValidUser = loginFacade.isLoginValid(loginDTO.getUsername(), loginDTO.getPassword());
            boolean isLoginValid = false;
            if(isLoginValid)
            {
                // process login
                model = new ModelAndView("login");
                model.addObject("loginDTO", loginDTO);
                request.setAttribute("message", "Ok");
            }
            else
            {
                model = new ModelAndView("login");
                model.addObject("loginDTO", loginDTO);
                request.setAttribute("message", "Invalid credentials");
            }

        }
        catch(Exception e) {
            request.setAttribute("message", "Error during login process, please try it again");
        }

        return model;
    }

}

