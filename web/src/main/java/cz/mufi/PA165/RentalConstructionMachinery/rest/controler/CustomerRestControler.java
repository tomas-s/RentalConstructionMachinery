/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.rest.controler;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;
import cz.mufi.PA165.RentalConstructionMachinery.rest.controler.exception.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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

    private RevisionCreateDTO revision;

    private MachineDTO machine;

    public void init() {
//        rent = new RentDTO();
//        List<RentDTO>  list = null;
//        list.add(rent);
        customerDto = new CustomerDTO();
        //customerDto.setId(Long.MIN_VALUE);
        customerDto.setFirstName("first");
        customerDto.setLastName("last");
        customerDto.setCustomerType(CustomerTypeDTO.NATURAL);
        customerDto.setPhoneNumber("112");
        customerDto.setPassword("1111");
        customerDto.setUsername("janko");
        customerDto.setRole("admin");

    }

    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyRESTService() {
        String result = "Verify rest service";
        return result;
//test   curl -u admin:admin  -X GET http://localhost:8080/PA165/rest/verify

    }

    
    
    
//<customerDTO><customerType>LEGAL</customerType><firstName>admin</firstName><id>1</id><lastName>adminovic</lastName><password>8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918</password><phoneNumber>666</phoneNumber><role>ROLE_ADMIN</role><username>admin</username></customerDTO>
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
            
   //funguje <customerDTO><customerType>NATURAL</customerType><firstName>first</firstName><lastName>last</lastName><password>1111</password><phoneNumber>112</phoneNumber><role>admin</role><username>janko</username></customerDTO>
   // <customerDTO><customerType>NATURAL</customerType><firstName>dsd</firstName><lastName>aa</lastName><password>525</password><phoneNumber>22</phoneNumber><role>user</role><username>ss</username></customerDTO>

    }

    //ak pojde Autowired tak treba odstranit metodu revisionFacade.ahoj(); a to iste aj pri customerFacade
//    @GET
//    @Path("/customer/add")
//    @Produces(MediaType.APPLICATION_XML)
//    
//    public CustomerDTO adddCustomer() {
//        this.init();
//
//        return customerFacadeImpl.createNewCustomer(customerDto);
//    }

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
//curl -u admin:admin  -X GET http://localhost:8080/PA165/rest/list/1

    }
//curl -X POST -d @filename http://hostname/resource
    @GET
    @Path("customer/list")
    @Produces(MediaType.APPLICATION_XML)
    @Transactional
    public List<CustomerDTO> getAllCustomer() {
        return customerFacadeImpl.getAllCustomers();
    }

    
    
    
//    http://localhost:8080/PA165/rest/customer/1 funguje delete
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
    
    
    
    //<customerDTO><customerType>LEGAL</customerType><firstName>user</firstName><id>2</id><lastName>userovic</lastName><password>1111</password><phoneNumber>777</phoneNumber><role>ROLE_USER</role><username>user</username></customerDTO>
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
