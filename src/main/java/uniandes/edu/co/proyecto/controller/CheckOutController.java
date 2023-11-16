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

import uniandes.edu.co.proyecto.modelo.CheckOut;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.CheckOutRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository repository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/checkOuts")
    public String checkOut(Model model) {
        model.addAttribute("checkOuts", repository.findAllCheckOuts());
        return "checkOuts";
    }

    @GetMapping("/checkOuts/new")
    public String checkOutForm(Model model) {
        model.addAttribute("habitacions", habitacionRepository.findAllHabitaciones());
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkOutsNuevo";
    }

    @PostMapping("/checkOuts/new/save")
    public String checkOutGuardar(@RequestParam(value = "idHabitacion") String idHabitacion,
            @RequestParam(value = "idReserva") String idReserva, @RequestParam(value = "fecha") String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fecha, formatter);
        ObjectId objectIdCli = new ObjectId(idHabitacion);
        ObjectId objectIdRes = new ObjectId(idReserva);
        Optional<Reserva> res = reservaRepository.findById(idReserva);
        if (res.isPresent() && fechaI.equals(res.get().getFechaSalida())) {
            repository.save(new CheckOut(objectIdRes, objectIdCli, fechaI));
            return "redirect:/checkOuts";
        }
        return "redirect:/error";
    }

    @GetMapping("/checkOuts/{id}/edit")
    public String checkOutEditarForm(@PathVariable("id") String id, Model model) {
        repository.deleteById(id);
        model.addAttribute("habitacions", habitacionRepository.findAllHabitaciones());
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkOutsNuevo";
    }

    @GetMapping("/checkOuts/{id}/delete")
    public String checkOutEliminar(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "redirect:/checkOuts";
    }

}