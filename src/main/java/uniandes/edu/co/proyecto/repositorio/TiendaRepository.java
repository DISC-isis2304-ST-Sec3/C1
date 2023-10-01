package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT *  from tienda", nativeQuery = true)
    Collection<Tienda> findAllTiendas();

    @Query(value = "SELECT *  from tienda where id = :id", nativeQuery = true)
    Tienda findTiendaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tienda (id, tipo ) VALUES(HoteldelosAndes_sequence.nextval, :tipo)" , nativeQuery = true)
    void insertTienda(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tienda SET tipo = :tipo WHERE id = :id" , nativeQuery = true)
    void updateTienda(@Param("id") int id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tienda WHERE id = :id" , nativeQuery = true)
    void deleteTienda(@Param("id") int id);
    
}
