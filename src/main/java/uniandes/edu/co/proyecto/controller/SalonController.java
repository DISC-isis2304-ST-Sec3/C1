package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.repositorio.SalonRepository;

import org.springframework.ui.Model;

@Controller
public class SalonController {
    
    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salon(Model model) {
        model.addAttribute( "salones", salonRepository.findAll());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String salonNew(Model model) {
        model.addAttribute( "salon", new Salon());
        return "salonesNew";
    }

    // @PostMapping("/salones/new/save")
    // public String salonNewSave(@ModelAttribute Salon salon) {
    //     salonRepository.insertSalon(salon.getCapacidad(), salon.getCostoHora(), salon.getTiempoLimpieza());
    //     return "redirect:/salones";
    // }

    @GetMapping("/salones/{id}/edit")
    public String salonEdit(@PathVariable("id") int id,Model model) {
        Salon salon = salonRepository.findSalonById(id);
        if (salon != null){
            model.addAttribute( "salon", salon);
            return "salonesEdit";
        } else {
            return "redirect:/salones";
        }
    }

    // @PostMapping("/salones/{id}/edit/save")
    // public String salonEditSave(@PathVariable("id") int id, @ModelAttribute Salon salon) {
    //     salonRepository.updateSalon(id, salon.getCapacidad(), salon.getCostoHora(), salon.getTiempoLimpieza());
    //     return "redirect:/salones";
    // }

    @GetMapping("/salones/{id}/delete")
    public String salonDelete(@PathVariable("id") int id) {
        salonRepository.deleteSalon(id);
        return "redirect:/salones";
    }

}
