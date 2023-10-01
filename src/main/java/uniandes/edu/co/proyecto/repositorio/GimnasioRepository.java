package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

    @Query(value = "SELECT *  from gimnasios", nativeQuery = true)
    Collection<Gimnasio> findAllGimnasios();

    @Query(value = "SELECT *  from gimnasios where id = :id", nativeQuery = true)
    Gimnasio findGimnasioById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (id, capacidad, apertura, cierre, valor) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :apertura, :cierre, :valor)" , nativeQuery = true)
    void insertGimnasio(@Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") Double valor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad = :capacidad, apertura = :apertura, cierre = :cierre, valor = :valor WHERE id = :id" , nativeQuery = true)
    void updateGimnasio(@Param("id") int id, @Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("valor") Double valor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id" , nativeQuery = true)
    void deleteGimnasio(@Param("id") int id);







}
