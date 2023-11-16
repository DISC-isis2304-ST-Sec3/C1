package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Cliente;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    // CREATE
    Cliente save(Cliente cliente);

    // READ
    @Query("{ 'tipoDocumento' : ?0 , 'numDocumento' : ?1 }")
    Cliente findByNumero(String tipoDoc, int numDoc);

    @Query("{ 'numDocumento' : ?0 }")
    Cliente findByNumero2(int numDoc);

    @Query("{}")
    List<Cliente> findAllClientees();

}