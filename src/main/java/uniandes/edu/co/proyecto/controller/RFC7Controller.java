package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC7Repository;

@Controller
public class RFC7Controller {

    @Autowired
    private RFC7Repository rfc7Repository;

    @GetMapping("/rfc7")
    public String rfc7(Model model) {
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc7Repository.darRta();
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        
        return "rfc7";
    }

    
}
