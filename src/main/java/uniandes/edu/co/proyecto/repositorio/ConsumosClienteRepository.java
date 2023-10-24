package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumos;
public interface ConsumosClienteRepository extends JpaRepository<Consumos, Integer> {
    
    @Query(value = "SELECT *\r\n" + //
                    "FROM consumos c\r\n" + //
                    "JOIN habitaciones h ON c.habitaciones_id = h.id\r\n" + //
                    "JOIN reservan r ON h.id = r.habitaciones_id\r\n" + //
                    "JOIN reservas rv ON r.reservas_id = rv.id\r\n" + //
                    "WHERE rv.usuarios_num_documento =: num_documento;\r\n" + //
                    "", nativeQuery = true )
    Collection<Consumos> darConsumoDeCliente(@Param("num_documento") int num_documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (habitaciones_id, tiposservicio_tipo, costo, descripcion)" +
    "VALUES (:habitacion_id, :tipo_servicio, :costo, :descripcion)", nativeQuery = true)
    void insertarConsumoCliente(@Param("habitacion_id") int habitacion_id, @Param("tipo_servicio") String tipo_servicio, @Param("costo") double costo, @Param("descripcion") String descripcion);
               

    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM consumos c\r\n" + //
                    "WHERE c.habitaciones_id IN (\r\n" + //
                    "    SELECT h.id \r\n" + //
                    "    FROM habitaciones h\r\n" + //
                    "    WHERE h.id IN (\r\n" + //
                    "        SELECT r.habitaciones_id\r\n" + //
                    "        FROM reservan r\r\n" + //
                    "        WHERE r.reservas_id IN (\r\n" + //
                    "            SELECT rv.id\r\n" + //
                    "            FROM reservas rv\r\n" + //
                    "            WHERE rv.usuarios_num_documento =: num_documento\r\n" + //
                    "        )\r\n" + //
                    "    )\r\n" + //
                    ");\r\n" + //
                    "", nativeQuery = true )
    void eliminarConsumosDeCliente(@Param("num_documento") int num_documento);

    
}