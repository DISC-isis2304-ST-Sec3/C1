package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.reservas.servicios.ReservaServicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Object>{
    @Query(value = "SELECT * FROM reservas_servicios", nativeQuery=true)
    Collection<ReservaServicio> consultarReservasServicios();

    // @Query(value = "SELECT * FROM reservas_servicios WHERE servicio_id= :servicio_id AND numero_habitacion =: numero_habitacion AND fecha= :fecha", nativeQuery=true)
    // ReservaServicio consultarReservaServicio(@Param("servicio_id") Integer servicio_id, @Param("numero_habitacion") Integer num, @Param("fecha") LocalDateTime fecha);

    @Modifying
    @Transactional
    @Query(value = "INSERT into reservas_servicios (fecha, duracion, numero_habitacion, servicio_id) values (:fecha, :duracion, :numero_habitacion, :servicio_id)", nativeQuery=true)
    void registrarReservaServicio(@Param("fecha") LocalDateTime fecha, @Param("duracion") Integer duracion, @Param("numero_habitacion") Integer numero_habitacion, @Param("servicio_id") Integer servicio_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE from reservas_servicios WHERE numero_habitacion= :numero_habitacion", nativeQuery=true)
    void borrarReservaServicio(@Param("numero_habitacion") Integer numero_habitacion);


}
