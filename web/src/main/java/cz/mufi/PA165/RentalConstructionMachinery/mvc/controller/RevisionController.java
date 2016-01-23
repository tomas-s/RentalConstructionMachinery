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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
//        this.init();
        revision = new ArrayList<>();
        revision = revisionFacade.getAllRevisions();

        model.addAttribute("Revisions", revision); 
        return "revision/list";
    }
    
    //potom odstranit throw
    //funguje treba potom do menu pridat 
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
    
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findRevision(Model model) {
//                String dateSince = new String();
//                String dateTill = new String();
//        model.addAttribute("dateSince", dateSince); 
//        model.addAttribute("dateTill", dateTill); 
        return "revision/find";
    }
    
    
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String listUser(Model model) {
        revision = new ArrayList<>();
        revision = revisionFacade.getAllRevisions();

        model.addAttribute("Revisions", revision); 
        return "revision/listUser";
    }
    
     @RequestMapping(value="/create", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        
        List<MachineDTO> list=machineFacade.getAllMachines();
        model.addAttribute("list", list);
        model.addAttribute("ahoj", "Ahoj");
        return "create";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute RevisionDTO revision, Model model) {
        model.addAttribute("greeting", revision);
        return "result";
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