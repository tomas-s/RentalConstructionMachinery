package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;

@Controller
@RequestMapping("/machine")
public class MachineController implements InitializingBean {

    protected final Log logger = LogFactory.getLog(getClass());

    // @Autowired
    // Comparator<String> comparator;

    @Autowired
    private MachineFacade machineFacade;

    // @RequestMapping("/machine")
    // public ModelAndView handleRequest(HttpServletRequest request,
    // HttpServletResponse response)
    // throws ServletException, IOException {
    //
    // String now = (new Date()).toString();
    // logger.info("Returning hello view with " + now);
    //
    // return new ModelAndView("machine", "now", now);
    // }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");

        model.addAttribute("flights", "aaa"); // flightService.getFlightsList()
        return "machine/machine";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");
        logger.info("MMMMMMMMMMMMMMMMMMMMMMMM");

    }

}
