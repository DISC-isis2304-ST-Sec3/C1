package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.repositorio.BarRepository;

import org.springframework.ui.Model;

@Controller
public class BaresController {
    
    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bares")
    public String bar(Model model) {
        model.addAttribute( "bares", barRepository.findAll());
        return "bares";
    }

    @GetMapping("/bares/new")
    public String barNew(Model model) {
        model.addAttribute( "bar", new Bar());
        return "baresNew";
    }

    @PostMapping("/bares/new/save")
    public String barNewSave(@ModelAttribute Bar bar) {
        barRepository.insertBar(bar.getNombre(), bar.getEstilo());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/edit")
    public String barEdit(@PathVariable("id") int id,Model model) {
        Bar bar = barRepository.findBarById(id);
        if (bar != null){
            model.addAttribute( "bar", bar);
            return "baresEdit";
        } else {
            return "redirect:/bares";
        }
    }

    @PostMapping("/bares/{id}/edit/save")
    public String barEditSave(@PathVariable("id") int id, @ModelAttribute Bar bar) {
        barRepository.updateBar(id, bar.getNombre(), bar.getEstilo());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/delete")
    public String barDelete(@PathVariable("id") int id) {
        barRepository.deleteBar(id);
        return "redirect:/bares";
    }

}
