package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author zdenek skerik
 *
 */
@Controller
public class HelloController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("baseUrl", request.getContextPath());

        return new ModelAndView("hello");
    }

    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("baseUrl", request.getContextPath());

        return new ModelAndView("hello");
    }
}
