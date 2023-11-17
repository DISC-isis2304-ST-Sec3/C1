package uniandes.edu.co.proyecto.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class RFC2Controller {

    @Autowired
    private HabitacionRepository habitacionesRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/rfc2")
    public String consulta(Model model) {

        List<Reserva> reservas = reservaRepository.findAllReservaes();
        HashMap<Integer, Double> map = new HashMap<>();

        for (Reserva reserva : reservas) {
            if (reserva.getFechaSalida().getYear() == 2023) {
                Optional<Habitacion> habitacion = habitacionesRepository.findById(reserva.getHabitacion().toString());
                if (habitacion.isPresent()) {
                    Habitacion hab = habitacion.get();
                    if (map.containsKey(hab.getNumero())) {
                        map.put(hab.getNumero(), map.get(hab.getNumero()) + 1);
                    } else {
                        map.put(hab.getNumero(), 1.0);
                    }
                }

            }
        }

        List<Object[]> listaRta = new ArrayList<>();
        DecimalFormat formato = new DecimalFormat("#.###");
        for (Integer key : map.keySet()) {
            listaRta.add(new Object[] { key, formato.format((map.get(key) * 100 / 365)) });
        }
        model.addAttribute("rta", listaRta);
        return "rfc2";
    }

}