package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.hospedaje.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, String> {

    @Query(value = "SELECT *  from tipos_habitacion", nativeQuery = true)
    Collection<TipoHabitacion> findAllTipoHabitacion();

    @Query(value = "SELECT *  from tipos_habitacion where nombre = :nombre", nativeQuery = true)
    TipoHabitacion findTipoHabitacionByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipos_habitacion (nombre, precio_base, capacidad) VALUES(:nombre, :precioBase, :capacidad)" , nativeQuery = true)
    void insertTipoHabitacion(@Param("nombre") String nombre, @Param("precioBase") Double precioBase, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tipos_habitacion SET precio_base = :precioBase, capacidad = :capacidad WHERE nombre = :nombre" , nativeQuery = true)
    void updateTipoHabitacion(@Param("nombre") String nombre, @Param("precioBase") Double precioBase, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipos_habitacion WHERE nombre = :nombre", nativeQuery = true)
    void deleteTipoHabitacion(@Param("nombre") String nombre);
    
}
