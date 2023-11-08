package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC12Repository extends JpaRepository<Consumos, Integer> {

    @Query(value = "WITH ReservasPorTrimestre AS ( " + //
            "  SELECT " + //
            "    r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc, " + //
            "    r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo, " + //
            "    TO_CHAR(r.fecha_inicio, 'YYYY-Q') AS trimestre, " + //
            "    COUNT(*) AS num_reservas " + //
            "  FROM RESERVAS r " + //
            "  GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento, " + //
            "    r.usuarios_num_documento, r.usuarios_correo, TO_CHAR(r.fecha_inicio, 'YYYY-Q') " + //
            "), " + //
            "ConsumosCostosos AS ( " + //
            "    SELECT r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc, " + //
            "        r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo " + //
            "    FROM CONSUMOS c " + //
            "    INNER JOIN RESERVAN " + //
            "    ON c.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS r " + //
            "    ON reservan.reservas_id = r.id " + //
            "    WHERE c.costo > 300000 " + //
            "    GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento, " + //
            "        r.usuarios_num_documento, r.usuarios_correo   " + //
            "), " + //
            "ReservasLargas AS ( " + //
            "    SELECT r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc, " + //
            "        r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo " + //
            "    FROM RESERVASSERVICIO rs " + //
            "    INNER JOIN RESERVAN " + //
            "    ON rs.habitaciones_id = reservan.habitaciones_id " + //
            "    INNER JOIN RESERVAS r " + //
            "    ON reservan.reservas_id = r.id " + //
            "    WHERE rs.duracion_hora >= 4 " + //
            "    GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento, " + //
            "        r.usuarios_num_documento, r.usuarios_correo  " + //
            ") " + //
            "SELECT c.nombre, c.tipo_doc, c.num_doc, c.correo, 'Estancias por trimestre' AS motivo " + //
            "FROM ReservasPorTrimestre c WHERE ROWNUM <= 300 " + //
            "GROUP BY c.nombre, c.tipo_doc, c.num_doc, c.correo, c.num_reservas " + //
            "HAVING count(*) >= 4 " + //
            "UNION ALL " + //
            "SELECT cc.nombre, cc.tipo_doc, cc.num_doc, cc.correo, 'Consumos costosos' AS motivo " + //
            "FROM ConsumosCostosos cc WHERE ROWNUM <= 300" + //
            "UNION ALL " + //
            "SELECT rl.nombre, rl.tipo_doc, rl.num_doc, rl.correo, 'Reservas mayores a 4H' AS motivo " + //
            "FROM ReservasLargas rl WHERE ROWNUM <= 300", nativeQuery = true)
    Collection<Object[]> darRta();

}