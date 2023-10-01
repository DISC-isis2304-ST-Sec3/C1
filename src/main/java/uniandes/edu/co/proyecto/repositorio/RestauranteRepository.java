package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    @Query(value = "SELECT *  from restaurante", nativeQuery = true)
    Collection<Restaurante> findAllRestaurantes();

    @Query(value = "SELECT *  from restaurante where id = :id", nativeQuery = true)
    Restaurante findRestauranteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurante (id, capacidad, estilo ) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :estilo)" , nativeQuery = true)
    void insertRestaurante(@Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurante SET capacidad = :capacidad, estilo = :estilo WHERE id = :id" , nativeQuery = true)
    void updateRestaurante(@Param("id") int id, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurante WHERE id = :id" , nativeQuery = true)
    void deleteRestaurante(@Param("id") int id);
    

    
}
