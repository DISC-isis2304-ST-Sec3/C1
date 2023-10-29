package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC1Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT consumos.habitaciones_id, sum(consumos.costo) FROM RESERVAS " +
                    "INNER JOIN RESERVAN "+ 
                    "ON reservas.id = reservan.habitaciones_id " +
                    "INNER JOIN CONSUMOS "+
                    "ON consumos.habitaciones_id = reservan.habitaciones_id " +
                    "WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual) "+
                    "GROUP BY consumos.habitaciones_id ORDER BY consumos.habitaciones_id", nativeQuery = true )
                    Collection<Object[]> darConsumos();

                    
}



