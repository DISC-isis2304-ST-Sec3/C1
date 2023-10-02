package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer > {
    
    @Query(value = "SELECT *  from habitaciones", nativeQuery = true)
    Collection<Habitacion> findAllHabitacion();

    @Query(value = "SELECT *  from habitaciones where numero = :numero", nativeQuery = true)
    Habitacion findHabitacionByNumero(@Param("numero") Integer numero);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numero, tipo) VALUES(:numero, :tipo)" , nativeQuery = true)
    void insertHabitacion(@Param("numero") Integer numero, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipo = :tipo WHERE numero = :numero" , nativeQuery = true)
    void updateHabitacion(@Param("numero") Integer numero, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE numero = :numero", nativeQuery = true)
    void deleteHabitacion(@Param("numero") Integer numero);
    



}
