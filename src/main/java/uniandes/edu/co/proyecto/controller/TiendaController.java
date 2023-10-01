package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Tienda;
import uniandes.edu.co.proyecto.repositorio.TiendaRepository;

import org.springframework.ui.Model;

@Controller
public class TiendaController {
    
    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tienda(Model model) {
        model.addAttribute( "tiendas", tiendaRepository.findAll());
        return "tiendas";
    }

    @GetMapping("/tiendas/new")
    public String tiendaNew(Model model) {
        model.addAttribute( "tienda", new Tienda());
        return "tiendasNew";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaNewSave(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertTienda(tienda.getTipo());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String tiendaEdit(@PathVariable("id") int id,Model model) {
        Tienda tienda = tiendaRepository.findTiendaById(id);
        if (tienda != null){
            model.addAttribute( "tienda", tienda);
            return "tiendasEdit";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String tiendaEditSave(@PathVariable("id") int id, @ModelAttribute Tienda tienda) {
        tiendaRepository.updateTienda(id, tienda.getTipo());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String tiendaDelete(@PathVariable("id") int id) {
        tiendaRepository.deleteTienda(id);
        return "redirect:/tiendas";
    }

}
