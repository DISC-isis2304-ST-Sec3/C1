package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanDeConsumo;

public interface PlanDeConsumoRepository extends JpaRepository<PlanDeConsumo, Integer>{

    @Query(value = "SELECT *  from planes_de_consumo", nativeQuery = true)
    Collection<PlanDeConsumo> findAllPlanesDeConsumo();

    @Query(value = "SELECT *  from planes_de_consumo where nombre = :nombre", nativeQuery = true)
    PlanDeConsumo findPlanDeConsumoById(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_de_consumo (nombre, descuento, minimasNoches, valor) VALUES(HoteldelosAndes_sequence.nextval, :descuento, :minimasNoches, :valor)" , nativeQuery = true)
    void insertPlanDeConsumo(@Param("descuento") String descuento, @Param("minimasNoches") String minimasNoches, @Param("valor") String valor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes_de_consumo SET descuento = :descuento, minimasNoches = :minimasNoches, valor = :valor WHERE nombre = :nombre" , nativeQuery = true)
    void updatePlanDeConsumo(@Param("nombre") String nombre, @Param("descuento") String descuento, @Param("minimasNoches") String minimasNoches, @Param("valor") String valor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_de_consumo WHERE nombre = :nombre" , nativeQuery = true)
    void deletePlanDeConsumo(@Param("nombre") String nombre);

    

}
