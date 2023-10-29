package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC5Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT consumos.tiposservicio_tipo, consumos.descripcion, consumos.costo FROM RESERVAS " + //
            "INNER JOIN RESERVAN " + //
            "ON reservas.id = reservan.habitaciones_id " + //
            "INNER JOIN CONSUMOS " + //
            "ON consumos.habitaciones_id = reservan.habitaciones_id " + //
            "INNER JOIN CHECKIN " + //
            "ON checkin.reservas_id = reservas.id " + //
            "WHERE reservas.fecha_salida BETWEEN :FechaI AND :FechaF " + //
            "AND reservas.usuarios_num_documento = :numDoc AND reservas.usuarios_tipo_documento = :tipoDoc ", nativeQuery = true )
                    Collection<Object[]> darConsumos(@Param("FechaI") String FechaInicial, @Param("FechaF") String FechaFinal,
                    @Param("numDoc") int numDoc, @Param("tipoDoc") String tipoDoc);

                    
}