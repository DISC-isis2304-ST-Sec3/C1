package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamosRepository extends JpaRepository<Prestamo, Integer>{

    @Query(value = "SELECT *  from prestamos", nativeQuery = true)
    Collection<Prestamo> findAllPrestamos();

    @Query(value = "SELECT *  from prestamos where id = :id", nativeQuery = true)
    Prestamo findPrestamoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (id, nombre, utensilio, devuelto, condicion ) VALUES(HoteldelosAndes_sequence.nextval, :nombre, :utensilio, :devuelto, :condicion)" , nativeQuery = true)
    void insertPrestamo(@Param("nombre") String nombre, @Param("utensilio") String utensilio, @Param("devuelto") Boolean devuelto, @Param("condicion") String condicion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET nombre = :nombre, utensilio = :utensilio, devuelto = :devuelto, condicion = :condicion WHERE id = :id" , nativeQuery = true)
    void updatePrestamo(@Param("id") int id, @Param("nombre") String nombre, @Param("utensilio") String utensilio, @Param("devuelto") Boolean devuelto, @Param("condicion") String condicion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id" , nativeQuery = true)
    void deletePrestamo(@Param("id") int id);
    
    
    
}
