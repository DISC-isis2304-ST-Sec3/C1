package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Vigencia;

public interface VigenciaRepository extends JpaRepository<Vigencia, Integer> {

    @Query(value = "SELECT *  from vigencias", nativeQuery = true)
    Collection<Vigencia> findAllVigencias();

    @Query(value = "SELECT *  from vigencias where id = :id", nativeQuery = true)
    Vigencia findVigenciaById(@Param("id") int id);

    @Modifying
    @Transactional
    /*
     * Preguntar si es necesario el idPlanDeConsumo
     */
    @Query(value = "INSERT INTO vigencias (id, fechaInicio, fechaFin) VALUES(HoteldelosAndes_sequence.nextval, :fechaInicio, :fechaFin)" , nativeQuery = true)
    void insertVigencia(@Param("fechaInicio")  LocalDateTime fechaInicio, @Param("fechaFin")  LocalDateTime fechaFin);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE vigencias SET fechaInicio = :fechaInicio, fechaFin = :fechaFin, WHERE id = :id" , nativeQuery = true)
    void updateVigencia(@Param("id") int id, @Param("fechaInicio")  LocalDateTime fechaInicio, @Param("fechaFin")  LocalDateTime fechaFin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM vigencias WHERE id = :id" , nativeQuery = true)
    void deleteVigencia(@Param("id") int id);
    

}
