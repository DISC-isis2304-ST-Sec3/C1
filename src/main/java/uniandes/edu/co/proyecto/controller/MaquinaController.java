package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Maquina;
import uniandes.edu.co.proyecto.repositorio.MaquinaRepository;

import org.springframework.ui.Model;

@Controller
public class MaquinaController {

    @Autowired
    private MaquinaRepository maquinaRepository;

    @GetMapping("/maquinas")
    public String maquina(Model model) {
        model.addAttribute( "maquinas", maquinaRepository.findAll());
        return "maquinas";
    }

    @GetMapping("/maquinas/new")
    public String maquinaNew(Model model) {
        model.addAttribute( "maquina", new Maquina());
        return "maquinasNew";
    }

    @PostMapping("/maquinas/new/save")
    public String maquinaNewSave(@ModelAttribute Maquina maquina) {
        maquinaRepository.insertMaquina(maquina.getNombre());
        return "redirect:/maquinas";
    }

    @GetMapping("/maquinas/{id}/edit")
    public String maquinaEdit(@PathVariable("id") int id,Model model) {
        Maquina maquina = maquinaRepository.findMaquinaById(id);
        if (maquina != null){
            model.addAttribute( "maquina", maquina);
            return "maquinasEdit";
        } else {
            return "redirect:/maquinas";
        }
    }

    @PostMapping("/maquinas/{id}/edit/save")
    public String maquinaEditSave(@PathVariable("id") int id, @ModelAttribute Maquina maquina) {
        maquinaRepository.updateMaquina(id, maquina.getNombre());
        return "redirect:/maquinas";
    }

    @GetMapping("/maquinas/{id}/delete")
    public String maquinaDelete(@PathVariable("id") int id) {
        maquinaRepository.deleteMaquina(id);
        return "redirect:/maquinas";
    }
    
}
