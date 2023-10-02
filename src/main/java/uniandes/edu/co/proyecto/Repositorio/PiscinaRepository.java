package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import java.time.LocalDateTime;
import java.text.DecimalFormat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Piscina;
public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {

    @Query(value = "SELECT *  from piscinas", nativeQuery = true)
    Collection<Piscina> findAllPiscina();

    @Query(value = "SELECT *  from piscinas where servicio_id = :servicioId", nativeQuery = true)
    Piscina findPiscinaByServicioId(@Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (servicio_id, capacidad, apertura, cierre, valor, profundidad) VALUES(:servicioId, :capacidad, :apertura, :cierre, :valor, :profundidad)" , nativeQuery = true)
    void insertPiscina(@Param("servicioId") Integer servicioId, @Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") DecimalFormat valor, @Param("profundidad") Double profundidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, apertura = :apertura, cierre = :cierre, valor = :valor, profundidad = :profundidad WHERE servicio_id = :servicioId" , nativeQuery = true)
    void updatePiscina(@Param("servicioId") Integer servicioId, @Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") DecimalFormat valor, @Param("profundidad") Double profundidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE servicio_id = :servicioId", nativeQuery = true)
    void deletePiscina(@Param("servicioId") Integer servicioId);
    
    
}
