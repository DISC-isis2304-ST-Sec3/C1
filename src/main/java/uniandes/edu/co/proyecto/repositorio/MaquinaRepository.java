package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Integer>{

    @Query(value = "SELECT *  from maquinas", nativeQuery = true)
    Collection<Maquina> findAllMaquinas();

    @Query(value = "SELECT *  from maquinas where id = :id", nativeQuery = true)
    Maquina findMaquinaById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maquinas (id, nombre ) VALUES(HoteldelosAndes_sequence.nextval, :nombre)" , nativeQuery = true)
    void insertMaquina(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maquinas SET nombre = :nombre WHERE id = :id" , nativeQuery = true)
    void updateMaquina(@Param("id") int id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maquinas WHERE id = :id" , nativeQuery = true)
    void deleteMaquina(@Param("id") int id);
    




}
