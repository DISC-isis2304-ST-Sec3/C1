package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC6Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH CountMax AS ( " + //
            "    SELECT fecha, COUNT(*) AS conteo " + //
            "    FROM ( " + //
            "        SELECT reservas.fecha_inicio + LEVEL - 1 AS fecha " + //
            "        FROM RESERVAS " + //
            "        CONNECT BY PRIOR fecha_inicio = fecha_inicio " + //
            "        AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL " + //
            "        AND LEVEL <= fecha_salida - fecha_inicio + 1 " + //
            "    ) " + //
            "    GROUP BY fecha " + //
            ") " + //
            "SELECT fecha " + //
            "FROM CountMax " + //
            "WHERE conteo = (SELECT MAX(conteo) FROM CountMax) ", nativeQuery = true )
                    Object[] darMayorOcupacion();
    
    @Query(value = "WITH CountMax AS ( " + //
            "    SELECT reservas.fecha_inicio + LEVEL - 1  AS fecha, SUM(consumos.costo) AS costo_total " + //
            "    FROM RESERVAS " + //
            "    INNER JOIN RESERVAN " + //
            "    ON reservas.id = reservan.habitaciones_id " + //
            "    INNER JOIN CONSUMOS " + //
            "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "    GROUP BY reservas.fecha_inicio + LEVEL - 1 " + //
            "    CONNECT BY PRIOR fecha_inicio = fecha_inicio " + //
            "    AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL " + //
            "    AND LEVEL <= fecha_salida - fecha_inicio + 1 " + //
            ") " + //
            "SELECT fecha " + //
            "FROM CountMax " + //
            "WHERE costo_total = (SELECT MAX(costo_total) FROM CountMax) ", nativeQuery = true )
                    Object[] darIngreso();
    
    @Query(value = "WITH CountMin AS ( " + //
            "    SELECT fecha, COUNT(*) AS conteo " + //
            "    FROM ( " + //
            "        SELECT reservas.fecha_inicio + LEVEL - 1 AS fecha " + //
            "        FROM RESERVAS " + //
            "        CONNECT BY PRIOR fecha_inicio = fecha_inicio " + //
            "        AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL " + //
            "        AND LEVEL <= fecha_salida - fecha_inicio + 1 " + //
            "    ) " + //
            "    GROUP BY fecha " + //
            ") " + //
            "SELECT fecha " + //
            "FROM CountMin " + //
            "WHERE conteo = (SELECT MIN(conteo) FROM CountMin) " , nativeQuery = true )
                    Object[] darMenorOcupacion();

                    
}