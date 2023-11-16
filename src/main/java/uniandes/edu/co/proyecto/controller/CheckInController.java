package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/checkIn")
    public String checkIn(Model model) {
        model.addAttribute("checkIns", repository.findAllCheckInes());
        return "checkIn";
    }

    @GetMapping("/checkIn/new")
    public String checkInForm(Model model) {
        model.addAttribute("clientes", clienteRepository.findAllClientees());
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkInNuevo";
    }

    @PostMapping("/checkIn/new/save")
    public String checkInGuardar(@RequestParam(value = "idCliente") String idCliente,
            @RequestParam(value = "idReserva") String idReserva, @RequestParam(value = "fecha") String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fecha, formatter);
        ObjectId objectIdCli = new ObjectId(idCliente);
        ObjectId objectIdRes = new ObjectId(idReserva);
        Optional<Reserva> res = reservaRepository.findById(idReserva);
        if (res.isPresent() && fechaI.equals(res.get().getFechaEntrada())) {
            repository.save(new CheckIn(objectIdRes, objectIdCli, fechaI));
        }
        return "redirect:/checkIn";
    }

    @GetMapping("/checkIn/{id}/edit")
    public String checkInEditarForm(@PathVariable("id") String id, Model model) {
        repository.deleteById(id);
        model.addAttribute("clientes", clienteRepository.findAllClientees());
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkInNuevo";
    }

    @GetMapping("/checkIn/{id}/delete")
    public String checkInEliminar(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "redirect:/checkIn";
    }

}