package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.CheckOut;

import java.util.List;

public interface CheckOutRepository extends MongoRepository<CheckOut, String> {

    // CREATE
    CheckOut save(CheckOut check);

    // READ
    @Query("{}")
    List<CheckOut> findAllCheckOuts();

}