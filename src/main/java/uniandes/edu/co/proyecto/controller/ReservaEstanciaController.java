package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.ReservaEstancia;
import uniandes.edu.co.proyecto.repositorio.ReservaEstanciaRepository;

import org.springframework.ui.Model;

@Controller
public class ReservaEstanciaController {
    
    @Autowired
    private ReservaEstanciaRepository reservaEstanciaRepository;

    @GetMapping("/reservaEstancias")
    public String reservaEstancia(Model model) {
        model.addAttribute( "reservaEstancias", reservaEstanciaRepository.findAll());
        return "reservaEstancias";
    }

    @GetMapping("/reservaEstancias/new")
    public String reservaEstanciaNew(Model model) {
        model.addAttribute( "reservaEstancia", new ReservaEstancia());
        return "reservaEstanciasNew";
    }

    @PostMapping("/reservaEstancias/new/save")
    public String reservaEstanciaNewSave(@ModelAttribute ReservaEstancia reservaEstancia) {
        reservaEstanciaRepository.insertReservaEstancia(reservaEstancia.getFechaInicio(), reservaEstancia.getFechaFin(), 
                                        reservaEstancia.getCantidadHuespes());
        return "redirect:/reservaEstancias";
    }

    @GetMapping("/reservaEstancias/{id}/edit")
    public String reservaEstanciaEdit(@PathVariable("id") int id,Model model) {
        ReservaEstancia reservaEstancia = reservaEstanciaRepository.findReservaEstanciaById(id);
        if (reservaEstancia != null){
            model.addAttribute( "reservaEstancia", reservaEstancia);
            return "reservaEstanciasEdit";
        } else {
            return "redirect:/reservaEstancias";
        }
    }

    @PostMapping("/reservaEstancias/{id}/edit/save")
    public String reservaEstanciaEditSave(@PathVariable("id") int id, @ModelAttribute ReservaEstancia reservaEstancia) {
        reservaEstanciaRepository.updateReservaEstancia(id, reservaEstancia.getFechaInicio(), reservaEstancia.getFechaFin(), 
                                        reservaEstancia.getCantidadHuespes());
        return "redirect:/reservaEstancias";
    }

    @GetMapping("/reservaEstancias/{id}/delete")
    public String reservaEstanciaDelete(@PathVariable("id") int id) {
        reservaEstanciaRepository.deleteReservaEstancia(id);
        return "redirect:/reservaEstancias";
    }

}
