package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class RFC3Controller {

    @Autowired
    private HabitacionRepository habitacionesRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/rfc3")
    public String preConsulta(Model model) {
        model.addAttribute("clientes", clienteRepository.findAllClientees());
        return "preRfc3";
    }

    @PostMapping("/rfc3/exe")
    public String consulta(Model model, @RequestParam(value = "cliente", required = true) String cliente,
            @RequestParam(value = "fechaI", required = true) String fechaI,
            @RequestParam(value = "fechaO", required = true) String fechaO) {
        Cliente c = clienteRepository.findByNombre(cliente);
        Reserva res = encontrarReservaPorNombre(c);
        Optional<Habitacion> hab = habitacionesRepository.findById(res.getHabitacion().toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha1 = LocalDate.parse(fechaI, formatter);
        LocalDate fecha2 = LocalDate.parse(fechaO, formatter);

        List<Consumo> lista = new ArrayList<>();
        if (hab.isPresent()) {
            for (Consumo consumo : hab.get().getConsumos()) {
                if (consumo.getFecha().isAfter(fecha1) && consumo.getFecha().isBefore(fecha2)) {
                    lista.add(consumo);
                }
            }
        }

        model.addAttribute("consumos", lista);
        return "rfc3";
    }

    private Reserva encontrarReservaPorNombre(Cliente cliente) {
        List<Reserva> reservas = reservaRepository.findAllReservaes();
        for (Reserva reserva : reservas) {
            if (reserva.getResponsable().getNombre().equals(cliente.getNombre())) {
                return reserva;
            }
        }
        return null;
    }

}