/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.rest.controler;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tomas
 */
public interface CustomerRestControlerI {
    
    public CustomerDTO findCustomer(@PathParam("id") String id);
    
    public List<CustomerDTO> getAllCustomer();
            
    public String delete(@PathParam("id") String id);
    
    public CustomerDTO update(@PathParam("id") long id,CustomerDTO customer);
    
    
    
}
