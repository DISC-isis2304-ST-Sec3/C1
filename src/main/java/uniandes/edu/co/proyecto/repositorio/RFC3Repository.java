package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC3Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT reservan.habitaciones_id, ROUND(SUM((reservas.fecha_salida - reservas.fecha_inicio)*100/365), 3) AS pct_ocupacion " +
                    "FROM reservas INNER JOIN RESERVAN " +
                    "ON reservas.id = reservan.habitaciones_id " +
                    "WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual) " +
                    "GROUP BY reservan.habitaciones_id", nativeQuery = true )
                    Collection<Object[]> darRta();

                    
}