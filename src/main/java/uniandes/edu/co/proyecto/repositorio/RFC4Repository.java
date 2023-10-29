package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC4Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha  " + 
            "FROM RESERVAS " + 
            "INNER JOIN RESERVAN " + 
            "ON reservas.id = reservan.habitaciones_id " + 
            "INNER JOIN CONSUMOS " + 
            "ON consumos.habitaciones_id = reservan.habitaciones_id", nativeQuery = true )
                    Collection<Object[]> darRtaBase();

    @Query(value = "SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha  " + 
            "FROM RESERVAS " + 
            "INNER JOIN RESERVAN " + 
            "ON reservas.id = reservan.habitaciones_id " + 
            "INNER JOIN CONSUMOS " + 
            "ON consumos.habitaciones_id = reservan.habitaciones_id " +
            "WHERE consumos.costo BETWEEN :costoI AND :costoF ", nativeQuery = true )
                    Collection<Object[]> darRtaCosto(@Param("costoI") int costoInicial, @Param("costoF") int costoFinal);
    
    @Query(value = "SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha  " + 
            "FROM RESERVAS " + 
            "INNER JOIN RESERVAN " + 
            "ON reservas.id = reservan.habitaciones_id " + 
            "INNER JOIN CONSUMOS " + 
            "ON consumos.habitaciones_id = reservan.habitaciones_id " +
            "WHERE reservas.fecha_salida BETWEEN :FechaI AND :FechaF ", nativeQuery = true )
                    Collection<Object[]> darRtaFecha(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal);
    
    @Query(value = "SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha  " + 
            "FROM RESERVAS " + 
            "INNER JOIN RESERVAN " + 
            "ON reservas.id = reservan.habitaciones_id " + 
            "INNER JOIN CONSUMOS " + 
            "ON consumos.habitaciones_id = reservan.habitaciones_id " +
            "WHERE consumos.tiposservicio_tipo = :tipo ", nativeQuery = true )
                    Collection<Object[]> darRtaTipo(@Param("tipo") String tipoServicio);


                    
}