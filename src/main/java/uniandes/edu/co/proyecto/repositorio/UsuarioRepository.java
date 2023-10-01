package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(value = "SELECT *  from usuarios", nativeQuery = true)
    Collection<Usuario> findAllUsuarios();

    @Query(value = "SELECT *  from usuarios where id = :documento", nativeQuery = true)
    Usuario findUsuarioById(@Param("documento") String documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (documento, nombre, apellido, edad, email, tipo_documento, roles_nombre) VALUES(HoteldelosAndes_sequence.nextval, nombre, apellido, edad, email, tipo_documento, roles_nombre " , nativeQuery = true)
    void insertUsuario(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") int edad, @Param("email") String email, @Param("tipo_documento") String tipo_documento, @Param("roles_nombre") String roles_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, apellido = :apellido, edad = :edad, email = :email, tipo_documento = :tipo_documento, roles_nombre = :roles_nombre WHERE documento = :documento" , nativeQuery = true)
    void updateUsuario(@Param("documento") String documento, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") int edad, @Param("email") String email, @Param("tipo_documento") String tipo_documento, @Param("roles_nombre") String roles_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :documento" , nativeQuery = true)
    void deleteUsuario(@Param("documento") String documento);



}
