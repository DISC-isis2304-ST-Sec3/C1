package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC8Repository;

@Controller
public class RFC8Controller {

    @Autowired
    private RFC8Repository rfc8Repository;

    @GetMapping("/rfc8")
    public String rfc8(Model model) {
        long tiempoFin = System.nanoTime();
        Object[] rta = rfc8Repository.darRta();
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc8";
    }

    
}