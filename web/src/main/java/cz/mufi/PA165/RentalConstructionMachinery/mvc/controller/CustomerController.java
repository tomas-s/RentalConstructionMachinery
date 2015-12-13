package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController implements InitializingBean {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView helloWorld() {

        String message = "<b>CUSTOMER<b>";

        System.out.println(message);

        return new ModelAndView("customer/customer", "message", message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("AAAAAAAAAAAAAAAAAAAAAAA");

    }
}
