package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;

import org.springframework.ui.Model;

@Controller
public class RestauranteController {
    
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes")
    public String restaurante(Model model) {
        model.addAttribute( "restaurantes", restauranteRepository.findAll());
        return "restaurantes";
    }

    @GetMapping("/restaurantes/new")
    public String restauranteNew(Model model) {
        model.addAttribute( "restaurante", new Restaurante());
        return "restaurantesNew";
    }

    @PostMapping("/restaurantes/new/save")
    public String restauranteNewSave(@ModelAttribute Restaurante restaurante) {
        restauranteRepository.insertRestaurante( restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/restaurantes";
    }

    @GetMapping("/restaurantes/{id}/edit")
    public String restauranteEdit(@PathVariable("id") int id,Model model) {
        Restaurante restaurante = restauranteRepository.findRestauranteById(id);
        if (restaurante != null){
            model.addAttribute( "restaurante", restaurante);
            return "restaurantesEdit";
        } else {
            return "redirect:/restaurantes";
        }
    }

    @PostMapping("/restaurantes/{id}/edit/save")
    public String restauranteEditSave(@PathVariable("id") int id, @ModelAttribute Restaurante restaurante) {
        restauranteRepository.updateRestaurante(id, restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/restaurantes";
    }

    @GetMapping("/restaurantes/{id}/delete")
    public String restauranteDelete(@PathVariable("id") int id) {
        restauranteRepository.deleteRestaurante(id);
        return "redirect:/restaurantes";
    }


}
