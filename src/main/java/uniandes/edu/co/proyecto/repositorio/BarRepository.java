package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer>{
    

    @Query(value = "SELECT *  from bares", nativeQuery = true)
    Collection<Bar> findAllBares();
    
    @Query(value = "SELECT *  from bares where id = :id", nativeQuery = true)
    Bar findBarById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (id, nombre, estilo ) VALUES(HoteldelosAndes_sequence.nextval, :nombre, :estilo)" , nativeQuery = true)
    void insertBar(@Param("nombre") String nombre, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET nombre = :nombre, estilo = :estilo WHERE id = :id" , nativeQuery = true)
    void updateBar(@Param("id") int id, @Param("nombre") String nombre, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE id = :id" , nativeQuery = true)
    void deleteBar(@Param("id") int id);

}
