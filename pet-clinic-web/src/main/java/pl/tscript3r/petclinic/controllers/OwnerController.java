package pl.tscript3r.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tscript3r.petclinic.services.OwnerService;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

}