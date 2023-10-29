package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC2Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS cantidad " +
                    "FROM RESERVAS " +
                    "INNER JOIN RESERVAN " +
                    "ON reservas.id = reservan.habitaciones_id " +
                    "INNER JOIN CONSUMOS " +
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " +
                    "WHERE reservas.fecha_salida > :fechaI AND reservas.fecha_salida < :fechaO " +
                    "GROUP BY consumos.tiposservicio_tipo " +
                    "ORDER BY COUNT(consumos.tiposservicio_tipo) DESC " +
                    "FETCH FIRST 20 ROWS ONLY", nativeQuery = true )
                    Collection<Object[]> darRta(@Param("fechaI") String fechaInicial, @Param("fechaO") String fechaFinal);

                    
}