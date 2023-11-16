package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Servicio;

import java.util.List;

public interface ServicioRepository extends MongoRepository<Servicio, String> {

    // CREATE
    Servicio save(Servicio servicio);

    // READ
    @Query(value = "{ tipo : ?0 }")
    Servicio findByTipo(String tipo);

    @Query("{}")
    List<Servicio> findAllServicios();

    // DELETE
    @Query(value = "{ 'tipo' : ?0 }", delete = true)
    void deleteByTipo(String tipo);

    // UPDATE
    @Query("{ 'tipo' : ?0 }")
    Servicio updateServicio(String tipo, Servicio tipoHabitacion);

}