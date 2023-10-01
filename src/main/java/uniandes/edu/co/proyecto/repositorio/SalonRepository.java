package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer>{

    @Query(value = "SELECT *  from salones", nativeQuery = true)
    Collection<Salon> findAllSalones();

    @Query(value = "SELECT *  from salones where id = :id", nativeQuery = true)
    Salon findSalonById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (id, capacidad, costoHora, tiempoLimpieza ) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :costoHora, :tiempoLimpieza)" , nativeQuery = true)
    void insertSalon(@Param("capacidad") Integer capacidad, @Param("costoHora") double costoHora, @Param("tiempoLimpieza") Integer tiempoLimpieza);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET capacidad = :capacidad, costoHora = :costoHora, tiempoLimpieza = :tiempoLimpieza WHERE id = :id" , nativeQuery = true)
    void updateSalon(@Param("id") int id, @Param("capacidad") Integer capacidad, @Param("costoHora") double costoHora, @Param("tiempoLimpieza") Integer tiempoLimpieza);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE id = :id" , nativeQuery = true)
    void deleteSalon(@Param("id") int id);

    

}
