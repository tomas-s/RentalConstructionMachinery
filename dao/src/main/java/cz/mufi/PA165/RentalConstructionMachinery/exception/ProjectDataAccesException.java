/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mufi.PA165.RentalConstructionMachinery.exception;

import org.springframework.dao.DataAccessException;

/**
 *
 * @author tomas
 */
public class ProjectDataAccesException extends DataAccessException{
    public ProjectDataAccesException(String msg){
        super(msg);
    }
    
    public ProjectDataAccesException(String msg, Throwable cause) {
        super(msg, cause);
    }

   
    
}
