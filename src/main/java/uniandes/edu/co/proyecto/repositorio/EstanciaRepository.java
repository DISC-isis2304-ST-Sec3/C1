package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.hospedaje.Estancia;
import uniandes.edu.co.proyecto.modelo.planes.PlanDeConsumo;

public interface  EstanciaRepository extends JpaRepository<Estancia, Integer>{
    @Query(value = "SELECT * FROM estancias", nativeQuery=true)
    Collection<PlanDeConsumo> consultarEstancias();

    @Query(value = "SELECT * FROM estancias WHERE id = :id", nativeQuery=true)
    PlanDeConsumo consultarEstancia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT into estancias (id, inicio, fin, cantidad_huespedes) VALUES (:id, :inicio, :fin, :cantidad_huespedes)", nativeQuery=true)
    void registrarEstancia(@Param("id") Integer id,@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin, @Param("cantidad_huespedes") Integer cantidad_huespedes);

    @Modifying
    @Transactional
    @Query(value = "DELETE from estancias WHERE id = :id", nativeQuery=true)
    void eliminarEstancia(@Param("id") Integer id);
}




