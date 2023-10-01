package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

import org.springframework.ui.Model;

@Controller
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String tipoHabitacion(Model model) {
        model.addAttribute( "tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tipoHabitacionNew(Model model) {
        model.addAttribute( "tipoHabitacion", new TipoHabitacion());
        return "tiposHabitacionNew";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tipoHabitacionNewSave(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertTipoHabitacion(tipoHabitacion.getPrecioBase(),tipoHabitacion.getCapacidad());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/edit")
    public String tipoHabitacionEdit(@PathVariable("nombre") String nombre,Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findTipoHabitacionByNombre(nombre);
        if (tipoHabitacion != null){
            model.addAttribute( "tipoHabitacion", tipoHabitacion);
            return "tiposHabitacionEdit";
        } else {
            return "redirect:/tiposHabitacion";
        }
    }

    @PostMapping("/tiposHabitacion/{id}/edit/save")
    public String tipoHabitacionEditSave(@PathVariable("nombre") String nombre, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.updateTipoHabitacion(nombre, tipoHabitacion.getPrecioBase(),tipoHabitacion.getCapacidad());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/delete")
    public String tipoHabitacionDelete(@PathVariable("nombre") String nombre) {
        tipoHabitacionRepository.deleteTipoHabitacion(nombre);
        return "redirect:/tiposHabitacion";
    }
    
}
