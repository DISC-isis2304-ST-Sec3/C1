package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

import org.springframework.ui.Model;

@Controller
public class InternetController {
    
    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internets")
    public String internet(Model model) {
        model.addAttribute( "internets", internetRepository.findAll());
        return "internets";
    }

    @GetMapping("/internets/new")
    public String internetNew(Model model) {
        model.addAttribute( "internet", new Internet());
        return "internetsNew";
    }

    @PostMapping("/internets/new/save")
    public String internetNewSave(@ModelAttribute Internet internet) {
        internetRepository.insertInternet(internet.getCapacidad(), internet.getValorPorDia(), internet.getInicia(), internet.getFinaliza());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id}/edit")
    public String internetEdit(@PathVariable("id") int id,Model model) {
        Internet internet = internetRepository.findInternetById(id);
        if (internet != null){
            model.addAttribute( "internet", internet);
            return "internetsEdit";
        } else {
            return "redirect:/internets";
        }
    }

    @PostMapping("/internets/{id}/edit/save")
    public String internetEditSave(@PathVariable("id") int id, @ModelAttribute Internet internet) {
        internetRepository.updateInternet(id, internet.getCapacidad(), internet.getValorPorDia(), internet.getInicia(), internet.getFinaliza());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id}/delete")
    public String internetDelete(@PathVariable("id") int id) {
        internetRepository.deleteInternet(id);
        return "redirect:/internets";
    }
    

}
