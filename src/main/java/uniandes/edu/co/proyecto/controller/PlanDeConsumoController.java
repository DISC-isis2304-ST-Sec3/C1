package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.PlanDeConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanDeConsumoRepository;

import org.springframework.ui.Model;

@Controller
public class PlanDeConsumoController {

    @Autowired
    private PlanDeConsumoRepository planDeConsumoRepository;

    @GetMapping("/planesDeConsumo")
    public String planDeConsumo(Model model) {
        model.addAttribute( "planesDeConsumo", planDeConsumoRepository.findAll());
        return "planesDeConsumo";
    }

    @GetMapping("/planesDeConsumo/new")
    public String planDeConsumoNew(Model model) {
        model.addAttribute( "planDeConsumo", new PlanDeConsumo());
        return "planesDeConsumoNew";
    }

    @PostMapping("/planesDeConsumo/new/save")
    public String planDeConsumoNewSave(@ModelAttribute PlanDeConsumo planDeConsumo) {
        planDeConsumoRepository.insertPlanDeConsumo(planDeConsumo.getDescuento(), planDeConsumo.getMinimasNoches(), planDeConsumo.getValor());
        return "redirect:/planesDeConsumo";
    }

    @GetMapping("/planesDeConsumo/{id}/edit")
    public String planDeConsumoEdit(@PathVariable("id") String id,Model model) {
        PlanDeConsumo planDeConsumo = planDeConsumoRepository.findPlanDeConsumoById(id);
        if (planDeConsumo != null){
            model.addAttribute( "planDeConsumo", planDeConsumo);
            return "planesDeConsumoEdit";
        } else {
            return "redirect:/planesDeConsumo";
        }
    }

    @PostMapping("/planesDeConsumo/{id}/edit/save")
    public String planDeConsumoEditSave(@PathVariable("id") String id, @ModelAttribute PlanDeConsumo planDeConsumo) {
        planDeConsumoRepository.updatePlanDeConsumo(id, planDeConsumo.getDescuento(), planDeConsumo.getMinimasNoches(), planDeConsumo.getValor());
        return "redirect:/planesDeConsumo";
    }

    @GetMapping("/planesDeConsumo/{id}/delete")
    public String planDeConsumoDelete(@PathVariable("id") String id) {
        planDeConsumoRepository.deletePlanDeConsumo(id);
        return "redirect:/planesDeConsumo";
    }
    
}
