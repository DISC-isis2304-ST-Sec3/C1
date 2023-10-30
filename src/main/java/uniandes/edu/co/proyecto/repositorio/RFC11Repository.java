package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC11Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH ConsumosPorSemana AS ( " + //
                    "  SELECT TO_CHAR(r.fecha_salida, 'IW') AS semana, c.tiposservicio_tipo, COUNT(*) AS cantidad_consumos " + //
                    "  FROM RESERVAS r " + //
                    "  INNER JOIN RESERVAN rv ON r.id = rv.reservas_id " + //
                    "  INNER JOIN CONSUMOS c ON rv.habitaciones_id = c.habitaciones_id " + //
                    "  GROUP BY TO_CHAR(r.fecha_salida, 'IW'), c.tiposservicio_tipo " + //
                    "), " + //
                    "ReservasPorSemana AS ( " + //
                    "  SELECT TO_CHAR(r.fecha_salida, 'IW') AS semana, rv.habitaciones_id, COUNT(*) AS cantidad_reservas " + //
                    "  FROM RESERVAS r " + //
                    "  INNER JOIN RESERVAN rv ON r.id = rv.reservas_id " + //
                    "  GROUP BY TO_CHAR(r.fecha_salida, 'IW'), rv.habitaciones_id " + //
                    ") " + //
                    "SELECT  " + //
                    "  semana, " + //
                    "    (SELECT tiposservicio_tipo " + //
                    "    FROM ( " + //
                    "        SELECT c.*, " + //
                    "        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_consumos ORDER BY semana) AS rn " + //
                    "        FROM ConsumosPorSemana c " + //
                    "        WHERE cantidad_consumos = (SELECT MAX(cantidad_consumos) FROM ConsumosPorSemana c2 WHERE c2.semana = s.semana) and c.semana = s.semana " + //
                    "        ) " + //
                    "        WHERE rn = 1) AS servicio_mas_consumido, " + //
                    "      (SELECT tiposservicio_tipo " + //
                    "    FROM ( " + //
                    "        SELECT c.*, " + //
                    "        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_consumos ORDER BY semana) AS rn " + //
                    "        FROM ConsumosPorSemana c " + //
                    "        WHERE cantidad_consumos = (SELECT MIN(cantidad_consumos) FROM ConsumosPorSemana c2 WHERE c2.semana = s.semana) and c.semana = s.semana " + //
                    "        ) " + //
                    "        WHERE rn = 1) AS servicio_menos_consumido, " + //
                    "    (SELECT habitaciones_id " + //
                    "    FROM ( " + //
                    "        SELECT r.*, " + //
                    "        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_reservas ORDER BY semana) AS rn " + //
                    "        FROM ReservasPorSemana r " + //
                    "        WHERE cantidad_reservas = (SELECT MAX(cantidad_reservas) FROM ReservasPorSemana r2 ) and r.semana = s.semana " + //
                    "    ) " + //
                    "    WHERE rn = 1) AS habitacion_mas_reservada, " + //
                    "    (SELECT habitaciones_id " + //
                    "    FROM ( " + //
                    "        SELECT r.*, " + //
                    "        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_reservas ORDER BY semana) AS rn " + //
                    "        FROM ReservasPorSemana r " + //
                    "        WHERE cantidad_reservas = (SELECT MIN(cantidad_reservas) FROM ReservasPorSemana r2 ) and r.semana = s.semana " + //
                    "    ) " + //
                    "    WHERE rn = 1) AS habitacion_menos_reservada " + //
                    "FROM (SELECT DISTINCT TO_CHAR(fecha_salida, 'IW') AS semana FROM RESERVAS) s " + //
                    "ORDER BY semana", nativeQuery = true )
                    Collection<Object[]> darRta();

                    
}