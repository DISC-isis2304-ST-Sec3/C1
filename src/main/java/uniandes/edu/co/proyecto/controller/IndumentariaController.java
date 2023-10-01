package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Indumentaria;
import uniandes.edu.co.proyecto.repositorio.IndumentariaRepository;

import org.springframework.ui.Model;

@Controller
public class IndumentariaController {
    
    @Autowired
    private IndumentariaRepository indumentariaRepository;

    @GetMapping("/indumentarias")
    public String indumentaria(Model model) {
        model.addAttribute( "indumentarias", indumentariaRepository.findAll());
        return "indumentarias";
    }

    @GetMapping("/indumentarias/new")
    public String indumentariaNew(Model model) {
        model.addAttribute( "indumentaria", new Indumentaria());
        return "indumentariasNew";
    }

    @PostMapping("/indumentarias/new/save")
    public String indumentariaNewSave(@ModelAttribute Indumentaria indumentaria) {
        indumentariaRepository.insertIndumentaria(indumentaria.getElementos(), indumentaria.getValorBase(), indumentaria.getValorElemento());
        return "redirect:/indumentarias";
    }

    @GetMapping("/indumentarias/{id}/edit")
    public String indumentariaEdit(@PathVariable("id") int id,Model model) {
        Indumentaria indumentaria = indumentariaRepository.findIndumentariaById(id);
        if (indumentaria != null){
            model.addAttribute( "indumentaria", indumentaria);
            return "indumentariasEdit";
        } else {
            return "redirect:/indumentarias";
        }
    }

    @PostMapping("/indumentarias/{id}/edit/save")
    public String indumentariaEditSave(@PathVariable("id") int id, @ModelAttribute Indumentaria indumentaria) {
        indumentariaRepository.updateIndumentaria(id, indumentaria.getElementos(), indumentaria.getValorBase(), indumentaria.getValorElemento());
        return "redirect:/indumentarias";
    }

    @GetMapping("/indumentarias/{id}/delete")
    public String indumentariaDelete(@PathVariable("id") int id) {
        indumentariaRepository.deleteIndumentaria(id);
        return "redirect:/indumentarias";
    }

}
