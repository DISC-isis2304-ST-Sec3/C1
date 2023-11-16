package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository repository;

    @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", repository.findAllTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tiposHabitacionForm(Model model) {
        return "tiposhabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tiposHabitacionGuardar(@ModelAttribute("tipo") String tipo,
            @RequestParam(value = "jacuzzi", required = false) Integer jacuzzi,
            @RequestParam(value = "cocina", required = false) Integer cocina,
            @RequestParam(value = "comedor", required = false) Integer comedor) {

        jacuzzi = (jacuzzi != null) ? jacuzzi : 0;
        cocina = (cocina != null) ? cocina : 0;
        comedor = (comedor != null) ? comedor : 0;

        repository.save(new TipoHabitacion(tipo, jacuzzi, comedor, cocina));
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipo}/delete")
    public String eliminarTipoHabitacion(@PathVariable String tipo) {
        repository.deleteByTipo(tipo);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipo}/edit")
    public String tiposHabitacionEditarForm(@PathVariable("tipo") String tipo, Model model) {
        repository.deleteByTipo(tipo);
        return "tiposhabitacionNuevo";
    }

}
