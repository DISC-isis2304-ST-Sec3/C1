package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.servicios.Prestamo;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;

import java.util.List;

@Service
public class PrestamoServicio {

    @Autowired
    PrestamoRepository prestamoRepository;

    public List<Prestamo> getAll() {
        return prestamoRepository.findAll();
    }

    public Prestamo getById(Integer Id) {
        return prestamoRepository.findPrestamoById(Id);
    }

    public Prestamo save(Prestamo prestamo) {
        prestamoRepository.insertPrestamo(prestamo.getId(), prestamo.getUtensilio() , prestamo.getDevuelto(), prestamo.getCondicion(), prestamo.getServicioId());
        return getById(prestamo.getId());
    }

    public Prestamo update(Prestamo prestamo) {
        prestamoRepository.updatePrestamo(prestamo.getId(), prestamo.getUtensilio() , prestamo.getDevuelto(), prestamo.getCondicion(), prestamo.getServicioId());
        return getById(prestamo.getId());
    }

    public Boolean deleteById(Integer Id) {
        prestamoRepository.deletePrestamo(Id);
        return true;
    }


    
}
