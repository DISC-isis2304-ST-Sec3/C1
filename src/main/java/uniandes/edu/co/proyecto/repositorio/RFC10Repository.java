package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC10Repository extends JpaRepository<Consumos, Integer> {

        @Query(value = "select * from (SELECT * FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ")) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaBase(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = "select * from ( SELECT informacionclientes.nombre, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ")" + //
                        "GROUP BY informacionclientes.nombre) WHERE ROWNUM <= 1000", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaNombre(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = " select * from (SELECT informacionclientes.tipo_documento, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "GROUP BY informacionclientes.tipo_documento) WHERE ROWNUM <= 1000", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaTipoDoc(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = " select * from (SELECT informacionclientes.correo, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "GROUP BY informacionclientes.correo) WHERE ROWNUM <= 1000", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaCorreo(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = " select * from (SELECT informacionclientes.nombre, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "GROUP BY informacionclientes.nombre ORDER BY cantidad) WHERE ROWNUM <= 1000", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaYOrdenadaNombre(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = " select * from (SELECT informacionclientes.tipo_documento, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "GROUP BY informacionclientes.tipo_documento ORDER BY cantidad) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaYOrdenadaTipoDoc(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = " select * from (SELECT informacionclientes.correo, COUNT(*) AS cantidad  " + //
                        "FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "GROUP BY informacionclientes.correo ORDER BY cantidad) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaAgrupadaYOrdenadaCorreo(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = "select * from (SELECT * FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "ORDER BY informacionclientes.tipo_documento) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaOrdenadaTipoDoc(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = "select * from (SELECT * FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "ORDER BY informacionclientes.nombre) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaOrdenadaNombre(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = "select * from (SELECT * FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "ORDER BY informacionclientes.num_documento) WHERE ROWNUM <= 1000 ", nativeQuery = true)
        Collection<Object[]> darRtaOrdenadaNumDoc(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

        @Query(value = "select * from (SELECT * FROM INFORMACIONCLIENTES " + //
                        "WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in ( " + //
                        "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento " + //
                        "    FROM CONSUMOS " + //
                        "    INNER JOIN RESERVAN " + //
                        "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                        "    INNER JOIN RESERVAS " + //
                        "    ON reservan.reservas_id = reservas.id " + //
                        "    WHERE consumos.tiposservicio_tipo = :tipo " + //
                        "    AND reservas.fecha_salida > :FechaI AND reservas.fecha_salida < :FechaF " + //
                        ") " + //
                        "ORDER BY informacionclientes.correo) WHERE ROWNUM <= 1000  ", nativeQuery = true)
        Collection<Object[]> darRtaOrdenadaCorreo(@Param("FechaI") String FechaInicial,
                        @Param("FechaF") String FechaFinal,
                        @Param("tipo") String tipoServicio);

}