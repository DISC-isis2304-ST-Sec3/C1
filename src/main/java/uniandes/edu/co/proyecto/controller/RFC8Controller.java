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
        Object[] rta = rfc8Repository.darRta();
        model.addAttribute("rta", rta);
        return "rfc8";
    }

    
}