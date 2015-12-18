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
import cz.mufi.PA165.RentalConstructionMachinery.facade.RevisionFacade;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/revision")
public class RevisionController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    List<RevisionDTO> revision;

    @Autowired
        private RevisionFacade revisionFacade;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
//        this.init();
        revision = new ArrayList<>();
        revision = revisionFacade.getAllRevisions();
//        revision = RevisionFacade.getRevisionsBetween(new Date(2014, 2, 1), new Date(2014,7,10));
//        revision.add(r);
//        revision = revisionFacade.getRevisionsBetween(new Date(2014, 2, 1), new Date(2014,7,10));
//        revision.add(r);
        
        model.addAttribute("Revisions", revision); 
        return "revision/list";
    }
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder,
                         RedirectAttributes redirectAttributes) {
        RevisionDTO r = revisionFacade.findById(id);
//        r = revision.get((int)id);
        
        if(r == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Error during deleting Revision");
            return "redirect:" + uriBuilder.path("revision").toUriString();
        }
        else{
        revisionFacade.deleteRevision(r.getId()); //potom pouzit RevisionCreateDTO
        redirectAttributes.addFlashAttribute("alert_success", "Revision \"" + r.getId()+ "\" was deleted.");
        //return "redirect:" + uriBuilder.path("customer").toUriString();
        return "redirect:/revision/list";
        }
    }
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model, RedirectAttributes redirectAttributes,
                       UriComponentsBuilder uriBuilder) {
        RevisionDTO r = revisionFacade.findById(id);

        

        if(r == null){
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find revision");
            return "redirect:" + uriBuilder.path("revision").toUriString();
        }

        model.addAttribute("revision", r);
//        model.addAttribute("types", CustomerTypeDTO.values());

        return "revision/edit";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@Valid @ModelAttribute("revision") RevisionDTO revision,
                           BindingResult bindingResult, Model model,
                           RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        RevisionDTO oldRevision = revisionFacade.findById(revision.getId());
        
        logger.info("EDIT REVISION");

        if(oldRevision == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find customer");
            return "redirect:" + uriBuilder.path("customer").toUriString();
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("alert_error", "There are some errors in form");
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "revision/edit/" + revision.getId();
        }

        try {
            
            revision.setMachine(oldRevision.getMachine());

            revisionFacade.updateRevision(revision);
        } catch(Exception e) {
            logger.error(e);
            redirectAttributes.addFlashAttribute("alert_error", "Error during update");
            return "customer/edit/" + revision.getId();
        }

        redirectAttributes.addFlashAttribute("alert_success", "Customer " + revision.getId()+ " was updated");

        return "redirect:" + uriBuilder.path("revision").toUriString();
    }
    
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes,
                         UriComponentsBuilder uriBuilder) {
        RevisionDTO r = revisionFacade.findById(id);
//        r = revision.get(((int)id)-1);
        
        if(r == null) {
            redirectAttributes.addFlashAttribute("alert_error", "Cannot find revision");
            return "redirect:" + uriBuilder.path("revision").toUriString();
        }
        model.addAttribute("revision", r);

        return "revision/detail";
    }


}