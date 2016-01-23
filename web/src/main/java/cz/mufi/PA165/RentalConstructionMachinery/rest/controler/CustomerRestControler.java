/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.rest.controler;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import cz.mufi.PA165.RentalConstructionMachinery.rest.controler.exception.EntityNotFoundException;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author tomas
 */
@Component
@Path("/")
@Transactional
public class CustomerRestControler {

    @Autowired
    CustomerFacade customerFacadeImpl;

    private CustomerDTO customerDto;

    /**
     *Verify of rest service
     * @return
     */
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyRESTService() {
        String result = "Verify rest service";
        return result;

    }

    /**
     * add customer 
     * @param customer
     * @return
     */
    @POST
    @Path("/customer")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public CustomerDTO addCustomer(CustomerDTO customer) {
        try{
            return customerFacadeImpl.createNewCustomer(customer);
        }
        catch(Exception e){
            throw new EntityNotFoundException(customer.getId());
        }
            

    }

    /**
     * show customer 
     * @param id
     * @return
     */
    @GET
    @Path("customer/list/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Transactional
    public CustomerDTO findCustomer(@PathParam("id") String id) {
        long customerId = Long.parseLong(id);
        try {
            CustomerDTO result = customerFacadeImpl.findById(customerId);
            return result;
        } catch (Exception e) {
            throw new EntityNotFoundException(customerId);
        }


    }

    /**
     * show all customers
     * @return
     */
    @GET
    @Path("customer/list")
    @Produces(MediaType.APPLICATION_XML)
    @Transactional
    public List<CustomerDTO> getAllCustomer() {
        return customerFacadeImpl.getAllCustomers();
    }

    /**
     * delete customer by id
     * @param id
     * @return
     */
    @DELETE
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String delete(@PathParam("id") String id) {
        {
            long customerId = Long.parseLong(id);
            CustomerDTO customer = customerFacadeImpl.findById(customerId);
            if (customer != null) {
                customerFacadeImpl.deleteCustomer(customer);
                return "Succes";
            } else {
                throw new EntityNotFoundException(customerId);
            }
        }

    }
    
    /**
     * update customer
     * @param id
     * @param customer
     * @return
     */
    @PUT
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public CustomerDTO update(@PathParam("id") long id,CustomerDTO customer){
        customer.setId(id);
        try{
        customerFacadeImpl.updateCustomer(customer);
        }
        catch(Exception e ){
            throw new EntityNotFoundException(id);
        }
        
        return customerFacadeImpl.findById(id);
    }
    
    
    
    
}
