package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Indumentaria;

public interface IndumentariaRepository extends JpaRepository<Indumentaria, Integer> {

    @Query(value = "SELECT *  from internet", nativeQuery = true)
    Collection<Indumentaria> findAllIndumentarias();

    @Query(value = "SELECT *  from internet where id = :id", nativeQuery = true)
    Indumentaria findIndumentariaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO induementarias (id, elementos, valorBase, valorElemento ) VALUES(HoteldelosAndes_sequence.nextval, :elementos, :valorBase, :valorElemento)" , nativeQuery = true)
    void insertIndumentaria(@Param("elementos") Integer elementos, @Param("valorBase") Double valorBase, @Param("valorElemento") Double valorElemento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE induementarias SET elementos = :elementos, valorBase = :valorBase, valorElemento = :valorElemento WHERE id = :id" , nativeQuery = true)
    void updateIndumentaria(@Param("id") int id, @Param("elementos") Integer elementos, @Param("valorBase") Double valorBase, @Param("valorElemento") Double valorElemento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM induementarias WHERE id = :id" , nativeQuery = true)
    void deleteIndumentaria(@Param("id") int id);
    
}
