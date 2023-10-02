package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.repositorio.RolRepository;
import uniandes.edu.co.proyecto.modelo.usuarios.Rol;

import java.util.List;

@Service
public class RolServicio {

    @Autowired
    RolRepository rolRepository;

    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    public Rol getByID(String nombre) {
        return rolRepository.findRolByNombre(nombre.toUpperCase());
    }

    public Rol save(Rol rol) {
        rolRepository.insertRol(rol.getNombre().toUpperCase());
        return getByID(rol.getNombre().toUpperCase());
    }

    public Rol update(Rol rol) {
        rolRepository.updateRol(rol.getNombre().toUpperCase());
        return getByID(rol.getNombre().toUpperCase());
    }

    public Boolean deleteByID(String nombre) {
        rolRepository.deleteRol(nombre.toUpperCase());
        return true;
    }
}
