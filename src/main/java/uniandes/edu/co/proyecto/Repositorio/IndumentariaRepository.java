package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.servicios.Indumentaria;

public interface IndumentariaRepository extends JpaRepository<Indumentaria, Integer> {

    @Query(value = "SELECT *  from indumentarias", nativeQuery = true)
    Collection<Indumentaria> findAllIndumentaria();

    @Query(value = "SELECT *  from indumentarias where id = :id", nativeQuery = true)
    Indumentaria findIndumentariaById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO indumentarias (id, elementos, valor_base, valor_elemento, servicio_id) VALUES(:id, :elementos, :valorBase, :valorElemento, :servicioId)" , nativeQuery = true)
    void insertIndumentaria(@Param("id") Integer id, @Param("elementos") Integer elementos, @Param("valorBase") double valorBase, @Param("valorElemento") double valorElemento, @Param("servicioId") Integer servicioId);    
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE indumentarias SET elementos = :elementos, valor_base = :valorBase, valor_elemento = :valorElemento, servicio_id = :servicioId WHERE id = :id" , nativeQuery = true)
    void updateIndumentaria(@Param("id") Integer id, @Param("elementos") Integer elementos, @Param("valorBase") double valorBase, @Param("valorElemento") double valorElemento, @Param("servicioId") Integer servicioId);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM indumentarias WHERE id = :id", nativeQuery = true)
    void deleteIndumentaria(@Param("id") Integer id);
    

}
