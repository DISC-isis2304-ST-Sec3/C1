package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.servicios.Salon;
import uniandes.edu.co.proyecto.repositorio.SalonRepository;

import java.util.List;

@Service
public class SalonServicio {

    @Autowired
    SalonRepository salonRepository;

    public List<Salon> getAll() {
        return salonRepository.findAll();
    }

    public Salon getById(Integer ServiceId) {
        return salonRepository.findSalonByServicioId(ServiceId);
    }

    public Salon save(Salon salon) {
        salonRepository.insertSalon(salon.getServicioId(), salon.getCapacidad(), salon.getCostoHora(), salon.getTiempoLimpieza(), salon.getTipoSalon());
        return getById(salon.getServicioId());
    }

    public Salon update(Salon salon) {
        salonRepository.updateSalon(salon.getServicioId(), salon.getCapacidad(), salon.getCostoHora(), salon.getTiempoLimpieza(), salon.getTipoSalon());
        return getById(salon.getServicioId());
    }

    public Boolean deleteById(Integer ServiceId) {
        salonRepository.deleteSalon(ServiceId);
        return true;
    }
    
}
