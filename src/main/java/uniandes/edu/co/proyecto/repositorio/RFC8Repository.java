package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC8Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH frecuencia_consumos AS ( " + //
                    "    SELECT consumos.tiposservicio_tipo, COUNT(*) AS conteo FROM RESERVAS  " + //
                    "    INNER JOIN RESERVAN " + //
                    "    ON reservas.id = reservan.habitaciones_id " + //
                    "    INNER JOIN CONSUMOS " + //
                    "    ON consumos.habitaciones_id = reservan.habitaciones_id " + //
                    "    WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual) " + //
                    "    GROUP BY consumos.tiposservicio_tipo " + //
                    ") " + //
                    "SELECT frecuencia_consumos.tiposservicio_tipo FROM frecuencia_consumos  " + //
                    "WHERE conteo/52 < 3", nativeQuery = true )
                    Collection<Object[]> darRta();

                    
}