package uniandes.edu.co.proyecto.controller;


import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Habitaciones;
import uniandes.edu.co.proyecto.modelo.Reservan;
import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.repositorio.RFC1Repository;

@Controller
public class RFC1Controller {

    @Autowired
    private RFC1Repository rfc1Repository;

    @GetMapping("/rfc1")
    public String rfc1(Model model) {
        Collection<Object[]> rta = rfc1Repository.darConsumos();
        model.addAttribute("Costo", rta);
        
        return "rfc1";
    }

    
}
