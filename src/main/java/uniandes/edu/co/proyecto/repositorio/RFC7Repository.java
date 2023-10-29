package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC7Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH estadia AS ( " + //
                    "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,   " + //
                    "    reservas.usuarios_nombre, SUM(reservas.fecha_salida - reservas.fecha_inicio) AS dias " + //
                    "    FROM RESERVAS " + //
                    "    GROUP BY reservas.usuarios_num_documento, reservas.usuarios_tipo_documento, " + //
                    "    reservas.usuarios_nombre " + //
                    ") " + //
                    ", mejoresconsumos AS ( " + //
                    "    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,   " + //
                    "    reservas.usuarios_nombre, SUM(costo) AS costo_total " + //
                    "    FROM RESERVAS  " + //
                    "    INNER JOIN RESERVAN " + //
                    "    ON reservas.id = reservan.habitaciones_id " + //
                    "    INNER JOIN CONSUMOS " + //
                    "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "    INNER JOIN CHECKIN " + //
                    "    ON checkin.reservas_id = reservas.id " + //
                    "    WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual) " + //
                    "    GROUP BY reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,   " + //
                    "    reservas.usuarios_nombre " + //
                    ") " + //
                    "SELECT * FROM ( " + //
                    "    SELECT usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre " + //
                    "    FROM ESTADIA " + //
                    "    WHERE dias = (SELECT MAX(dias) FROM estadia) " + //
                    "    UNION ALL " + //
                    "    SELECT usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre " + //
                    "    FROM mejoresconsumos " + //
                    "    WHERE costo_total = (SELECT MAX(costo_total) FROM mejoresconsumos) " + //
                    "    GROUP BY usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre " + //
                    ") " + //
                    "GROUP BY usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre ", nativeQuery = true )
                    Collection<Object[]> darRta();

                    
}