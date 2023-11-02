package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC3Repository;

@Controller
public class RFC3Controller {

    @Autowired
    private RFC3Repository rfc3Repository;

    @GetMapping("/rfc3")
    public String rfc3(Model model) {
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc3Repository.darRta();
        model.addAttribute("rta", rta);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        
        return "rfc3";
    }

    
}
