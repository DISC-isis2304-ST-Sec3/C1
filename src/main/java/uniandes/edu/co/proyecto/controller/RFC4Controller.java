package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC4Repository;

@Controller
public class RFC4Controller {

    @Autowired
    private RFC4Repository rfc4Repository;

    @GetMapping("/rfc4")
    public String preRfc4(Model model) {
        return "preRfc4";
    }

    @GetMapping("/rfc4/filtrarPrecio")
    public String preRfc4Precio(Model model, @RequestParam(value = "precioI") int precioI, @RequestParam(value = "precioO") int precioO) {
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc4Repository.darRtaCosto(precioI,precioO);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc4";
    }

    @GetMapping("/rfc4/filtrarFecha")
    public String preRfc4fecha(Model model, @RequestParam(value = "fechaI") String fechaI, @RequestParam(value = "fechaO") String fechaO) {
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc4Repository.darRtaFecha(fechaFormateadaI, fechaFormateadaO);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc4";
    }

    @GetMapping("/rfc4/filtrarTipo")
    public String preRfc4Tipo(Model model, @RequestParam(value = "tipo") String tipo) {
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc4Repository.darRtaTipo(tipo);
        model.addAttribute("rta", rta);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        return "rfc4";
    }
    
}