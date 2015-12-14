/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.rest.controler;

import com.sun.jersey.spi.inject.Inject;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import java.util.Date;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author tomas
 */

@Component
@Path("/")
public class CustomerRestControler {

    @Autowired RevisionCreateDTO revisionCreateDTO; //tuto to zhavaruje ono si treba pozriet ako prepojit Jersey(rest Framework) zo springom
    
     
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyRESTService() {
        String result = "Basic restservice";

        return result;

    }
    
    
    @GET
    @Path("/customer")
    @Produces(MediaType.APPLICATION_XML)
    public RevisionCreateDTO getCustomer(){
       // CustomerDTO customerDTO =new CustomerDTO();
       Date date = new Date(97, 1, 23);
       
       
        revisionCreateDTO.setRevisionDate(date);
        revisionCreateDTO.setMachine(new MachineDTO());
        return revisionCreateDTO;
    }
}
