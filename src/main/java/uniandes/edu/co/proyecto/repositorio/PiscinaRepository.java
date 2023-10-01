package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.time.LocalDateTime;
import java.text.DecimalFormat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    
    @Query(value = "SELECT *  from piscinas", nativeQuery = true)
    Collection<Piscina> findAllPiscinas();

    @Query(value = "SELECT *  from piscinas where id = :id", nativeQuery = true)
    Piscina findPiscinaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (id, capacidad, apertura, cierre, valor, profundidad ) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :apertura, :cierre, :valor, :profundidad)" , nativeQuery = true)
    void insertPiscina(@Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") DecimalFormat valor, @Param("profundidad") Double profundidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, apertura = :apertura, cierre = :cierre, valor = :valor, profundidad = :profundidad WHERE id = :id" , nativeQuery = true)
    void updatePiscina(@Param("id") int id, @Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") DecimalFormat valor, @Param("profundidad") Double profundidad);    

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id" , nativeQuery = true)
    void deletePiscina(@Param("id") int id);

    





}
