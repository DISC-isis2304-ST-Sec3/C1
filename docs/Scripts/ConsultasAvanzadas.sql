-- RFC9

-- base
SELECT consumos.tiposservicio_tipo AS servicio , 
reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre
FROM CONSUMOS
INNER JOIN RESERVAN
ON consumos.habitaciones_id = reservan.habitaciones_id
INNER JOIN RESERVAS
ON reservan.reservas_id = reservas.id
WHERE consumos.tiposservicio_tipo = 'spa'
AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23';

-- agrupado
SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado , 
reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha
FROM CONSUMOS
INNER JOIN RESERVAN
ON consumos.habitaciones_id = reservan.habitaciones_id
INNER JOIN RESERVAS
ON reservan.reservas_id = reservas.id
WHERE consumos.tiposservicio_tipo = 'spa'
AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento, 
reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida;

-- ordenado
SELECT consumos.tiposservicio_tipo AS servicio , 
reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha
FROM CONSUMOS
INNER JOIN RESERVAN
ON consumos.habitaciones_id = reservan.habitaciones_id
INNER JOIN RESERVAS
ON reservan.reservas_id = reservas.id
WHERE consumos.tiposservicio_tipo = 'spa'
AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
ORDER BY reservas.usuarios_num_documento;

-- agrupado y ordenado
SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS veces_usado , 
reservas.usuarios_tipo_documento, reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida AS fecha
FROM CONSUMOS
INNER JOIN RESERVAN
ON consumos.habitaciones_id = reservan.habitaciones_id
INNER JOIN RESERVAS
ON reservan.reservas_id = reservas.id
WHERE consumos.tiposservicio_tipo = 'spa'
AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
GROUP BY consumos.tiposservicio_tipo, reservas.usuarios_tipo_documento, 
reservas.usuarios_num_documento, reservas.usuarios_nombre, reservas.fecha_salida
ORDER BY reservas.usuarios_num_documento;

-- RFC10

-- base
SELECT * FROM INFORMACIONCLIENTES
WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento
    FROM CONSUMOS
    INNER JOIN RESERVAN
    ON consumos.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS
    ON reservan.reservas_id = reservas.id
    WHERE consumos.tiposservicio_tipo = 'spa'
    AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
);

-- agrupado
SELECT informacionclientes.tipo_documento, COUNT(*) AS cantidad 
FROM INFORMACIONCLIENTES
WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento
    FROM CONSUMOS
    INNER JOIN RESERVAN
    ON consumos.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS
    ON reservan.reservas_id = reservas.id
    WHERE consumos.tiposservicio_tipo = 'spa'
    AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
)
GROUP BY informacionclientes.tipo_documento;

-- ordenado

SELECT * FROM INFORMACIONCLIENTES
WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento
    FROM CONSUMOS
    INNER JOIN RESERVAN
    ON consumos.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS
    ON reservan.reservas_id = reservas.id
    WHERE consumos.tiposservicio_tipo = 'spa'
    AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
)
ORDER BY informacionclientes.nombre;

-- agrupado y ordenado

SELECT informacionclientes.tipo_documento, COUNT(*) AS cantidad 
FROM INFORMACIONCLIENTES
WHERE (infoRmacionclientes.tipo_documento, informacionclientes.num_documento) not in (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento
    FROM CONSUMOS
    INNER JOIN RESERVAN
    ON consumos.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS
    ON reservan.reservas_id = reservas.id
    WHERE consumos.tiposservicio_tipo = 'spa'
    AND reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
)
GROUP BY informacionclientes.tipo_documento
ORDER BY cantidad;

-- RFC11

WITH ConsumosPorSemana AS (
  SELECT TO_CHAR(r.fecha_salida, 'IW') AS semana, c.tiposservicio_tipo, COUNT(*) AS cantidad_consumos
  FROM RESERVAS r
  INNER JOIN RESERVAN rv ON r.id = rv.reservas_id
  INNER JOIN CONSUMOS c ON rv.habitaciones_id = c.habitaciones_id
  GROUP BY TO_CHAR(r.fecha_salida, 'IW'), c.tiposservicio_tipo
),
ReservasPorSemana AS (
  SELECT TO_CHAR(r.fecha_salida, 'IW') AS semana, rv.habitaciones_id, COUNT(*) AS cantidad_reservas
  FROM RESERVAS r
  INNER JOIN RESERVAN rv ON r.id = rv.reservas_id
  GROUP BY TO_CHAR(r.fecha_salida, 'IW'), rv.habitaciones_id
)
SELECT 
  semana,
    (SELECT tiposservicio_tipo
    FROM (
        SELECT ce.*,
        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_consumos ORDER BY semana) AS rn
        FROM ConsumosPorSemana ce
        WHERE cantidad_consumos = (SELECT MAX(cantidad_consumos) FROM ConsumosPorSemana c2 WHERE c2.semana = s.semana) and ce.semana = s.semana
        )
        WHERE rn = 1) AS servicio_mas_consumido,
      (SELECT tiposservicio_tipo
    FROM (
        SELECT ce.*,
        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_consumos ORDER BY semana) AS rn
        FROM ConsumosPorSemana ce
        WHERE cantidad_consumos = (SELECT MIN(cantidad_consumos) FROM ConsumosPorSemana c2  WHERE c2.semana = s.semana) and ce.semana = s.semana
        )
        WHERE rn = 1) AS servicio_menos_consumido,
    (SELECT habitaciones_id
    FROM (
        SELECT r.*,
        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_reservas ORDER BY semana) AS rn
        FROM ReservasPorSemana r
        WHERE cantidad_reservas = (SELECT MAX(cantidad_reservas) FROM ReservasPorSemana r2 ) and r.semana = s.semana
    )
    WHERE rn = 1) AS habitacion_mas_reservada,
    (SELECT habitaciones_id
    FROM (
        SELECT r.*,
        ROW_NUMBER() OVER (PARTITION BY semana, cantidad_reservas ORDER BY semana) AS rn
        FROM ReservasPorSemana r
        WHERE cantidad_reservas = (SELECT MIN(cantidad_reservas) FROM ReservasPorSemana r2 ) and r.semana = s.semana
    )
    WHERE rn = 1) AS habitacion_menos_reservada
FROM (SELECT DISTINCT TO_CHAR(fecha_salida, 'IW') AS semana FROM RESERVAS) s
ORDER BY semana;

-- RFC12

WITH ReservasPorTrimestre AS (
  SELECT
    r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc,
    r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo,
    TO_CHAR(r.fecha_inicio, 'YYYY-Q') AS trimestre,
    COUNT(*) AS num_reservas
  FROM RESERVAS r
  GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento,
    r.usuarios_num_documento, r.usuarios_correo, TO_CHAR(r.fecha_inicio, 'YYYY-Q')
),
ConsumosCostosos AS (
    SELECT r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc,
        r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo
    FROM CONSUMOS c
    INNER JOIN RESERVAN
    ON c.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS r
    ON reservan.reservas_id = r.id
    WHERE c.costo > 300000
    GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento,
        r.usuarios_num_documento, r.usuarios_correo  
),
ReservasLargas AS (
    SELECT r.usuarios_nombre AS nombre, r.usuarios_tipo_documento AS tipo_doc,
        r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo
    FROM RESERVASSERVICIO rs
    INNER JOIN RESERVAN
    ON rs.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS r
    ON reservan.reservas_id = r.id
    WHERE rs.duracion_hora >= 4
    GROUP BY r.usuarios_nombre, r.usuarios_tipo_documento,
        r.usuarios_num_documento, r.usuarios_correo 
)
SELECT c.nombre, c.tipo_doc, c.num_doc, c.correo, 'Estancias por trimestre' AS motivo
FROM ReservasPorTrimestre c
GROUP BY c.nombre, c.tipo_doc, c.num_doc, c.correo, c.num_reservas
HAVING count(*) >= 4
UNION ALL
SELECT cc.nombre, cc.tipo_doc, cc.num_doc, cc.correo, 'Consumos costosos' AS motivo
FROM ConsumosCostosos cc
UNION ALL
SELECT rl.nombre, rl.tipo_doc, rl.num_doc, rl.correo, 'Reservas mayores a 4H' AS motivo
FROM ReservasLargas rl;
