package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    
    @Query(value = "SELECT *  from prestamos", nativeQuery = true)
    Collection<Prestamo> findAllPrestamo();

    @Query(value = "SELECT *  from prestamos where id = :id", nativeQuery = true)
    Prestamo findPrestamoById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (id, utensilio, devuelto, condicion, servicio_id) VALUES(:id, :utensilio, :devuelto, :condicion, :servicioId)" , nativeQuery = true)
    void insertPrestamo(@Param("id") Integer id, @Param("utensilio") String utensilio, @Param("devuelto") Boolean devuelto, @Param("condicion") String condicion, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET utensilio = :utensilio, devuelto = :devuelto, condicion = :condicion, servicio_id = :servicioId WHERE id = :id" , nativeQuery = true)
    void updatePrestamo(@Param("id") Integer id, @Param("utensilio") String utensilio, @Param("devuelto") Boolean devuelto, @Param("condicion") String condicion, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
    void deletePrestamo(@Param("id") Integer id);
    

}
