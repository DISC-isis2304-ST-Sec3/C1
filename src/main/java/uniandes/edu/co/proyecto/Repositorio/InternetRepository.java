package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Internet;

public interface InternetRepository  extends JpaRepository<Internet, Integer> {

    @Query(value = "SELECT *  from internet", nativeQuery = true)
    Collection<Internet> findAllInternet();

    @Query(value = "SELECT *  from internet where servicio_id = :id", nativeQuery = true)
    Internet findInternetById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (servicio_id, capacidad, valor_por_dia, inicia, finaliza) VALUES(:servicioId, :capacidad, :valorPorDia, :inicia, :finaliza)" , nativeQuery = true)
    void insertInternet(@Param("servicioId") Integer servicioId, @Param("capacidad") double capacidad, @Param("valorPorDia") double valorPorDia, @Param("inicia") LocalDateTime inicia, @Param("finaliza") LocalDateTime finaliza);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internet SET capacidad = :capacidad, valor_por_dia = :valorPorDia, inicia = :inicia, finaliza = :finaliza WHERE servicio_id = :servicioId" , nativeQuery = true)
    void updateInternet(@Param("servicioId") Integer servicioId, @Param("capacidad") double capacidad, @Param("valorPorDia") double valorPorDia, @Param("inicia") LocalDateTime inicia, @Param("finaliza") LocalDateTime finaliza);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internet WHERE servicio_id = :servicioId", nativeQuery = true)
    void deleteInternet(@Param("servicioId") Integer servicioId);
    

}
