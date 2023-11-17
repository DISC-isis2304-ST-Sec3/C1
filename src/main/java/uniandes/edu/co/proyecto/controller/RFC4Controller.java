package uniandes.edu.co.proyecto.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.modelo.CheckOut;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class RFC4Controller {

    @Autowired
    private CheckInRepository inRepository;

    @Autowired
    private CheckOutRepository outRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/rfc4")
    public String consulta(Model model) {

        List<Reserva> reservas = reservaRepository.findAllReservaes();
        HashMap<Integer, List<String>> trimestres = new HashMap<>();
        trimestres.put(1, new ArrayList<>());
        trimestres.put(2, new ArrayList<>());
        trimestres.put(3, new ArrayList<>());
        HashMap<Integer, List<String>> trimestresCheck = new HashMap<>();
        trimestresCheck.put(1, new ArrayList<>());
        trimestresCheck.put(2, new ArrayList<>());
        trimestresCheck.put(3, new ArrayList<>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha1 = LocalDate.parse("2023-04-30", formatter);
        LocalDate fecha2 = LocalDate.parse("2023-08-31", formatter);
        LocalDate fecha3 = LocalDate.parse("2023-12-31", formatter);

        for (Reserva reserva : reservas) {
            if (reserva.getFechaSalida().getYear() == 2023) {

                if (reserva.getFechaEntrada().isBefore(fecha1) && reserva.getFechaSalida().isBefore(fecha2)) {
                    trimestres.get(1).add(reserva.getResponsable().getNombre());
                } else if (reserva.getFechaEntrada().isBefore(fecha2) && reserva.getFechaSalida().isBefore(fecha3)) {
                    trimestres.get(2).add(reserva.getResponsable().getNombre());
                } else if (reserva.getFechaEntrada().isBefore(fecha3) && reserva.getFechaSalida().isBefore(fecha3)) {
                    trimestres.get(3).add(reserva.getResponsable().getNombre());
                }

            }
        }

        List<Cliente> clientes = clienteRepository.findAllClientees();
        HashSet<Cliente> candidatos = new HashSet<Cliente>();
        HashSet<Cliente> listaRta = new HashSet<Cliente>();

        for (Cliente cliente : clientes) {
            if (trimestres.get(1).contains(cliente.getNombre()) && trimestres.get(2).contains(cliente.getNombre())
                    && trimestres.get(3).contains(cliente.getNombre())) {
                candidatos.add(cliente);
            }
        }

        List<CheckIn> ins = inRepository.findAllCheckInes();

        for (CheckIn in : ins) {
            if (in.getFechaIngreso().getYear() == 2023) {

                if (in.getFechaIngreso().isBefore(fecha1)) {
                    trimestresCheck.get(1).add(in.getCliente().toString());
                } else if (in.getFechaIngreso().isBefore(fecha2)) {
                    trimestresCheck.get(2).add(in.getCliente().toString());
                } else if (in.getFechaIngreso().isBefore(fecha3)) {
                    trimestresCheck.get(3).add(in.getCliente().toString());
                }
            }
        }

        for (Cliente candidato : candidatos) {
            if (trimestresCheck.get(1).contains(candidato.getId()) && trimestresCheck.get(2).contains(candidato.getId())
                    && trimestresCheck.get(3).contains(candidato.getId())) {
                listaRta.add(candidato);
            }
        }

        model.addAttribute("rta", listaRta);
        return "rfc4";
    }

}