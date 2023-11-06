package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC10Repository;

@Controller
public class RFC10Controller {

    public static LocalDate fechaInicial;
    public static LocalDate fechaFinal;
    public static String tipo;

    @Autowired
    private RFC10Repository rfc10Repository;

    @GetMapping("/rfc10")
    public String preRfc10(Model model) {
        return "preRfc10";
    }

    @GetMapping("/rfc10/exe")
    public String preRfc10Save(Model model, @RequestParam(value = "fechaI") String fechaI,
            @RequestParam(value = "fechaO") String fechaO,
            @RequestParam(value = "tipo") String tipo) {
        model.addAttribute("fechaI", fechaI);
        model.addAttribute("fechaO", fechaO);
        model.addAttribute("tipo", tipo);
        RFC10Controller.fechaInicial = LocalDate.parse(fechaI);
        RFC10Controller.fechaFinal = LocalDate.parse(fechaO);
        RFC10Controller.tipo = tipo;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = RFC10Controller.fechaInicial.format(formato);
        String fechaFormateadaO = RFC10Controller.fechaFinal.format(formato);
        long tiempoFin = System.nanoTime();
        Collection<Object[]> rta = rfc10Repository.darRtaBase(fechaFormateadaI, fechaFormateadaO, tipo);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc10";
    }

    @GetMapping("/rfc10/exe/grouped")
    public String preRfc10Group(Model model, @RequestParam(value = "filtro") String filtro) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = RFC10Controller.fechaInicial.format(formato);
        String fechaFormateadaO = RFC10Controller.fechaFinal.format(formato);
        Collection<Object[]> rta;
        long tiempoFin = System.nanoTime();
        if (filtro.equals("nombre")) {
            rta = rfc10Repository.darRtaAgrupadaNombre(fechaFormateadaI, fechaFormateadaO, tipo);
        } else if (filtro.equals("tipoDoc")) {
            rta = rfc10Repository.darRtaAgrupadaTipoDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        } else {
            rta = rfc10Repository.darRtaAgrupadaCorreo(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc10Group";
    }

    @GetMapping("/rfc10/exe/ordered")
    public String preRfc10Ordered(Model model, @RequestParam(value = "filtro") String filtro) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = RFC10Controller.fechaInicial.format(formato);
        String fechaFormateadaO = RFC10Controller.fechaFinal.format(formato);
        Collection<Object[]> rta;
        long tiempoFin = System.nanoTime();
        if (filtro.equals("nombre")) {
            rta = rfc10Repository.darRtaOrdenadaNombre(fechaFormateadaI, fechaFormateadaO, tipo);
        } else if (filtro.equals("numDoc")) {
            rta = rfc10Repository.darRtaOrdenadaNumDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        } else if (filtro.equals("tipoDoc")) {
            rta = rfc10Repository.darRtaOrdenadaTipoDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        } else {
            rta = rfc10Repository.darRtaOrdenadaCorreo(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc10Order";
    }

    @GetMapping("/rfc10/exe/orderedgrouped")
    public String preRfc10OrderedGrouped(Model model, @RequestParam(value = "filtro") String filtro) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = RFC10Controller.fechaInicial.format(formato);
        String fechaFormateadaO = RFC10Controller.fechaFinal.format(formato);
        Collection<Object[]> rta;
        long tiempoFin = System.nanoTime();
        if (filtro.equals("nombre")) {
            rta = rfc10Repository.darRtaAgrupadaYOrdenadaNombre(fechaFormateadaI, fechaFormateadaO, tipo);
        } else if (filtro.equals("tipoDoc")) {
            rta = rfc10Repository.darRtaAgrupadaYOrdenadaTipoDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        } else if (filtro.equals("correo")) {
            rta = rfc10Repository.darRtaAgrupadaYOrdenadaCorreo(fechaFormateadaI, fechaFormateadaO, tipo);
        } else {
            rta = rfc10Repository.darRtaOrdenadaNumDoc(fechaFormateadaI, fechaFormateadaO, tipo);
        }
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin) / 1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        return "rfc10Group";
    }

}
