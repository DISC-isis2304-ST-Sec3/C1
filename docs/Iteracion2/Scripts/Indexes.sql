DROP INDEX tiposservicio_idx;
DROP INDEX r_habitaciones_id_idx;
DROP INDEX c_habitaciones_id_idx;
DROP INDEX fecha_idx;
DROP INDEX usuarios_idx;

CREATE
INDEX tiposservicio_idx 
ON consumos(tiposservicio_tipo);

CREATE
INDEX r_habitaciones_id_idx 
ON reservan(habitaciones_id);

CREATE
INDEX c_habitaciones_id_idx 
ON consumos(habitaciones_id);

CREATE
INDEX fecha_idx 
ON reservas(fecha_salida);

CREATE
INDEX usuarios_idx 
ON reservas(usuarios_nombre, usuarios_tipo_documento, usuarios_num_documento, usuarios_correo);




