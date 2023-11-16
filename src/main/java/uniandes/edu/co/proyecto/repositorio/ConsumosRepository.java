package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumo;

import java.util.List;

public interface ConsumosRepository extends MongoRepository<Consumo, String> {

    // CREATE
    Consumo save(Consumo consumo);

    // READ
    @Query("{}")
    List<Consumo> findAllConsumoes();

}