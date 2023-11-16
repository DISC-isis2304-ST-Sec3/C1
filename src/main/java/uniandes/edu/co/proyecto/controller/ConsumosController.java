package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.ConsumosRepository;

@Controller
public class ConsumosController {

    @Autowired
    private ConsumosRepository consumosRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private HabitacionRepository habRepository;

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumosRepository.findAllConsumoes());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumosForm(Model model) {
        model.addAttribute("servicios", servicioRepository.findAllServicios());
        return "consumosNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumosGuardar(
            @RequestParam(value = "fecha", required = true) String fecha,
            @RequestParam(value = "idServicio", required = true) String idServicio) {

        Optional<Servicio> ser = servicioRepository.findById(idServicio);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fecha, formatter);
        if (ser.isPresent()) {
            consumosRepository.save(new Consumo(ser.get(), fechaI));
        }
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumosEliminar(@PathVariable("id") String id) {

        consumosRepository.deleteById(id);
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String consumosEditar(@PathVariable("id") String id, Model model) {
        consumosRepository.deleteById(id);
        model.addAttribute("servicios", servicioRepository.findAllServicios());
        model.addAttribute("Cid", id);
        return "consumosNuevo";
    }

    @GetMapping("/consumos/{Cid}/associate")
    public String associateForm(Model model) {
        model.addAttribute("habitaciones", habRepository.findAllHabitaciones());
        return "consumosAsociar";
    }

    @GetMapping("/consumos/{Cid}/associate/save")
    public String asociar(@PathVariable("Cid") String id, Model model,
            @RequestParam(value = "idHab", required = true) String idHab) {
        Optional<Habitacion> hab = habRepository.findById(idHab);
        Optional<Consumo> con = consumosRepository.findById(id);
        if (hab.isPresent() && con.isPresent()) {
            hab.get().getConsumos().add(con.get());
        }
        return "redirect:/consumos";
    }

}