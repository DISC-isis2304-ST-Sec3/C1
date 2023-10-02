package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.servicios.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

import java.util.List;

@Service
public class InternetServicio {

    @Autowired
    InternetRepository internetRepository;

    public List<Internet> getAll() {
        return internetRepository.findAll();
    }

    public Internet getById(Integer servicioId) {
        return internetRepository.findInternetById(servicioId);
    }

    public Internet save(Internet internet) {
        internetRepository.insertInternet(internet.getServicioId(), internet.getCapacidad(), internet.getValorPorDia(), internet.getInicia(), internet.getFinaliza());
        return getById(internet.getServicioId());
    }

    public Internet update(Internet internet) {
        internetRepository.updateInternet(internet.getServicioId(), internet.getCapacidad(), internet.getValorPorDia(), internet.getInicia(), internet.getFinaliza());
        return getById(internet.getServicioId());
    }

    public Boolean deleteById(Integer servicioId) {
        internetRepository.deleteInternet(servicioId);
        return true;
    }
    
}
