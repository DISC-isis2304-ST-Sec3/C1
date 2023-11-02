package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC5Repository;

@Controller
public class RFC5Controller {

    @Autowired
    private RFC5Repository rfc5Repository;

    @GetMapping("/rfc5")
    public String preRfc5(Model model) {
        return "preRfc5";
    }

    @GetMapping("/rfc5/exe")
    public String preRfc5Save(Model model,  @RequestParam(value = "fechaI") String fechaI, @RequestParam(value = "fechaO") String fechaO , 
                                            @RequestParam(value = "tipoDoc") String tipoDoc, @RequestParam(value = "numDoc") int numDoc) {
        model.addAttribute("fechaI", fechaI);
        model.addAttribute("fechaO", fechaO);
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc5Repository.darConsumos(fechaFormateadaI, fechaFormateadaO, numDoc, tipoDoc);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc5";
    }
    
}
