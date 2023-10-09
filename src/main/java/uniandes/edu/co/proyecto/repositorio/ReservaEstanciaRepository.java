package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.reservas.estancias.ReservaEstancia;


public interface ReservaEstanciaRepository extends JpaRepository<ReservaEstancia, Integer>{
    @Query(value = "select * from reservas_estancias", nativeQuery=true)
    Collection<ReservaEstancia> consultarReservasEstancias();

    @Query(value = "select * from reservas_estancias where id= :id", nativeQuery=true)
    ReservaEstancia consultarReservaEstancia (@Param("id")int id);

    @Modifying
    @Transactional
    @Query(value = "insert into reservas_estancias (id, inicio, fin, cantidad_huespedes) values (:id, :inicio, :fin, :cantidadHuespedes)", nativeQuery=true)
    void registrarReservaEstancia(@Param("id") Integer id, @Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin, @Param("cantidadHuespedes") Integer cantidadHuespedes);

    
    @Modifying
    @Transactional
    @Query(value = "update reservas_estancias set inicio= :inicio, fin= :fin, cantidad_huespedes= :cantidadHuespedes where id= :id", nativeQuery=true)
    void actualizarReservaEstancia(@Param("id") Integer id, @Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin, @Param("cantidadHuespedes") Integer cantidadHuespedes);

    @Modifying
    @Transactional
    @Query(value = "delete from reservas_estancias where id= :id", nativeQuery=true)
    void borrarReservaEstancia(@Param("id") Integer id);


}
