package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC9Repository;

@Controller
public class RFC9Controller {

    public static LocalDate fechaInicial;
    public static LocalDate fechaFinal;
    public static String tipo;

    @Autowired
    private RFC9Repository rfc9Repository;

    @GetMapping("/rfc9")
    public String preRfc9(Model model) {
        return "preRfc9";
    }

    @GetMapping("/rfc9/exe")
    public String preRfc9Save(Model model, @RequestParam(value = "fechaI") String fechaI, @RequestParam(value = "fechaO") String fechaO,
    @RequestParam(value = "tipo") String tipo) {
        model.addAttribute("fechaI", fechaI);
        model.addAttribute("fechaO", fechaO);
        model.addAttribute("tipo", tipo);
        RFC9Controller.fechaInicial = LocalDate.parse(fechaI);
        RFC9Controller.fechaFinal = LocalDate.parse(fechaO);
        RFC9Controller.tipo = tipo;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc9Repository.darRtaBase(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9";
    }

    @GetMapping("/rfc9/exe/grouped")
    public String preRfc9Group(Model model) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc9Repository.darRtaAgrupada(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9Group";
    }

    @GetMapping("/rfc9/exe/ordered")
    public String preRfc9Ordered(Model model, @RequestParam(value = "filtro") String filtro) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        Collection<Object[]> rta;
        long tiempoFin = System.nanoTime();
        if (filtro.equals("nombre")) {
            rta = rfc9Repository.darRtaOrdenadaNobre(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        else if (filtro.equals("numDoc")) {
            rta = rfc9Repository.darRtaOrdenadaNumDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        else {
            rta = rfc9Repository.darRtaOrdenadaFecha(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        model.addAttribute("rta", rta);
        return "rfc9Order";
    }

    @GetMapping("/rfc9/exe/orderedgrouped")
    public String preRfc9OrderedGrouped(Model model, @RequestParam(value = "filtro") String filtro) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        Collection<Object[]> rta;
        long tiempoFin = System.nanoTime();
        if (filtro.equals("nombre")) {
            rta = rfc9Repository.darRtaAgrupadaYOrdenadaNombre(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        else if (filtro.equals("numDoc")) {
            rta = rfc9Repository.darRtaAgrupadaYOrdenadanumDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        else {
            rta = rfc9Repository.darRtaAgrupadaYOrdenadaServicio(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc9Group";
    }

    
}
