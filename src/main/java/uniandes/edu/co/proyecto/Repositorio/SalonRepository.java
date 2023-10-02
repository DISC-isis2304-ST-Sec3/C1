package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Salon;
import uniandes.edu.co.proyecto.modelo.servicios.Salon.TipoSalon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

    @Query(value = "SELECT *  from salones", nativeQuery = true)
    Collection<Salon> findAllSalon();

    @Query(value = "SELECT *  from salones where servicio_id = :servicioId", nativeQuery = true)
    Salon findSalonByServicioId(@Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (servicio_id, capacidad, costo_hora, tiempo_limpieza, tipo_salon) VALUES(:servicioId, :capacidad, :costoHora, :tiempoLimpieza, :tipoSalon)" , nativeQuery = true)
    void insertSalon(@Param("servicioId") Integer servicioId, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("tiempoLimpieza") Integer tiempoLimpieza, @Param("tipoSalon") TipoSalon tipoSalon);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET capacidad = :capacidad, costo_hora = :costoHora, tiempo_limpieza = :tiempoLimpieza, tipo_salon = :tipoSalon WHERE servicio_id = :servicioId" , nativeQuery = true)
    void updateSalon(@Param("servicioId") Integer servicioId, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("tiempoLimpieza") Integer tiempoLimpieza, @Param("tipoSalon") TipoSalon tipoSalon);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE servicio_id = :servicioId", nativeQuery = true)
    void deleteSalon(@Param("servicioId") Integer servicioId);
    

}
