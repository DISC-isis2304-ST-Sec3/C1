package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, String>{
    
    @Query(value = "SELECT *  from tiposHabitacion", nativeQuery = true)
    Collection<TipoHabitacion> findAllTiposHabitacion();

    @Query(value = "SELECT *  from tiposHabitacion where nombre = :nombre", nativeQuery = true)
    TipoHabitacion findTipoHabitacionByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposHabitacion (nombre, precioBase ,capacidad) VALUES(HoteldelosAndes_sequence.nextval, :precioBase ,:capacidad)" , nativeQuery = true)
    void insertTipoHabitacion( @Param(" precioBase") Double precioBase, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposHabitacion SET  precioBase = : precioBase, capacidad = :capacidad WHERE nombre = :nombre" , nativeQuery = true)
    void updateTipoHabitacion(@Param("nombre") String nombre, @Param(" precioBase") Double precioBase, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposHabitacion WHERE nombre = :nombre" , nativeQuery = true)
    void deleteTipoHabitacion(@Param("nombre") String nombre);

}
