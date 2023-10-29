package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC10Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT * FROM INFORMACIONCLIENTES " + //
            "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
            "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
            "    FROM CONSUMOS " + //
            "    INNER JOIN RESERVAN " + //
            "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS " + //
            "    ON reservan.reservas_id = reservas.id " + //
            "    WHERE consumos.tiposservicio_tipo = :tipo " + //
            "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < FechaF " + //
            ") ", nativeQuery = true )
                    Collection<Object[]> darRtaBase(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);

    
    @Query(value = "SELECT * FROM INFORMACIONCLIENTES " + //
            "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
            "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
            "    FROM CONSUMOS " + //
            "    INNER JOIN RESERVAN " + //
            "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS " + //
            "    ON reservan.reservas_id = reservas.id " + //
            "    WHERE consumos.tiposservicio_tipo = :tipo " + //
            "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < FechaF " + //
            ") GROUP BY informacionclientes.tipo_documento", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupada(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
           
                    
    @Query(value = "SELECT * FROM INFORMACIONCLIENTES " + //
            "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
            "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
            "    FROM CONSUMOS " + //
            "    INNER JOIN RESERVAN " + //
            "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS " + //
            "    ON reservan.reservas_id = reservas.id " + //
            "    WHERE consumos.tiposservicio_tipo = :tipo " + //
            "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < FechaF " + //
            ") GROUP BY informacionclientes.tipo_documento " + //
            "ORDER BY cantidad ", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupadaYOrdenada(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
           
                    
    
    @Query(value = "SELECT * FROM INFORMACIONCLIENTES " + //
            "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
            "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
            "    FROM CONSUMOS " + //
            "    INNER JOIN RESERVAN " + //
            "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS " + //
            "    ON reservan.reservas_id = reservas.id " + //
            "    WHERE consumos.tiposservicio_tipo = :tipo " + //
            "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < FechaF " + //
            ") " + //
            "ORDER BY informacionclientes.nombre ", nativeQuery = true )
                    Collection<Object[]> darRtaOrdenada(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
                    
}