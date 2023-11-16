package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    // CREATE
    Reserva save(Reserva reserva);

    // READ
    @Query("{ 'responsable' : ?0 }")
    Reserva findByNumero(Cliente responsable);

    @Query("{}")
    List<Reserva> findAllReservaes();

    // DELETE
    @Query(value = "{ 'responsable' : ?0 }", delete = true)
    void deleteByNumero(Cliente responsable);

    // UPDATE
    @Query("{ 'responsable' : ?0 }")
    Reserva updateReserva(Cliente responsable, Reserva tipoReserva);

}