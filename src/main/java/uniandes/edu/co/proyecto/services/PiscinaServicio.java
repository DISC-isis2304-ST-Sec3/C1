package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.Repositorio.PiscinaRepository;
import uniandes.edu.co.proyecto.modelo.servicios.Piscina;

import java.util.List;

@Service
public class PiscinaServicio {
    
    @Autowired
    PiscinaRepository piscinaRepository;

    public List<Piscina> getAll() {
        return piscinaRepository.findAll();
    }

    public Piscina getById(Integer servicioId) {
        return piscinaRepository.findPiscinaByServicioId(servicioId);
    }

    public Piscina save(Piscina piscina) {
        piscinaRepository.insertPiscina(piscina.getServicioId(), piscina.getCapacidad(), piscina.getApertura(), piscina.getCierre(), piscina.getValor(), piscina.getProfundidad());
        return getById(piscina.getServicioId());
    }

    public Piscina update(Piscina piscina) {
        piscinaRepository.updatePiscina(piscina.getServicioId(), piscina.getCapacidad(), piscina.getApertura(), piscina.getCierre(), piscina.getValor(), piscina.getProfundidad());
        return getById(piscina.getServicioId());
    }

    public Boolean deleteById(Integer servicioId) {
        piscinaRepository.deletePiscina(servicioId);
        return true;
    }

}
