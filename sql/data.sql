-- ITEMS
INSERT INTO items VALUES (1, 'anillo de diamantes', 3450000);
INSERT INTO items VALUES (2, 'aretes de oro', 899000);
INSERT INTO items VALUES (3, 'leche deslactosada', 4000);
INSERT INTO items VALUES (4, 'chocolate suizo', 20000);
INSERT INTO items VALUES (5, 'bloqueador solar', 90000);
INSERT INTO items VALUES (6, 'pasta bolognesa', 38000);
INSERT INTO items VALUES (7, 'estofado ruso', 76000);
INSERT INTO items VALUES (8, 'salmon a la naranja', 90000);
INSERT INTO items VALUES (9, 'gintonic', 42000);
INSERT INTO items VALUES (10, 'margarita', 25000);
INSERT INTO items VALUES (11, 'cerveza belga', 20000);
INSERT INTO items VALUES (12, 'masaje relajante', 200000);
INSERT INTO items VALUES (13, 'masaje tailandes', 300000);
INSERT INTO items VALUES (14, 'choco terapia', 430000);

-- PRODUCTOS
INSERT INTO PRODUCTOS VALUES ('nacional', 1);
INSERT INTO PRODUCTOS VALUES ('nacional', 2);
INSERT INTO PRODUCTOS VALUES ('nacional', 3);
INSERT INTO PRODUCTOS VALUES ('extranjero', 4);
INSERT INTO PRODUCTOS VALUES ('nacional', 5);
INSERT INTO PRODUCTOS VALUES ('nacional', 6);
INSERT INTO PRODUCTOS VALUES ('nacional', 7);
INSERT INTO PRODUCTOS VALUES ('nacional', 8);
INSERT INTO PRODUCTOS VALUES ('nacional', 9);
INSERT INTO PRODUCTOS VALUES ('nacional', 10);
INSERT INTO PRODUCTOS VALUES ('extranjero', 11);

-- SERVICIOS DEL HOTEL
INSERT INTO servicios VALUES (1, 'gimnasio la roca');
INSERT INTO servicios VALUES (2, 'internet');
INSERT INTO servicios VALUES (3, 'piscina club beach');
INSERT INTO servicios VALUES (4, 'servicio de indumentaria');
INSERT INTO servicios VALUES (5, 'prestamos de utensilios');
INSERT INTO servicios VALUES (6, 'Salon de reuniones - Jhon Kennedy');
INSERT INTO servicios VALUES (7, 'Salon de conferencias - Albert Haus');
INSERT INTO servicios VALUES (8, 'Joyeria Central');
INSERT INTO servicios VALUES (9, 'Minimarket');
INSERT INTO servicios VALUES (10, 'Nigth Club');
INSERT INTO servicios VALUES (11, 'Restaurante Le Crem');
INSERT INTO servicios VALUES (12, 'Spa Lili');
INSERT INTO servicios VALUES (13, 'piscina summer');

-- MAQUINAS
INSERT INTO maquinas VALUES ('caminadora');
INSERT INTO maquinas VALUES ('eliptica');
INSERT INTO maquinas VALUES ('press banca');

-- GIMNASIOS
INSERT INTO gimnasios VALUES (50, TO_TIMESTAMP('2023-10-01T06:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-01T22:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 0, 1);

-- MAQUINAS DEL GIMNASIO
INSERT INTO gym_maqs VALUES ('caminadora', 1);
INSERT INTO gym_maqs VALUES ('eliptica', 1);
INSERT INTO gym_maqs VALUES ('press banca', 1);

-- INTERNET
INSERT INTO internet VALUES (200, 0, TO_TIMESTAMP('2023-10-01T00:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-01T00:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 2);

-- PISCINAS
INSERT INTO psicinas VALUES (100, TO_TIMESTAMP('2023-10-01T08:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-01T00:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 0, 3, 3);
INSERT INTO psicinas VALUES (50, TO_TIMESTAMP('2023-10-01T08:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-01T00:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 0, 3, 13);

-- INDUMENTARIAS
INSERT INTO indumentarias VALUES (5, 80000, 10000, 4, 1);

-- PRESTAMOS
INSERT INTO prestamos VALUES ('toalla', 'false', 'alta', 5, 1);
INSERT INTO prestamos VALUES ('almohada', 'false', 'alta', 5, 2);

-- SALONES
INSERT INTO salones VALUES (12, 780000, 1, 6, 'REUNION');
INSERT INTO salones VALUES (250, 4500000, 12, 7, 'CONFERENCIA');

-- TIENDAS
INSERT INTO tiendas VALUES ('joyeria', 8);
INSERT INTO tiendas VALUES ('supermercado', 9);

-- PRODUCTOS TIENDA
INSERT INTO tiendas_productos VALUES (8, 1);
INSERT INTO tiendas_productos VALUES (8, 2);
INSERT INTO tiendas_productos VALUES (9, 3);
INSERT INTO tiendas_productos VALUES (9, 4);
INSERT INTO tiendas_productos VALUES (9, 5);

-- BARES
INSERT INTO bares VALUES (85, 'moderno', 10);

-- PRODUCTOS BARES
INSERT INTO bares_productos VALUES (10, 9);
INSERT INTO bares_productos VALUES (10, 10);
INSERT INTO bares_productos VALUES (10, 11);

-- RESTAURANTES
INSERT INTO restaurantes VALUES (100, 'frances', 11);

-- PRODUCTOS RESTAURANTES
INSERT INTO restaurante_prods VALUES (11, 6);
INSERT INTO restaurante_prods VALUES (11, 7);
INSERT INTO restaurante_prods VALUES (11, 8);

-- SPA
INSERT INTO spa VALUES (130, TO_TIMESTAMP('2023-10-01T08:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-01T20:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 60, 12);

-- PRODUCTOS SPA
INSERT INTO servicios_spa VALUES (12, 12, 120);
INSERT INTO servicios_spa VALUES (12, 13, 120);
INSERT INTO servicios_spa VALUES (12, 14, 480);

-- VIGENCIAS
INSERT INTO vigencias VALUES (1, TO_TIMESTAMP('2023-10-01T08:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-20T20:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));

-- RESTRICCIONES DIAS
INSERT INTO restriccion_dias VALUES (1, 1, 2, 3, 4, 5, 6, 7);

-- PLANES DE CONSUMO
INSERT INTO planes_de_consumo (nombre, descuento, minimas_noches) VALUES('larga estadia', 25, 7);
INSERT INTO planes_de_consumo (nombre, valor, restriccion_id) VALUES ('tiempo compartido', 1540000, 1);
INSERT INTO planes_de_consumo (nombre, valor) VALUES('todo incluido', 3600000);
INSERT INTO planes_de_consumo (nombre, descuento, minimas_noches, vigencia_id) VALUES('vacaciones octubre', 35, 10, 1);

-- PRODUCTOS INCLUIDOS EN PLANES DE CONSUMO
INSERT INTO productos_incluidos VALUES('todo incluido', 6, 1);
INSERT INTO productos_incluidos VALUES('todo incluido', 7, 1);
INSERT INTO productos_incluidos VALUES('todo incluido', 8, 1);
INSERT INTO productos_incluidos VALUES('todo incluido', 9, 1);
INSERT INTO productos_incluidos VALUES('todo incluido', 10, 1);

-- SERVICIOS INCLUIDOS EN PLANES DE CONSUMO
INSERT INTO servicios_incluidos VALUES ('todo incluido', 9, 15);
INSERT INTO servicios_incluidos VALUES ('tiempo compartido', 10, 10);
INSERT INTO servicios_incluidos VALUES ('tiempo compartido', 11, 10);

-- DOTACION
INSERT INTO dotaciones VALUES ('cama', 189000);
INSERT INTO dotaciones VALUES ('televisor', 34000);
INSERT INTO dotaciones VALUES ('escritorio', 65000);
INSERT INTO dotaciones VALUES ('minibar', 40000);
INSERT INTO dotaciones VALUES ('closet', 30000);
INSERT INTO dotaciones VALUES ('walking closet', 110000);
INSERT INTO dotaciones VALUES ('jacuzi', 210000);
INSERT INTO dotaciones VALUES ('balcon', 135000);
INSERT INTO dotaciones VALUES ('caja fuerte', 60000);
INSERT INTO dotaciones VALUES ('aire acondicionado', 70000);
INSERT INTO dotaciones VALUES ('cafetera', 20000);

-- TIPO HABITACIONES
INSERT INTO tipos_habitacion VALUES ('sencilla', 109000, 1);
INSERT INTO tipos_habitacion VALUES ('doble', 160000, 2);
INSERT INTO tipos_habitacion VALUES ('presidencial', 349000, 3);

-- DOTACION DE UN TIPO DE HABITACION
INSERT INTO dotacion_habitacion VALUES ('sencilla','cama');
INSERT INTO dotacion_habitacion VALUES ('sencilla','televisor');
INSERT INTO dotacion_habitacion VALUES ('sencilla','escritorio');
INSERT INTO dotacion_habitacion VALUES ('sencilla','closet');
INSERT INTO dotacion_habitacion VALUES ('doble','cama');
INSERT INTO dotacion_habitacion VALUES ('doble','televisor');
INSERT INTO dotacion_habitacion VALUES ('doble','escritorio');
INSERT INTO dotacion_habitacion VALUES ('doble','closet');
INSERT INTO dotacion_habitacion VALUES ('doble','aire acondicionado');
INSERT INTO dotacion_habitacion VALUES ('doble','cafetera');
INSERT INTO dotacion_habitacion VALUES ('presidencial','cama');
INSERT INTO dotacion_habitacion VALUES ('presidencial','televisor');
INSERT INTO dotacion_habitacion VALUES ('presidencial','escritorio');
INSERT INTO dotacion_habitacion VALUES ('presidencial','minibar');
INSERT INTO dotacion_habitacion VALUES ('presidencial','closet');
INSERT INTO dotacion_habitacion VALUES ('presidencial','walking closet');
INSERT INTO dotacion_habitacion VALUES ('presidencial','jacuzi');
INSERT INTO dotacion_habitacion VALUES ('presidencial','balcon');
INSERT INTO dotacion_habitacion VALUES ('presidencial','caja fuerte');
INSERT INTO dotacion_habitacion VALUES ('presidencial','aire acondicionado');
INSERT INTO dotacion_habitacion VALUES ('presidencial','cafetera');

-- HABITACIONES
INSERT INTO habitaciones VALUES (104, 'sencilla');
INSERT INTO habitaciones VALUES (103, 'sencilla');
INSERT INTO habitaciones VALUES (102, 'sencilla');
INSERT INTO habitaciones VALUES (101, 'sencilla');
INSERT INTO habitaciones VALUES (201, 'doble');
INSERT INTO habitaciones VALUES (203, 'doble');
INSERT INTO habitaciones VALUES (204, 'doble');
INSERT INTO habitaciones VALUES (205, 'doble');
INSERT INTO habitaciones VALUES (301, 'presidencial');
INSERT INTO habitaciones VALUES (302, 'presidencial');

-- ROLES
INSERT INTO roles VALUES ('CLIENTE');
INSERT INTO roles VALUES ('RECEPCIONISTA');
INSERT INTO roles VALUES ('CAJERO');
INSERT INTO roles VALUES ('ADMINISTRADOR');
INSERT INTO roles VALUES ('GERENTE');
INSERT INTO roles VALUES ('HUESPED');

-- USUARIOS
INSERT INTO usuarios VALUES ('juan david', 'rojas c', 20, 23479234, 'juan@email.com', 'CEDULA_DE_CIUDADANIA', 'ADMINISTRADOR');
INSERT INTO usuarios VALUES ('juan jose', 'cediel c', 20, 398234, 'jjose@email.com', 'TARJETA_DE_IDENTIDAD', 'RECEPCIONISTA');
INSERT INTO usuarios VALUES ('santiago', 'jaimes', 20, 2349283, 'santiago@email.com', 'PASAPORTE', 'CLIENTE');
INSERT INTO usuarios VALUES ('alejandro', 'lopez', 30, 9283423, 'alejandro@email.com', 'PASAPORTE', 'CLIENTE');
INSERT INTO usuarios VALUES ('felipe', 'lopez', 15, 2948583, 'felipe@email.com', 'PASAPORTE', 'CLIENTE');
INSERT INTO usuarios VALUES ('martina', 'heredia', 29, 4058503, 'martina@email.com', 'PASAPORTE', 'CLIENTE');
INSERT INTO usuarios VALUES ('lucy', 'lopez', 17, 8234982, 'lucy@email.com', 'PASAPORTE', 'CLIENTE');

-- RESERVAS
INSERT INTO reservas_estancias VALUES (1, TO_TIMESTAMP('2023-10-01T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-10T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 2, 2349283);
INSERT INTO reservas_estancias VALUES (2, TO_TIMESTAMP('2023-09-30T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), TO_TIMESTAMP('2023-10-05T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 4, 9283423);

-- RESERVAS HABITACIONES
INSERT INTO reserva_habs VALUES (2, 301);
INSERT INTO reserva_habs VALUES (2, 201);

-- ESTANCIAS
INSERT INTO estancias VALUES (2);

-- OCUPACIONES
INSERT INTO ocupaciones VALUES (301, 2, TO_TIMESTAMP('2023-09-30T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (201, 2, TO_TIMESTAMP('2023-09-30T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (301, 2, TO_TIMESTAMP('2023-10-01T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (201, 2, TO_TIMESTAMP('2023-10-01T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (301, 2, TO_TIMESTAMP('2023-10-02T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (201, 2, TO_TIMESTAMP('2023-10-02T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (301, 2, TO_TIMESTAMP('2023-10-03T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (201, 2, TO_TIMESTAMP('2023-10-03T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (301, 2, TO_TIMESTAMP('2023-10-04T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));
INSERT INTO ocupaciones VALUES (201, 2, TO_TIMESTAMP('2023-10-04T12:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));

-- CONSUMOS
INSERT INTO consumos VALUES (1, 154000, TO_TIMESTAMP('2023-10-01T09:34:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 11, 2);
INSERT INTO consumos VALUES (2, 899000, TO_TIMESTAMP('2023-10-01T12:54:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 8, 2);

-- ITEMS CONSUMIDOS
INSERT INTO items_consumidos VALUES (1, 6);
INSERT INTO items_consumidos VALUES (1, 8);
INSERT INTO items_consumidos VALUES (2, 2);

-- RESERVACION DE SERVICIOS
INSERT INTO reservas_servicios VALUES (TO_TIMESTAMP('2023-10-01T16:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'), 120, 301, 12);

-- ITEMS RESERVADOS EN UN SERVICIO
INSERT INTO rev_sev_items VALUES (13, 301, 12, TO_TIMESTAMP('2023-10-01T16:00:00.000000', 'YYYY-MM-DD"T"HH24:MI:SS.FF6'));

