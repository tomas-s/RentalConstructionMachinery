/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.rest.controler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tomas
 */

@Path("/")
public class CustomerRestControler {

    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyRESTService() {
        String result = "Basic restservice";

        return result;

    }
}
