package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.List;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {

    // CREATE
    Habitacion save(Habitacion habitacion);

    // READ
    @Query("{ 'tipo' : ?0 }")
    Habitacion findByNumero(String tipo);

    @Query("{}")
    List<Habitacion> findAllHabitaciones();

    // DELETE
    @Query(value = "{ 'numero' : ?0 }", delete = true)
    void deleteByNumero(Integer numero);

    // UPDATE
    @Query("{ 'tipo' : ?0 }")
    Habitacion updateHabitacion(String tipo, Habitacion tipoHabitacion);

}