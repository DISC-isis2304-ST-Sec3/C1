package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.usuarios.Rol;

public interface RolRepository extends JpaRepository<Rol, String> {

    @Query(value = "SELECT *  from roles", nativeQuery = true)
    Collection<Rol> findAllRol();

    @Query(value = "SELECT *  from roles where nombre = :nombre", nativeQuery = true)
    Rol findRolByNombre(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO roles (nombre) VALUES(:nombre)" , nativeQuery = true)
    void insertRol(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE roles SET nombre = :nombre WHERE nombre = :nombre" , nativeQuery = true)
    void updateRol(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM roles WHERE nombre = :nombre", nativeQuery = true)
    void deleteRol(@Param("nombre") String nombre);
    
}
