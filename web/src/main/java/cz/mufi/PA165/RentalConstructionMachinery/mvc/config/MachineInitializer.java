package cz.mufi.PA165.RentalConstructionMachinery.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.facade.CustomerFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;
import java.util.Date;

/**
 * 
 * @author zdenek skerik
 *
 */
@Component
public class MachineInitializer  extends ContextLoaderListener {

	  @Autowired
	    public MachineInitializer(MachineFacade machineFacade, RevisionFacade revisionFacade) {

	        MachineDTO m1 = new MachineDTO();
	        m1.setMachineType(MachineType.CRANE);
	        machineFacade.addMachine(m1);     
	        System.out.println("Imported machine m1.");
	        
	        MachineDTO m2 = new MachineDTO();
	        m2.setMachineType(MachineType.CRANE);
	        machineFacade.addMachine(m2);
	        System.out.println("Imported machine m2.");
	        
	        MachineDTO m3 = new MachineDTO();
	        m3.setMachineType(MachineType.LORRY);
	        machineFacade.addMachine(m3);
	        System.out.println("Imported machine m3.");
	        
	        MachineDTO m4 = new MachineDTO();
	        m4.setMachineType(MachineType.DIGGER);
	        machineFacade.addMachine(m4);
	        System.out.println("Imported machine m4.");
	        
	        MachineDTO m5 = new MachineDTO();
	        m5.setMachineType(MachineType.DUMPER);
	        machineFacade.addMachine(m5);
	        System.out.println("Imported machine m5.");
	        
	        MachineDTO m6 = new MachineDTO();
	        m6.setMachineType(MachineType.FEEDER);
	        machineFacade.addMachine(m6);
	        System.out.println("Imported machine m6.");
	        
	        MachineDTO m7 = new MachineDTO();
	        m7.setMachineType(MachineType.LORRY);
	        machineFacade.addMachine(m7);
	        System.out.println("Imported machine m7.");
                
                RevisionCreateDTO r1= new RevisionCreateDTO();
                r1.setMachine(machineFacade.getAllMachines().get(0));
                r1.setRevisionDate(new Date(2015,11,10));
                revisionFacade.createRevision(r1);
                
                RevisionCreateDTO r2= new RevisionCreateDTO();
                r2.setMachine(machineFacade.getAllMachines().get(1));
                r2.setRevisionDate(new Date(2014,5,2));
                revisionFacade.createRevision(r2);

	    }
}
