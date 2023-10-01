package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;

import org.springframework.ui.Model;

@Controller
public class PiscinaController {
    
    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscina(Model model) {
        model.addAttribute( "piscinas", piscinaRepository.findAll());
        return "piscinas";
    }

    @GetMapping("/piscinas/new")
    public String piscinaNew(Model model) {
        model.addAttribute( "piscina", new Piscina());
        return "piscinasNew";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaNewSave(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertPiscina(piscina.getCapacidad(), piscina.getApertura(), piscina.getCierre(), 
                                        piscina.getValor(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/edit")
    public String piscinaEdit(@PathVariable("id") int id,Model model) {
        Piscina piscina = piscinaRepository.findPiscinaById(id);
        if (piscina != null){
            model.addAttribute( "piscina", piscina);
            return "piscinasEdit";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{id}/edit/save")
    public String piscinaEditSave(@PathVariable("id") int id, @ModelAttribute Piscina piscina) {
        piscinaRepository.updatePiscina(id, piscina.getCapacidad(), piscina.getApertura(), piscina.getCierre(), 
                                        piscina.getValor(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/delete")
    public String piscinaDelete(@PathVariable("id") int id) {
        piscinaRepository.deletePiscina(id);
        return "redirect:/piscinas";
    }

}
