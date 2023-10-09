package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.planes.PlanDeConsumo;

public interface PlanDeConsumoRepository extends JpaRepository<PlanDeConsumo, String> {

    @Query(value = "SELECT *  from planes_de_consumo", nativeQuery = true)  
    Collection<PlanDeConsumo> findAllPlanDeConsumo();

    @Query(value = "SELECT *  from planes_de_consumo where nombre = :nombre", nativeQuery = true)
    PlanDeConsumo findPlanDeConsumoByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_de_consumo (nombre, descuento, minimas_noches, valor, vigencia_id, restriccion_id) VALUES(:nombre, :descuento, :minimasNoches, :valor, :vigencia, :restriccion)" , nativeQuery = true)
    void insertPlanDeConsumo(@Param("nombre") String nombre, @Param("descuento") Double descuento, @Param("minimasNoches") Integer minimasNoches, @Param("valor") Double valor, @Param("vigencia") Integer vigencia, @Param("restriccion") Integer restriccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes_de_consumo SET descuento = :descuento, minimas_noches = :minimasNoches, valor = :valor, vigencia_id = :vigencia, restriccion_id = :restriccion WHERE nombre = :nombre" , nativeQuery = true)
    void updatePlanDeConsumo(@Param("nombre") String nombre, @Param("descuento") Double descuento, @Param("minimasNoches") Integer minimasNoches, @Param("valor") Double valor, @Param("vigencia") Integer vigencia, @Param("restriccion") Integer restriccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_de_consumo WHERE nombre = :nombre", nativeQuery = true)
    void deletePlanDeConsumo(@Param("nombre") String nombre);

}
