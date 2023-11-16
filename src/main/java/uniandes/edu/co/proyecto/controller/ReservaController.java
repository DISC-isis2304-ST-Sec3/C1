package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HabitacionRepository habRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservasRepository.findAllReservaes());
        return "reservas";
    }

    @GetMapping("/reservas/new")
    public String reservasForm(Model model) {
        model.addAttribute("habitaciones", habRepository.findAllHabitaciones());
        return "reservasNuevo";
    }

    @PostMapping("/reservas/new/save")
    public String reservasGuardar(@ModelAttribute("fechaInicio") String fechaInicio,
            @ModelAttribute("fechaSalida") String fechaSalida,
            @RequestParam(value = "numPersonas", required = true) int numPersonas,
            @RequestParam(value = "hab", required = true) String numHabitacion,
            @RequestParam(value = "tipoDoc", required = true) String tipoDoc,
            @RequestParam(value = "numDoc", required = true) int numDoc,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "correo", required = true) String correo) {

        Cliente cliente = clienteRepository.findByNumero(tipoDoc, numDoc);

        if (cliente == null) {
            cliente = new Cliente(tipoDoc, numDoc, nombre, correo);
            clienteRepository.save(cliente);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaF = LocalDate.parse(fechaSalida, formatter);
        ObjectId objectId = new ObjectId(numHabitacion);
        reservasRepository.save(new Reserva(fechaI, fechaF, numPersonas, objectId, cliente));
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservasEliminar(@PathVariable("id") String id) {

        reservasRepository.deleteById(id);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservasEditar(@PathVariable("id") String id, Model model) {
        reservasRepository.deleteById(id);
        model.addAttribute("habitaciones", habRepository.findAllHabitaciones());
        return "reservasNuevo";
    }

}