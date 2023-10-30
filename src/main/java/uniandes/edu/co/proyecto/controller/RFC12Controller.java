package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC12Repository;

@Controller
public class RFC12Controller {

    @Autowired
    private RFC12Repository rfc12Repository;

    @GetMapping("/rfc12")
    public String rfc12(Model model) {
        Collection<Object[]> rta = rfc12Repository.darRta();
        model.addAttribute("rta", rta);
        
        return "rfc12";
    }

    
}