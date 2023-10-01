package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Vigencia;
import uniandes.edu.co.proyecto.repositorio.VigenciaRepository;

import org.springframework.ui.Model;

@Controller
public class VigenciaController {
    
    @Autowired
    private VigenciaRepository vigenciaRepository;

    @GetMapping("/vigencias")
    public String vigencia(Model model) {
        model.addAttribute( "vigencias", vigenciaRepository.findAll());
        return "vigencias";
    }

    @GetMapping("/vigencias/new")
    public String vigenciaNew(Model model) {
        model.addAttribute( "vigencia", new Vigencia());
        return "vigenciasNew";
    }

    @PostMapping("/vigencias/new/save")
    public String vigenciaNewSave(@ModelAttribute Vigencia vigencia) {
        vigenciaRepository.insertVigencia(vigencia.getFechaInicio(), vigencia.getFechaFin());
        return "redirect:/vigencias";
    }

    @GetMapping("/vigencias/{id}/edit")
    public String vigenciaEdit(@PathVariable("id") int id,Model model) {
        Vigencia vigencia = vigenciaRepository.findVigenciaById(id);
        if (vigencia != null){
            model.addAttribute( "vigencia", vigencia);
            return "vigenciasEdit";
        } else {
            return "redirect:/vigencias";
        }
    }

    @PostMapping("/vigencias/{id}/edit/save")
    public String vigenciaEditSave(@PathVariable("id") int id, @ModelAttribute Vigencia vigencia) {
        vigenciaRepository.updateVigencia(id, vigencia.getFechaInicio(), vigencia.getFechaFin());
        return "redirect:/vigencias";
    }

    @GetMapping("/vigencias/{id}/delete")
    public String vigenciaDelete(@PathVariable("id") int id) {
        vigenciaRepository.deleteVigencia(id);
        return "redirect:/vigencias";
    }

}
