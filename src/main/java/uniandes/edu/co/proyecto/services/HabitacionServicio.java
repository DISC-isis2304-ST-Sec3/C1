package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

import java.util.List;

@Service
public class HabitacionServicio {

    @Autowired
    HabitacionRepository habitacionRepository;

    public List<Habitacion> getAll() {
        return habitacionRepository.findAll();
    }

    public Habitacion getByID(Integer id) {
        return habitacionRepository.findHabitacionByNumero(id);
    }
    
    public Habitacion save(Habitacion habitacion) {
        habitacionRepository.insertHabitacion(habitacion.getNumero(), habitacion.getTipo());
        return getByID(habitacion.getNumero());
    }

    public Habitacion update(Habitacion habitacion) {
        habitacionRepository.updateHabitacion(habitacion.getNumero(), habitacion.getTipo());
        return getByID(habitacion.getNumero());
    }

    public Boolean deleteByID(Integer id) {
        habitacionRepository.deleteHabitacion(id);
        return true;
    }

}
