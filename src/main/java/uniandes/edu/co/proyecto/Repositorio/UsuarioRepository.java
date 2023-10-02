package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.usuarios.Usuario;
import uniandes.edu.co.proyecto.modelo.usuarios.Rol;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT *  from usuarios", nativeQuery = true)
    Collection<Usuario> findAllUsuarios();

    @Query(value = "SELECT *  from usuarios where documento = :documento", nativeQuery = true)
    Usuario findUsuarioByDocumento(@Param("documento") String documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (documento, nombre, apellido, edad, tipo_documento, email, rol) VALUES(:documento, :nombre, :apellido, :edad, :tipoDocumento, :email, :rol)" , nativeQuery = true)
    void insertUsuario(@Param("documento") String documento, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") Integer edad, @Param("tipoDocumento") String tipoDocumento, @Param("email") String email, @Param("rol") Rol rol);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nombre = :nombre, apellido = :apellido, edad = :edad, tipo_documento = :tipoDocumento, email = :email, rol = :rol WHERE documento = :documento" , nativeQuery = true)
    void updateUsuario(@Param("documento") String documento, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") Integer edad, @Param("tipoDocumento") String tipoDocumento, @Param("email") String email, @Param("rol") Rol rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE documento = :documento", nativeQuery = true)
    void deleteUsuario(@Param("documento") String documento);
    
}
