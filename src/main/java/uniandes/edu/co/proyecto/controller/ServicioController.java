package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository tiposServicioRepository;

    @GetMapping("/tiposServicio")
    public String tiposServicio(Model model) {
        model.addAttribute("tiposServicio", tiposServicioRepository.findAllServicios());
        return "tiposServicio";
    }

    @GetMapping("/tiposServicio/new")
    public String tiposServicioForm(Model model) {
        return "tiposServicioNuevo";
    }

    @PostMapping("/tiposServicio/new/save")
    public String tiposServicioGuardar(@RequestParam(value = "tipo") String tipo,
            @RequestParam(value = "costo") int costo,
            @RequestParam(value = "descripcion") String descripcion) {
        tiposServicioRepository.save(new Servicio(tipo, costo, descripcion));
        return "redirect:/tiposServicio";
    }

    @GetMapping("/tiposServicio/{tipo}/edit")
    public String tiposServicioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        model.addAttribute("tiposServicio", new Servicio());
        tiposServicioRepository.deleteByTipo(tipo);
        return "tiposServicioNuevo";
    }

    @GetMapping("/tiposServicio/{tipo}/delete")
    public String tiposServicioEliminar(@PathVariable("tipo") String tipo) {
        tiposServicioRepository.deleteByTipo(tipo);
        return "redirect:/tiposServicio";
    }

}