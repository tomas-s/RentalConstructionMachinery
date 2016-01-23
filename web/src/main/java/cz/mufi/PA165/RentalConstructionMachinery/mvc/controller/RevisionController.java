package cz.mufi.PA165.RentalConstructionMachinery.mvc.controller;

import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.CustomerTypeDTO;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.RevisionCreateDTO;
import cz.mufi.PA165.RentalConstructionMachinery.dto.MachineDTO;
import cz.mufi.PA165.RentalConstructionMachinery.enums.MachineType;
import cz.mufi.PA165.RentalConstructionMachinery.facade.MachineFacade;
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tomas
 */
@Controller
@RequestMapping("/revision")
public class RevisionController {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    protected final Log logger = LogFactory.getLog(getClass());
    
    List<RevisionDTO> revision;

    @Autowired
        private RevisionFacade revisionFacade;
    
    
    @Autowired
        private MachineFacade machineFacade;

    private RevisionDTO r;
    public void init(){
         r = new RevisionDTO();
         long i = 1;
         r.setId(i);
         MachineDTO machine = new MachineDTO();
         machine.setMachineType(MachineType.CRANE);
         r.setMachine(machine);
         r.setRevisionDate(new Date(2005,15,1));
    }

    /**
     *Show list of Revisions
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
//        this.init();
        revision = new ArrayList<>();
        revision = revisionFacade.getAllRevisions();

        model.addAttribute("Revisions", revision); 
        return "revision/list";
    }
    
    /**
     *Find revisions between Date Since and Date Till 
     * @param model
     * @param redirectAttributes
     * @param dateSince
     * @param dateTill
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/finded", method = RequestMethod.GET)

    public String findedRevision(Model model,RedirectAttributes redirectAttributes,@RequestParam(value="dateSince")  String dateSince,@RequestParam(value="dateTill")  String dateTill) throws ParseException {
        
       
        revision = new ArrayList<>();
        try{
        revision = revisionFacade.getRevisionsBetween(sdf.parse(dateSince),sdf.parse(dateTill));
        }
        catch(Exception e){
            logger.error(e);
            redirectAttributes.addFlashAttribute("alert_error", "Error during find");
            return "revision/error"; 
        }
        model.addAttribute("dateSince",dateSince);
        model.addAttribute("dateTill",dateTill);
        model.addAttribute("Revisions", revision); 
        return "revision/findedBy";
        
    }
    
    /**
     *Show form
     * @param model
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findRevision(Model model) {
        return "revision/find";
    }
    
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String listUser(Model model) {
        revision = new ArrayList<>();
        revision = revisionFacade.getAllRevisions();

        model.addAttribute("Revisions", revision); 
        return "revision/listUser";
    }
    
  


    /**
     * delete revision 
     * @param id
     * @param uriBuilder
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder,
                         RedirectAttributes redirectAttributes) {
        RevisionDTO r = revisionFacade.findById(id);
        
        if(r == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Error during deleting Revision");
            return "redirect:" + uriBuilder.path("revision").toUriString();
        }
        else{
        revisionFacade.deleteRevision(r.getId()); 
        redirectAttributes.addFlashAttribute("alert_success", "Revision \"" + r.getId()+ "\" was deleted.");
        return "redirect:/revision/list";
        }
    }
    
    /**
     * show detail about revision
     * @param id
     * @param model
     * @param redirectAttributes
     * @param uriBuilder
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes,
                         UriComponentsBuilder uriBuilder) {
        RevisionDTO r = revisionFacade.findById(id);
        
        if(r == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find revision");
            return "redirect:" + uriBuilder.path("revision").toUriString();
        }
        model.addAttribute("revision", r);

        return "revision/detail";
    }

  

}