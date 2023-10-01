package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import org.springframework.ui.Model;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicio(Model model) {
        model.addAttribute( "servicios", servicioRepository.findAll());
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioNew(Model model) {
        model.addAttribute( "servicio", new Servicio());
        return "serviciosNew";
    }

    @PostMapping("/servicios/new/save")
    public String servicioNewSave(@ModelAttribute Servicio servicio) {
        servicioRepository.insertServicio(servicio.getNombre());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEdit(@PathVariable("id") int id,Model model) {
        Servicio servicio = servicioRepository.findServicioById(id);
        if (servicio != null){
            model.addAttribute( "servicio", servicio);
            return "serviciosEdit";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditSave(@PathVariable("id") int id, @ModelAttribute Servicio servicio) {
        servicioRepository.updateServicio(id, servicio.getNombre());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioDelete(@PathVariable("id") int id) {
        servicioRepository.deleteServicio(id);
        return "redirect:/servicios";
    }
    
    
}
