package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.repositorio.ConsumosClienteRepository;

@Controller
public class ConsumosClienteController {
    
    @Autowired
    private ConsumosClienteRepository consumosClienteRepository;

    @GetMapping("/consumoscliente")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumosClienteRepository.darConsumos());
        return "consumos";
    }
    
    @GetMapping("/consumoscliente/{num_documento}")
    public String consumoscliente(@PathVariable("num_documento") int num_documento, Model model) {
        model.addAttribute("consumoscliente", consumosClienteRepository.darConsumoDeCliente(num_documento));
        return "consumoscliente";
    }

    @PostMapping("/consumoscliente/{num_documento}") 
    public String consumosclienteAñadir(@RequestParam(value = "idHab") int idHab,
    @ModelAttribute("tipoServ") String tipoServ, @RequestParam( value = "descripcion") String descripcion, @RequestParam(value = "costo") double costo ){ ;
        consumosClienteRepository.insertarConsumoCliente(idHab, tipoServ, costo, descripcion);
        return "redirect:/consumoscliente/{id}";
    }
       
    @GetMapping("/consumoscliente/{num_documento}/delete")
    public String consumosEliminar(@PathVariable("num_documento") int num_documento) {
        consumosClienteRepository.eliminarConsumosDeCliente(num_documento);
        return "redirect:/consumoscliente";
    }
}