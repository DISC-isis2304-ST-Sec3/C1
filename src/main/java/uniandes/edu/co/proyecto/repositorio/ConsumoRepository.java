package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{
    
    @Query(value = "SELECT *  from consumo", nativeQuery = true)
    Collection<Consumo> findAllConsumos();

    @Query(value = "SELECT *  from consumo where id = :id", nativeQuery = true)
    Consumo findConsumoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumo (id, valorTotal, fecha) VALUES(HoteldelosAndes_sequence.nextval, :valorTotal, :fecha)" , nativeQuery = true)
    void insertConsumo(@Param("valorTotal") Double valorTotal, @Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumo SET valorTotal = :valorTotal, fecha = :fecha WHERE id = :id" , nativeQuery = true)
    void updateConsumo(@Param("id") int id, @Param("valorTotal") Double valorTotal, @Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumo WHERE id = :id" , nativeQuery = true)
    void deleteConsumo(@Param("id") int id);
    


}
