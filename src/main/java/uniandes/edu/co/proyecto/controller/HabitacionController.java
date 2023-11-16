package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository repository;

    @Autowired
    private TipoHabitacionRepository tiposHabitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", repository.findAllHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionesForm(Model model) {
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.findAllTiposHabitacion());
        return "habitacionesNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionesGuardar(@RequestParam(value = "id") int id,
            @ModelAttribute("capacidad") int capacidad, @ModelAttribute("costo") int costo,
            @ModelAttribute("tipoHabitacion") String tipoHabitacion) {
        TipoHabitacion tipo = tiposHabitacionRepository.findByTipo(tipoHabitacion);
        repository.save(new Habitacion(id, capacidad, costo, tipo));
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionesEditarForm(@PathVariable("id") int id, Model model) {
        repository.deleteByNumero(id);
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.findAllTiposHabitacion());
        return "habitacionesNuevo";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionesEliminar(@PathVariable("id") int id) {
        repository.deleteByNumero(id);
        return "redirect:/habitaciones";
    }

}
