package cz.muni.PA165.RentalConstructionMachinery.controller;

import org.springframework.web.servlet.ModelAndView;

import cz.mufi.PA165.RentalConstructionMachinery.controller.HelloController;
import junit.framework.TestCase;

public class HelloControllerTest extends TestCase {

    public void testHandleRequestView() throws Exception {
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello.jsp", modelAndView.getViewName());
    }
}