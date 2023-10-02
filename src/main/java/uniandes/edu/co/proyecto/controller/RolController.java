package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.usuarios.Rol;
import uniandes.edu.co.proyecto.services.RolServicio;

import java.util.List;

@Controller
public class RolController {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping("/roles/{nombre}")
    public String getByID(@PathVariable("nombre") String nombre, Model model) {
        model.addAttribute("message", rolServicio.getByID(nombre).getNombre());
        return "roles";
    }

    @GetMapping("/roles/all")
    public String getAll(Model model) {
        List<Rol> results = rolServicio.getAll();
        model.addAttribute("message", results.toString());
        return "roles";
    }

    @PostMapping("/roles/create")
    public String create(@ModelAttribute Rol rol, Model model) {
        Rol rolSaved = rolServicio.save(rol);
        model.addAttribute("message", rolSaved.getNombre());
        return "roles";
    }

    @PostMapping("/roles/update")
    public String update(@ModelAttribute Rol rol, Model model) {
        Rol rolUpdated = rolServicio.update(rol);
        model.addAttribute("message", rolUpdated.getNombre());
        return "roles";
    }

    @DeleteMapping("/roles")
    public String delete(@ModelAttribute Rol rol, Model model) {
        Boolean deleted = rolServicio.deleteByID(rol.getNombre());
        model.addAttribute("message", String.format("%s rol deleted", rol.getNombre()));
        return "roles";
    }

}
