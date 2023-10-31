package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.repositorio.RFC9Repository;

@Controller
public class RFC9Controller {

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
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        System.out.println(fechaFormateadaI);
        Collection<Object[]> rta = rfc9Repository.darRtaBase(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9";
    }

    @GetMapping("/rfc9/exe/grouped")
    public String preRfc9Group(Model model, @ModelAttribute("fechaI") String fechaI, @ModelAttribute("fechaO") String fechaO,
    @ModelAttribute("tipo") String tipo) {
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        Collection<Object[]> rta = rfc9Repository.darRtaAgrupada(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9Group";
    }

    @GetMapping("/rfc9/exe/ordered")
    public String preRfc9Ordered(Model model, @ModelAttribute("fechaI") String fechaI, @ModelAttribute("fechaO") String fechaO,
    @ModelAttribute("tipo") String tipo) {
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        Collection<Object[]> rta = rfc9Repository.darRtaOrdenada(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9Order";
    }

    @GetMapping("/rfc9/exe/orderedgrouped")
    public String preRfc9OrderedGrouped(Model model, @ModelAttribute("fechaI") String fechaI, @ModelAttribute("fechaO") String fechaO,
    @ModelAttribute("tipo") String tipo) {
        LocalDate fechaInicial = LocalDate.parse(fechaI);
        LocalDate fechaFinal = LocalDate.parse(fechaO);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fechaFormateadaI = fechaInicial.format(formato);
        String fechaFormateadaO = fechaFinal.format(formato);
        Collection<Object[]> rta = rfc9Repository.darRtaAgrupadaYOrdenada(fechaFormateadaI, fechaFormateadaO, tipo);
        model.addAttribute("rta", rta);
        return "rfc9Group";
    }

    
}
