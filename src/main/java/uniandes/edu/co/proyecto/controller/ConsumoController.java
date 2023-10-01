package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

import org.springframework.ui.Model;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumos")
    public String consumo(Model model) {
        model.addAttribute( "consumos", consumoRepository.findAll());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumoNew(Model model) {
        model.addAttribute( "consumo", new Consumo());
        return "consumosNew";
    }

    @PostMapping("/consumos/new/save")
    public String consumoNewSave(@ModelAttribute Consumo consumo) {
        consumoRepository.insertConsumo(consumo.getValorTotal(), consumo.getFecha());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String consumoEdit(@PathVariable("id") int id,Model model) {
        Consumo consumo = consumoRepository.findConsumoById(id);
        if (consumo != null){
            model.addAttribute( "consumo", consumo);
            return "consumosEdit";
        } else {
            return "redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditSave(@PathVariable("id") int id, @ModelAttribute Consumo consumo) {
        consumoRepository.updateConsumo(id, consumo.getValorTotal(), consumo.getFecha());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoDelete(@PathVariable("id") int id) {
        consumoRepository.deleteConsumo(id);
        return "redirect:/consumos";
    }
    

}
