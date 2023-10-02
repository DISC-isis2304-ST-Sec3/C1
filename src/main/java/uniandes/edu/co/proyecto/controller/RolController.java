package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.usuarios.Rol;
import uniandes.edu.co.proyecto.services.RolServicio;

import java.util.List;

@Controller("/roles")
public class RolController {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping("/{nombre}")
    public String getByID(@PathVariable("nombre") String nombre, Model model) {
        model.addAttribute("rol", rolServicio.getByID(nombre));
        return "rol";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Rol> results = rolServicio.getAll();
        model.addAllAttributes(results);
        return "all roles";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Rol rol, Model model) {
        Rol rolSaved = rolServicio.save(rol);
        return "rol saved";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Rol rol, Model model) {
        Rol rolUpdated = rolServicio.update(rol);
        return "rol updated";
    }

    @DeleteMapping()
    public String delete(@ModelAttribute Rol rol, Model model) {
        Boolean deleted = rolServicio.deleteByID(rol.getNombre());
        return "rol deleted";
    }

}
