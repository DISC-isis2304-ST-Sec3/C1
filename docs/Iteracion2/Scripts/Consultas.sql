-- RFC1 - caso agrupar por servicio

SELECT consumos.tiposservicio_tipo, sum(consumos.costo) FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual)
GROUP BY consumos.tiposservicio_tipo;

-- RFC1 - caso agrupar por habitaciÃ³n

SELECT consumos.habitaciones_id, sum(consumos.costo) FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual)
GROUP BY consumos.habitaciones_id;

-- RFC2

SELECT consumos.tiposservicio_tipo, COUNT(consumos.tiposservicio_tipo) AS cantidad
FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE reservas.fecha_salida > '31/12/22' AND reservas.fecha_salida < '31/12/23'
GROUP BY consumos.tiposservicio_tipo
ORDER BY COUNT(consumos.tiposservicio_tipo)
FETCH FIRST 20 ROWS ONLY;

-- RFC3

SELECT reservan.habitaciones_id, ROUND(SUM((reservas.fecha_salida - reservas.fecha_inicio)*100/365), 3) AS pct_ocupacion 
FROM reservas INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual)
GROUP BY reservan.habitaciones_id;

-- RFC4

-- base
SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha
FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id;

-- precio
SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha
FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE consumos.costo BETWEEN 100000 AND 300000;

-- fecha
SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha
FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE reservas.fecha_salida BETWEEN '10/10/23' AND '11/12/23';

-- tipo
SELECT consumos.tiposservicio_tipo, consumos.costo, reservas.fecha_salida AS fecha
FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
WHERE consumos.tiposservicio_tipo = 'spa';

-- RFC5

SELECT consumos.tiposservicio_tipo, consumos.descripcion, consumos.costo FROM RESERVAS 
INNER JOIN RESERVAN
ON reservas.id = reservan.habitaciones_id
INNER JOIN CONSUMOS
ON consumos.habitaciones_id = reservan.habitaciones_id
INNER JOIN CHECKIN
ON checkin.reservas_id = reservas.id
WHERE reservas.fecha_salida BETWEEN '31/12/22' AND '31/12/23'
AND reservas.usuarios_num_documento = 1765432 AND reservas.usuarios_tipo_documento = 'CE';

-- RFC6

-- fechas mayor ocupación

WITH CountMax AS (
    SELECT fecha, COUNT(*) AS conteo
    FROM (
        SELECT reservas.fecha_inicio + LEVEL - 1 AS fecha
        FROM RESERVAS
        CONNECT BY PRIOR fecha_inicio = fecha_inicio
        AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL
        AND LEVEL <= fecha_salida - fecha_inicio + 1
    )
    GROUP BY fecha
)
SELECT fecha
FROM CountMax
WHERE conteo = (SELECT MAX(conteo) FROM CountMax);

-- fechas mayores ingresos por consumo

WITH CountMax AS (
    SELECT reservas.fecha_inicio + LEVEL - 1  AS fecha, SUM(consumos.costo) AS costo_total
    FROM RESERVAS
    INNER JOIN RESERVAN
    ON reservas.id = reservan.habitaciones_id
    INNER JOIN CONSUMOS
    ON consumos.habitaciones_id = reservan.habitaciones_id
    GROUP BY reservas.fecha_inicio + LEVEL - 1
    CONNECT BY PRIOR fecha_inicio = fecha_inicio
    AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL
    AND LEVEL <= fecha_salida - fecha_inicio + 1
)
SELECT fecha
FROM CountMax
WHERE costo_total = (SELECT MAX(costo_total) FROM CountMax);

-- fechas menor ocupacion

WITH CountMin AS (
    SELECT fecha, COUNT(*) AS conteo
    FROM (
        SELECT reservas.fecha_inicio + LEVEL - 1 AS fecha
        FROM RESERVAS
        CONNECT BY PRIOR fecha_inicio = fecha_inicio
        AND PRIOR DBMS_RANDOM.VALUE IS NOT NULL
        AND LEVEL <= fecha_salida - fecha_inicio + 1
    )
    GROUP BY fecha
)
SELECT fecha
FROM CountMin
WHERE conteo = (SELECT MIN(conteo) FROM CountMin);

-- RFC7

WITH estadia AS (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,  
    reservas.usuarios_nombre, SUM(reservas.fecha_salida - reservas.fecha_inicio) AS dias
    FROM RESERVAS
    GROUP BY reservas.usuarios_num_documento, reservas.usuarios_tipo_documento,
    reservas.usuarios_nombre
)
, mejoresconsumos AS (
    SELECT reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,  
    reservas.usuarios_nombre, SUM(costo) AS costo_total
    FROM RESERVAS 
    INNER JOIN RESERVAN
    ON reservas.id = reservan.habitaciones_id
    INNER JOIN CONSUMOS
    ON consumos.habitaciones_id = reservan.habitaciones_id
    INNER JOIN CHECKIN
    ON checkin.reservas_id = reservas.id
    WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual)
    GROUP BY reservas.usuarios_tipo_documento, reservas.usuarios_num_documento,  
    reservas.usuarios_nombre
)
SELECT * FROM (
    SELECT usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre
    FROM ESTADIA
    WHERE dias = (SELECT MAX(dias) FROM estadia)
    UNION ALL
    SELECT usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre
    FROM mejoresconsumos
    WHERE costo_total = (SELECT MAX(costo_total) FROM mejoresconsumos)
    GROUP BY usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre
)
GROUP BY usuarios_tipo_documento, usuarios_num_documento, usuarios_nombre;

-- RFC8

WITH frecuencia_consumos AS (
    SELECT consumos.tiposservicio_tipo, COUNT(*) AS conteo FROM RESERVAS 
    INNER JOIN RESERVAN
    ON reservas.id = reservan.habitaciones_id
    INNER JOIN CONSUMOS
    ON consumos.habitaciones_id = reservan.habitaciones_id
    WHERE reservas.fecha_salida > (SELECT CURRENT_DATE-365 from dual)
    GROUP BY consumos.tiposservicio_tipo
)
SELECT frecuencia_consumos.tiposservicio_tipo FROM frecuencia_consumos 
WHERE conteo/52 < 3;
 




