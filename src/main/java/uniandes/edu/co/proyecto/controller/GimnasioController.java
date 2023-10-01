package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

import org.springframework.ui.Model;

@Controller
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasio(Model model) {
        model.addAttribute( "gimnasios", gimnasioRepository.findAll());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioNew(Model model) {
        model.addAttribute( "gimnasio", new Gimnasio());
        return "gimnasiosNew";
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioNewSave(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.insertGimnasio(gimnasio.getCapacidad(), gimnasio.getApertura(), 
                                        gimnasio.getCierre(), gimnasio.getValor());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/edit")
    public String gimnasioEdit(@PathVariable("id") int id,Model model) {
        Gimnasio gimnasio = gimnasioRepository.findGimnasioById(id);
        if (gimnasio != null){
            model.addAttribute( "gimnasio", gimnasio);
            return "gimnasiosEdit";
        } else {
            return "redirect:/gimnasios";
        }
    }

    @PostMapping("/gimnasios/{id}/edit/save")
    public String gimnasioEditSave(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.updateGimnasio(id, gimnasio.getCapacidad(), gimnasio.getApertura(), 
                                        gimnasio.getCierre(), gimnasio.getValor());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/delete")
    public String gimnasioDelete(@PathVariable("id") int id) {
        gimnasioRepository.deleteGimnasio(id);
        return "redirect:/gimnasios";
    }
    
    
}
