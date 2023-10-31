package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC9Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT consumos.tiposservicio_tipo AS servicio ,  " + //
                    "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre " + //
                    "FROM CONSUMOS " + //
                    "INNER JOIN RESERVAN " + //
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "INNER JOIN RESERVAS " + //
                    "ON reservan.reservas_id = reservas.id " + //
                    "WHERE consumos.tiposservicio_tipo = :tipo " + //
                    "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF ", nativeQuery = true )
                    Collection<Object[]> darRtaBase(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);

    @Query(value = "SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado ,  " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
            "FROM CONSUMOS " + //
            "INNER JOIN RESERVAN " + //
            "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "INNER JOIN RESERVAS " + //
            "ON reservan.reservas_id = reservas.id " + //
            "WHERE consumos.tiposservicio_tipo = :tipo " + //
            "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
            "GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento,  " + //
            "reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupada(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);

    @Query(value = "SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado , " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
                    "FROM CONSUMOS " + //
                    "INNER JOIN RESERVAN " + //
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "INNER JOIN RESERVAS " + //
                    "ON reservan.reservas_id = reservas.id " + //
                    "WHERE consumos.tiposservicio_tipo = :tipo " + //
                    "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " +
                    "GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento, " + //
                    "reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida " +
                    "ORDER BY reservas.usuarios_num_documento ", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupadaYOrdenadanumDoc(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);

    @Query(value = "SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado , " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
                    "FROM CONSUMOS " + //
                    "INNER JOIN RESERVAN " + //
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "INNER JOIN RESERVAS " + //
                    "ON reservan.reservas_id = reservas.id " + //
                    "WHERE consumos.tiposservicio_tipo = :tipo " + //
                    "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " +
                    "GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento, " + //
                    "reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida " +
                    "ORDER BY reservas.usuarios_nombre ", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupadaYOrdenadaNombre(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
    @Query(value = "SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado , " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
                    "FROM CONSUMOS " + //
                    "INNER JOIN RESERVAN " + //
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "INNER JOIN RESERVAS " + //
                    "ON reservan.reservas_id = reservas.id " + //
                    "WHERE consumos.tiposservicio_tipo = :tipo " + //
                    "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " +
                    "GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento, " + //
                    "reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida " +
                    "ORDER BY consumos.tiposservicio_tipo ", nativeQuery = true )
                    Collection<Object[]> darRtaAgrupadaYOrdenadaServicio(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
           
    @Query(value = "SELECT consumos.tiposservicio_tipo AS servicio ,  " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
            "FROM CONSUMOS " + //
            "INNER JOIN RESERVAN " + //
            "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "INNER JOIN RESERVAS " + //
            "ON reservan.reservas_id = reservas.id " + //
            "WHERE consumos.tiposservicio_tipo = :tipo " + //
            "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
            "ORDER BY reservas.usuarios_num_documento ", nativeQuery = true )
                    Collection<Object[]> darRtaOrdenadaNumDoc(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
    
    @Query(value = "SELECT consumos.tiposservicio_tipo AS servicio ,  " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
            "FROM CONSUMOS " + //
            "INNER JOIN RESERVAN " + //
            "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "INNER JOIN RESERVAS " + //
            "ON reservan.reservas_id = reservas.id " + //
            "WHERE consumos.tiposservicio_tipo = :tipo " + //
            "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
            "ORDER BY reservas.usuarios_nombre ", nativeQuery = true )
                    Collection<Object[]> darRtaOrdenadaNobre(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
    
    @Query(value = "SELECT consumos.tiposservicio_tipo AS servicio ,  " + //
            "reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha " + //
            "FROM CONSUMOS " + //
            "INNER JOIN RESERVAN " + //
            "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "INNER JOIN RESERVAS " + //
            "ON reservan.reservas_id = reservas.id " + //
            "WHERE consumos.tiposservicio_tipo = :tipo " + //
            "AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
            "ORDER BY reservas.usuarios_nombre ", nativeQuery = true )
                    Collection<Object[]> darRtaOrdenadaFecha(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("tipo") String tipoServicio);
           
                    
}