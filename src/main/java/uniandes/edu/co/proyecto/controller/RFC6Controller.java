package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC6Repository;

@Controller
public class RFC6Controller {

    @Autowired
    private RFC6Repository rfc6Repository;

    @GetMapping("/rfc6")
    public String rfc6Ingreso(Model model) {
        Object[] rta = rfc6Repository.darIngreso();
        model.addAttribute("ingreso", rta);
        Object[] rta1 = rfc6Repository.darMayorOcupacion();
        model.addAttribute("mayor", rta1);
        Object[] rta2 = rfc6Repository.darMenorOcupacion();
        model.addAttribute("menor", rta2);
        return "rfc6";
    }
    
}