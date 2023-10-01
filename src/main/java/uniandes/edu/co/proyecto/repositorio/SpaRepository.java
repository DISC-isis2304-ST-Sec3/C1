package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer>{
    
    @Query(value = "SELECT *  from spa", nativeQuery = true)
    Collection<Spa> findAllSpas();

    @Query(value = "SELECT *  from spa where id = :id", nativeQuery = true)
    Spa findSpaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spa (id, capacidad, apertura, cierre, franja ) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :apertura, :cierre, :franja)" , nativeQuery = true)
    void insertSpa(@Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("franja") Integer franja);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spa SET capacidad = :capacidad, apertura = :apertura, cierre = :cierre, franja = :franja WHERE id = :id" , nativeQuery = true)
    void updateSpa(@Param("id") int id, @Param("capacidad") Integer capacidad, @Param("apertura") LocalDateTime apertura, @Param("cierre") LocalDateTime cierre, @Param("franja") Integer franja);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spa WHERE id = :id" , nativeQuery = true)
    void deleteSpa(@Param("id") int id);
    


}
