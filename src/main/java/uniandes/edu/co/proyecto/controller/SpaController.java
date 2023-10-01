package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.repositorio.SpaRepository;

import org.springframework.ui.Model;

@Controller
public class SpaController {
    
    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spa(Model model) {
        model.addAttribute( "spas", spaRepository.findAll());
        return "spas";
    }

    @GetMapping("/spas/new")   
    public String spaNew(Model model) {
        model.addAttribute( "spa", new Spa());
        return "spasNew";
    }

    @PostMapping("/spas/new/save")
    public String spaNewSave(@ModelAttribute Spa spa) {
        spaRepository.insertSpa(spa.getCapacidad(), spa.getApertura(), spa.getCierre(), spa.getFranja());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEdit(@PathVariable("id") int id,Model model) {
        Spa spa = spaRepository.findSpaById(id);
        if (spa != null){
            model.addAttribute( "spa", spa);
            return "spasEdit";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditSave(@PathVariable("id") int id, @ModelAttribute Spa spa) {
        spaRepository.updateSpa(id, spa.getCapacidad(), spa.getApertura(), spa.getCierre(), spa.getFranja());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/delete")
    public String spaDelete(@PathVariable("id") int id) {
        spaRepository.deleteSpa(id);
        return "redirect:/spas";
    }

}
