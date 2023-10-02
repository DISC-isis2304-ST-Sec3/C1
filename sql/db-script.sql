-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 20:06:25 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
    capacidad   INTEGER NOT NULL,
    estilo      VARCHAR2(50) NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( servicio_id );

CREATE TABLE bares_productos (
    bar_id      INTEGER NOT NULL,
    producto_id INTEGER NOT NULL
);

ALTER TABLE bares_productos ADD CONSTRAINT bares_productos_pk PRIMARY KEY ( bar_id,
                                                                            producto_id );

CREATE TABLE consumos (
    id          INTEGER NOT NULL,
    valor_total NUMBER(12, 2) NOT NULL,
    fecha       TIMESTAMP NOT NULL,
    servicio_id INTEGER NOT NULL,
    estancia_id INTEGER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( id );

CREATE TABLE dotacion_habitacion (
    tipo_habitacion VARCHAR2(50 CHAR) NOT NULL,
    dotacion        VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE dotacion_habitacion ADD CONSTRAINT dotacion_hab_pk PRIMARY KEY ( tipo_habitacion,
                                                                             dotacion );

CREATE TABLE dotaciones (
    nombre         VARCHAR2(50 CHAR) NOT NULL,
    valor_agregado NUMBER(12, 2) NOT NULL
);

ALTER TABLE dotaciones ADD CONSTRAINT dotaciones_pk PRIMARY KEY ( nombre );

CREATE TABLE estancias (
    id INTEGER NOT NULL
);

ALTER TABLE estancias ADD CONSTRAINT estancias_pk PRIMARY KEY ( id );

CREATE TABLE gimnasios (
    capacidad   INTEGER NOT NULL,
    apertura    TIMESTAMP NOT NULL,
    cierre      TIMESTAMP NOT NULL,
    valor       NUMBER(12, 2) NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( servicio_id );

CREATE TABLE gym_maqs (
    maquina_nombre VARCHAR2(50 CHAR) NOT NULL,
    gimnasio_id    INTEGER NOT NULL
);

ALTER TABLE gym_maqs ADD CONSTRAINT gym_maqs_pk PRIMARY KEY ( maquina_nombre,
                                                              gimnasio_id );

CREATE TABLE habitaciones (
    numero INTEGER NOT NULL,
    tipo   VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numero );

CREATE TABLE indumentarias (
    elementos      INTEGER NOT NULL,
    valor_base     NUMBER(12, 2) NOT NULL,
    valor_elemento NUMBER(12, 2) NOT NULL,
    servicio_id    INTEGER NOT NULL,
    id             INTEGER NOT NULL
);

ALTER TABLE indumentarias ADD CONSTRAINT indumentarias_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    capacidad     NUMBER(6, 2) NOT NULL,
    valor_por_dia NUMBER(12, 2) NOT NULL,
    inicia        TIMESTAMP NOT NULL,
    finaliza      TIMESTAMP NOT NULL,
    servicio_id   INTEGER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( servicio_id );

CREATE TABLE items (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(100 CHAR) NOT NULL,
    valor  NUMBER(12, 2) NOT NULL
);

ALTER TABLE items ADD CONSTRAINT items_pk PRIMARY KEY ( id );

CREATE TABLE items_consumidos (
    consumo_id INTEGER NOT NULL,
    item_id    INTEGER NOT NULL
);

ALTER TABLE items_consumidos ADD CONSTRAINT items_consumidos_pk PRIMARY KEY ( consumo_id,
                                                                              item_id );

CREATE TABLE maquinas (
    nombre VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( nombre );

CREATE TABLE ocupaciones (
    habitacion_numero INTEGER NOT NULL,
    estancia_id       INTEGER NOT NULL,
    fecha             TIMESTAMP NOT NULL
);

ALTER TABLE ocupaciones
    ADD CONSTRAINT ocupaciones_pk PRIMARY KEY ( habitacion_numero,
                                                estancia_id,
                                                fecha );

CREATE TABLE planes_de_consumo (
    nombre         VARCHAR2(100 CHAR) NOT NULL,
    descuento      NUMBER(5, 2),
    minimas_noches INTEGER,
    valor          NUMBER(12, 2),
    vigencia_id    INTEGER,
    restriccion_id INTEGER
);

CREATE UNIQUE INDEX planes_de_consumo__idx ON
    planes_de_consumo (
        restriccion_id
    ASC );

CREATE UNIQUE INDEX planes_de_consumo__idxv1 ON
    planes_de_consumo (
        vigencia_id
    ASC );

ALTER TABLE planes_de_consumo ADD CONSTRAINT planes_de_consumo_pk PRIMARY KEY ( nombre );

CREATE TABLE prestamos (
    utensilio   VARCHAR2(50 CHAR) NOT NULL,
    devuelto    VARCHAR2(5 CHAR) DEFAULT 'false',
    condicion   VARCHAR2(30 CHAR) NOT NULL,
    servicio_id INTEGER NOT NULL,
    id          INTEGER NOT NULL
);

ALTER TABLE prestamos ADD CONSTRAINT prestamos_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    origen  VARCHAR2(20) NOT NULL,
    item_id INTEGER NOT NULL
);

ALTER TABLE productos
    ADD CONSTRAINT ck_origen CHECK ( origen IN ( 'extranjero', 'nacional' ) );

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( item_id );

CREATE TABLE productos_incluidos (
    plan_de_consumo VARCHAR2(100 CHAR) NOT NULL,
    producto_id     INTEGER NOT NULL,
    cantidad        NUMBER(12, 2) NOT NULL
);

ALTER TABLE productos_incluidos ADD CONSTRAINT productos_incluidos_pk PRIMARY KEY ( plan_de_consumo,
                                                                                    producto_id );

CREATE TABLE psicinas (
    capacidad   INTEGER NOT NULL,
    apertura    TIMESTAMP NOT NULL,
    cierre      TIMESTAMP NOT NULL,
    valor       NUMBER(12, 2) NOT NULL,
    profundidad NUMBER(12, 2) NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE psicinas ADD CONSTRAINT psicinas_pk PRIMARY KEY ( servicio_id );

CREATE TABLE reserva_habs (
    reserva_id        INTEGER NOT NULL,
    habitacion_numero INTEGER NOT NULL
);

ALTER TABLE reserva_habs ADD CONSTRAINT reserva_habs_pk PRIMARY KEY ( reserva_id,
                                                                      habitacion_numero );

CREATE TABLE reservas_estancias (
    id                 INTEGER NOT NULL,
    inicio             TIMESTAMP NOT NULL,
    fin                TIMESTAMP NOT NULL,
    cantidad_huespedes INTEGER NOT NULL,
    cliente            INTEGER NOT NULL
);

ALTER TABLE reservas_estancias ADD CONSTRAINT reservas_estancias_pk PRIMARY KEY ( id );

CREATE TABLE reservas_servicios (
    fecha             TIMESTAMP NOT NULL,
    duracion          INTEGER NOT NULL,
    numero_habitacion INTEGER NOT NULL,
    servicio_id       INTEGER NOT NULL
);

ALTER TABLE reservas_servicios
    ADD CONSTRAINT reservas_servicios_pk PRIMARY KEY ( numero_habitacion,
                                                       servicio_id,
                                                       fecha );

CREATE TABLE restaurante_prods (
    restaurante_id INTEGER NOT NULL,
    producto_id    INTEGER NOT NULL
);

ALTER TABLE restaurante_prods ADD CONSTRAINT restaurante_prods_pk PRIMARY KEY ( restaurante_id,
                                                                                producto_id );

CREATE TABLE restaurantes (
    capacidad   INTEGER NOT NULL,
    estilo      VARCHAR2(50) NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( servicio_id );

CREATE TABLE restriccion_dias (
    id        INTEGER NOT NULL,
    lunes     INTEGER,
    martes    INTEGER,
    miercoles INTEGER,
    jueves    INTEGER,
    viernes   INTEGER,
    sabado    INTEGER,
    domingo   INTEGER
);

ALTER TABLE restriccion_dias
    ADD CONSTRAINT cp_restriccion_dia CHECK ( lunes IN ( domingo, jueves, lunes, martes, miercoles,
                                                         sabado, viernes ) );

ALTER TABLE restriccion_dias ADD CONSTRAINT restriccion_dias_pk PRIMARY KEY ( id );

CREATE TABLE rev_sev_items (
    item_id           INTEGER NOT NULL,
    numero_habitacion INTEGER NOT NULL,
    servicio_id       INTEGER NOT NULL,
    reserva_fecha     TIMESTAMP NOT NULL
);

ALTER TABLE rev_sev_items
    ADD CONSTRAINT revsev_items_pk PRIMARY KEY ( numero_habitacion,
                                                 servicio_id,
                                                 item_id,
                                                 reserva_fecha );

CREATE TABLE roles (
    nombre VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY ( nombre );

CREATE TABLE salones (
    capacidad       INTEGER NOT NULL,
    costo_hora      NUMBER(12, 2) NOT NULL,
    tiempo_limpieza INTEGER NOT NULL,
    servicio_id     INTEGER NOT NULL,
    tipo_salones    VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE salones
    ADD CONSTRAINT ck_tipo_salon CHECK ( tipo_salones IN ( 'CONFERENCIA', 'REUNION' ) );

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( servicio_id );

CREATE TABLE servicios (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE servicios_incluidos (
    plan_de_consumo VARCHAR2(100 CHAR) NOT NULL,
    servicios_id    INTEGER NOT NULL,
    descuento       NUMBER(5, 2) NOT NULL
);

ALTER TABLE servicios_incluidos ADD CONSTRAINT servicios_incluidos_pk PRIMARY KEY ( plan_de_consumo,
                                                                                    servicios_id );

CREATE TABLE servicios_spa (
    spa_id   INTEGER NOT NULL,
    items_id INTEGER NOT NULL,
    duracion INTEGER NOT NULL
);

ALTER TABLE servicios_spa ADD CONSTRAINT servicios_spa_pk PRIMARY KEY ( spa_id,
                                                                        items_id );

CREATE TABLE spa (
    capacidad   INTEGER NOT NULL,
    apertura    TIMESTAMP NOT NULL,
    cierre      TIMESTAMP NOT NULL,
    franja      INTEGER NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( servicio_id );

CREATE TABLE tiendas (
    tipo        VARCHAR2(50) NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( servicio_id );

CREATE TABLE tiendas_productos (
    tienda_id   INTEGER NOT NULL,
    producto_id INTEGER NOT NULL
);

ALTER TABLE tiendas_productos ADD CONSTRAINT tiendas_productos_pk PRIMARY KEY ( tienda_id,
                                                                                producto_id );

CREATE TABLE tipos_habitacion (
    nombre      VARCHAR2(50 CHAR) NOT NULL,
    precio_base NUMBER(12, 2) NOT NULL,
    capacidad   INTEGER NOT NULL
);

ALTER TABLE tipos_habitacion ADD CONSTRAINT tipos_habitacion_pk PRIMARY KEY ( nombre );

CREATE TABLE usuarios (
    nombre         VARCHAR2(100 CHAR) NOT NULL,
    apellido       VARCHAR2(100 CHAR) NOT NULL,
    edad           INTEGER NOT NULL,
    documento      INTEGER NOT NULL,
    email          VARCHAR2(100 CHAR) NOT NULL,
    tipo_documento VARCHAR2(50 CHAR) NOT NULL,
    rol            VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE usuarios
    ADD CONSTRAINT ck_tipo_documento CHECK ( tipo_documento IN ( 'CEDULA_DE_CIUDADANIA', 'PASAPORTE', 'TARJETA_DE_IDENTIDAD' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( documento );

CREATE TABLE vigencias (
    id     INTEGER NOT NULL,
    inicio TIMESTAMP NOT NULL,
    final  TIMESTAMP NOT NULL
);

ALTER TABLE vigencias ADD CONSTRAINT vigencias_pk PRIMARY KEY ( id );

ALTER TABLE bares_productos
    ADD CONSTRAINT bares_prod_bar_fk FOREIGN KEY ( bar_id )
        REFERENCES bares ( servicio_id );

ALTER TABLE bares_productos
    ADD CONSTRAINT bares_prod_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( item_id );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE items_consumidos
    ADD CONSTRAINT consumo_fk FOREIGN KEY ( consumo_id )
        REFERENCES consumos ( id );

ALTER TABLE items_consumidos
    ADD CONSTRAINT consumo_items_fk FOREIGN KEY ( item_id )
        REFERENCES items ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_estancias_fk FOREIGN KEY ( estancia_id )
        REFERENCES estancias ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE dotacion_habitacion
    ADD CONSTRAINT dothab_dotacion_fk FOREIGN KEY ( dotacion )
        REFERENCES dotaciones ( nombre );

ALTER TABLE dotacion_habitacion
    ADD CONSTRAINT dothab_tipo_habitacion_fk FOREIGN KEY ( tipo_habitacion )
        REFERENCES tipos_habitacion ( nombre );

ALTER TABLE estancias
    ADD CONSTRAINT est_resv_est_fk FOREIGN KEY ( id )
        REFERENCES reservas_estancias ( id );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE gym_maqs
    ADD CONSTRAINT gym_maqs_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasios ( servicio_id );

ALTER TABLE gym_maqs
    ADD CONSTRAINT gym_maqs_maquina_fk FOREIGN KEY ( maquina_nombre )
        REFERENCES maquinas ( nombre );

ALTER TABLE habitaciones
    ADD CONSTRAINT habs_tipo_habitacion_fk FOREIGN KEY ( tipo )
        REFERENCES tipos_habitacion ( nombre );

ALTER TABLE indumentarias
    ADD CONSTRAINT indumentarias_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE ocupaciones
    ADD CONSTRAINT ocp_estancia_fk FOREIGN KEY ( estancia_id )
        REFERENCES estancias ( id );

ALTER TABLE ocupaciones
    ADD CONSTRAINT ocp_habitacion_fk FOREIGN KEY ( habitacion_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE planes_de_consumo
    ADD CONSTRAINT plc_consumo_vigencias_fk FOREIGN KEY ( vigencia_id )
        REFERENCES vigencias ( id );

ALTER TABLE planes_de_consumo
    ADD CONSTRAINT plc_restriccion_dias_fk FOREIGN KEY ( restriccion_id )
        REFERENCES restriccion_dias ( id );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE productos_incluidos
    ADD CONSTRAINT prod_incl_plc_fk FOREIGN KEY ( plan_de_consumo )
        REFERENCES planes_de_consumo ( nombre );

ALTER TABLE productos_incluidos
    ADD CONSTRAINT prod_incl_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( item_id );

ALTER TABLE productos
    ADD CONSTRAINT prod_item_fk FOREIGN KEY ( item_id )
        REFERENCES items ( id );

ALTER TABLE psicinas
    ADD CONSTRAINT psicinas_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE reservas_estancias
    ADD CONSTRAINT reservas_estancias_usuarios_fk FOREIGN KEY ( cliente )
        REFERENCES usuarios ( documento );

ALTER TABLE restaurante_prods
    ADD CONSTRAINT rest_prods_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( item_id );

ALTER TABLE restaurante_prods
    ADD CONSTRAINT rest_prods_restaurante_fk FOREIGN KEY ( restaurante_id )
        REFERENCES restaurantes ( servicio_id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT resv_sev_habitacion_fk FOREIGN KEY ( numero_habitacion )
        REFERENCES habitaciones ( numero );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT resv_sev_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE rev_sev_items
    ADD CONSTRAINT revsev_items_items_fk FOREIGN KEY ( item_id )
        REFERENCES items ( id );

ALTER TABLE rev_sev_items
    ADD CONSTRAINT revsev_items_servicio_fk FOREIGN KEY ( numero_habitacion,
                                                          servicio_id,
                                                          reserva_fecha )
        REFERENCES reservas_servicios ( numero_habitacion,
                                        servicio_id,
                                        fecha );

ALTER TABLE reserva_habs
    ADD CONSTRAINT rsv_habitacion_fk FOREIGN KEY ( habitacion_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE reserva_habs
    ADD CONSTRAINT rsv_reserva_fk FOREIGN KEY ( reserva_id )
        REFERENCES reservas_estancias ( id );

ALTER TABLE salones
    ADD CONSTRAINT salones_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE servicios_incluidos
    ADD CONSTRAINT ser_inc_plc_fk FOREIGN KEY ( plan_de_consumo )
        REFERENCES planes_de_consumo ( nombre );

ALTER TABLE servicios_incluidos
    ADD CONSTRAINT ser_incl_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE servicios_spa
    ADD CONSTRAINT spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( servicio_id );

ALTER TABLE servicios_spa
    ADD CONSTRAINT spa_items_fk FOREIGN KEY ( items_id )
        REFERENCES items ( id );

ALTER TABLE spa
    ADD CONSTRAINT spa_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE tiendas_productos
    ADD CONSTRAINT tiendas_prod_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( item_id );

ALTER TABLE tiendas_productos
    ADD CONSTRAINT tiendas_prod_tienda_fk FOREIGN KEY ( tienda_id )
        REFERENCES tiendas ( servicio_id );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_roles_fk FOREIGN KEY ( rol )
        REFERENCES roles ( nombre );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            38
-- CREATE INDEX                             2
-- ALTER TABLE                             87
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
