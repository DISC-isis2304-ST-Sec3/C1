package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer >{
    
    @Query(value = "SELECT *  from habitaciones", nativeQuery = true)
    Collection<Habitacion> findAllHabitaciones();

    @Query(value = "SELECT *  from habitaciones where id = :id", nativeQuery = true)
    Habitacion findHabitacionById(@Param("id") int id);
    


}
