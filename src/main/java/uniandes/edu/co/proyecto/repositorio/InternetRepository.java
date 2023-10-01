package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer>    {
    
    @Query(value = "SELECT *  from internet", nativeQuery = true)
    Collection<Internet> findAllInternets();

    @Query(value = "SELECT *  from internet where id = :id", nativeQuery = true)
    Internet findInternetById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (id, capacidad, valorPorDia, inicio, finaliza ) VALUES(HoteldelosAndes_sequence.nextval, :capacidad, :valorPorDia, :inicio, :finaliza)" , nativeQuery = true)
    void insertInternet(@Param("capacidad") Double capacidad, @Param("valorPorDia") Double valorPorDia, @Param("inicio") LocalDateTime inicio, @Param("finaliza") LocalDateTime finaliza);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internet SET capacidad = :capacidad, valorPorDia = :valorPorDia, inicio = :inicio, finaliza = :finaliza WHERE id = :id" , nativeQuery = true)
    void updateInternet(@Param("id") int id, @Param("capacidad") Double capacidad, @Param("valorPorDia") Double valorPorDia, @Param("inicio") LocalDateTime inicio, @Param("finaliza") LocalDateTime finaliza);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internet WHERE id = :id" , nativeQuery = true)
    void deleteInternet(@Param("id") int id);



}
