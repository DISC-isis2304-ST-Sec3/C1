package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaEstancia;

public interface ReservaEstanciaRepository extends JpaRepository<ReservaEstancia, Integer>{

    @Query(value = "SELECT *  from reservas_estancia", nativeQuery = true)
    Collection<ReservaEstancia> findAllReservasEstancia();

    @Query(value = "SELECT *  from reservas_estancia where id = :id", nativeQuery = true)
    ReservaEstancia findReservaEstanciaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas_estancia (id, fecha_inicio, fecha_fin, cantidadHuespedes) VALUES(HoteldelosAndes_sequence.nextval, :fecha_inicio, :fecha_fin, :cantidadHuespedes)" , nativeQuery = true)
    void insertReservaEstancia(@Param("fecha_inicio") String fecha_inicio, @Param("fecha_fin") String fecha_fin, @Param("cantidadHuespedes") int cantidadHuespedes);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas_estancia SET fecha_inicio = :fecha_inicio, fecha_fin = :fecha_fin, cantidadHuespedes = :cantidadHuespedes WHERE id = :id" , nativeQuery = true)
    void updateReservaEstancia(@Param("id") int id, @Param("fecha_inicio") String fecha_inicio, @Param("fecha_fin") String fecha_fin, @Param("cantidadHuespedes") int cantidadHuespedes);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas_estancia WHERE id = :id" , nativeQuery = true)
    void deleteReservaEstancia(@Param("id") int id);

}
