package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
    @Query(value = "SELECT *  from servicios", nativeQuery = true)
    Collection<Servicio> findAllServicio();

    @Query(value = "SELECT *  from servicios where id = :id", nativeQuery = true)
    Servicio findServicioById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, nombre) VALUES(:id, :nombre)" , nativeQuery = true)
    void insertServicio(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET nombre = :nombre WHERE id = :id" , nativeQuery = true)
    void updateServicio(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void deleteServicio(@Param("id") Integer id);

}