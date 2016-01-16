package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;

/**
 * @author Matej Jakimov
 */
@Controller
@RequestMapping("/customer")
// @PreAuthorize("hasRole('ROLE_ADMIN')")
public class CustomerController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(Model model) {
        List<CustomerDTO> customers = customerFacade.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder,
            RedirectAttributes redirectAttributes) {
        CustomerDTO customer = customerFacade.findById(id);

        if (customer == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Error during deleting customer");
            return "redirect:" + uriBuilder.path("customer").toUriString();
        }
        customerFacade.deleteCustomer(customer);
        redirectAttributes.addFlashAttribute("alert_success",
                "Customer \"" + customer.getUsername() + "\" was deleted.");
        // return "redirect:" + uriBuilder.path("customer").toUriString();
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        CustomerDTO customer = customerFacade.findById(id);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find user");
            return "redirect:" + uriBuilder.path("customer").toUriString();
        }
        model.addAttribute("customer", customer);

        return "customer/detail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        CustomerDTO customer = customerFacade.findById(id);

        if (customer == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find user");
            return "redirect:" + uriBuilder.path("customer").toUriString();
        }

        model.addAttribute("customer", customer);
        model.addAttribute("types", CustomerTypeDTO.values());

        return "customer/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@Valid @ModelAttribute("customer") CustomerDTO customer, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        CustomerDTO oldCustomer = customerFacade.findById(customer.getId());

        logger.info("EDIT CUSTOMER");

        if (oldCustomer == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find customer");
            return "redirect:" + uriBuilder.path("customer").toUriString();
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("alert_error", "There are some errors in form");
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "customer/edit/" + customer.getId();
        }

        try {
            customer.setUsername(oldCustomer.getUsername());
            customer.setPassword(oldCustomer.getPassword());
            customer.setRole(oldCustomer.getRole());

            customerFacade.updateCustomer(customer);
        } catch (Exception e) {
            logger.error(e);
            redirectAttributes.addFlashAttribute("alert_error", "Error during update");
            return "customer/edit/" + customer.getId();
        }

        redirectAttributes.addFlashAttribute("alert_success", "Customer " + customer.getUsername() + " was updated");

        return "redirect:" + uriBuilder.path("/customer/detail/" + oldCustomer.getId()).toUriString();
    }

}
