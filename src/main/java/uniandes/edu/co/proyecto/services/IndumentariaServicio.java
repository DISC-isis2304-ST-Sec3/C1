package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.servicios.Indumentaria;
import uniandes.edu.co.proyecto.repositorio.IndumentariaRepository;

import java.util.List;

@Service
public class IndumentariaServicio {
    
    @Autowired
    IndumentariaRepository indumentariaRepository;

    public List<Indumentaria> getAll() {
        return indumentariaRepository.findAll();
    }

    public Indumentaria getByID(Integer id) {
        return indumentariaRepository.findIndumentariaById(id);
    }

    public Indumentaria save(Indumentaria indumentaria) {
        indumentariaRepository.insertIndumentaria(indumentaria.getId(), indumentaria.getElementos(), indumentaria.getValorBase(), indumentaria.getValorElemento(), indumentaria.getServicioId());
        return getByID(indumentaria.getId());
    }

    public Indumentaria update(Indumentaria indumentaria) {
        indumentariaRepository.updateIndumentaria(indumentaria.getId(), indumentaria.getElementos(), indumentaria.getValorBase(), indumentaria.getValorElemento(), indumentaria.getServicioId());
        return getByID(indumentaria.getId());
    }

    public Boolean deleteByID(Integer id) {
        indumentariaRepository.deleteIndumentaria(id);
        return true;
    }
    

}
