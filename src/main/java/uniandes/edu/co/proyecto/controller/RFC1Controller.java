package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class RFC1Controller {

    @Autowired
    private HabitacionRepository habitacionesRepository;

    @GetMapping("/rfc1")
    public String consulta(Model model) {
        List<Habitacion> habitaciones = habitacionesRepository.findAllHabitaciones();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha1 = LocalDate.parse("2023-01-01", formatter);
        LocalDate fecha2 = LocalDate.parse("2023-12-31", formatter);
        List<Object[]> listaRta = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Habitacion hab : habitaciones) {
            if (hab.getConsumos() != null) {
                for (Consumo consumo : hab.getConsumos()) {
                    if (consumo.getFecha().isAfter(fecha1) && consumo.getFecha().isBefore(fecha2)) {
                        if (map.containsKey(hab.getNumero())) {
                            map.put(hab.getNumero(), map.get(hab.getNumero()) + consumo.getServicio().getCosto());
                        } else {
                            map.put(hab.getNumero(), consumo.getServicio().getCosto());
                        }
                    }

                }
            }
        }

        for (Integer key : map.keySet()) {
            listaRta.add(new Object[] { key, map.get(key) });
        }

        model.addAttribute("rta", listaRta);
        return "rfc1";
    }

}