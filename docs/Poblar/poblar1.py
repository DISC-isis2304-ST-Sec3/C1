import random
from faker import Faker
from datetime import datetime, timedelta

fake = Faker()

tipos_doc = ['CE', 'CC', 'TI']
tipos_hab = ['suite', 'familiar', 'doble']

archivo = open("./Scripts/poblarNuevo.sql", "w")

for _ in range(750000):
    tipo_doc = random.choice(tipos_doc)
    tipo_hab = random.choice(tipos_hab)
    num_doc = random.randint(10000000, 99999999)
    precio_hab = random.randint(100000, 9999999)
    capacidad = random.randint(1, 10)
    nombre = fake.name()
    correo = fake.email()

    fecha_in = fake.date_this_decade(before_today=True)
    dias_rand = random.randint(1, 50)
    fecha_out = fecha_in + timedelta(days=dias_rand)
    fecha_in = fecha_in.strftime('%Y-%m-%d')
    fecha_out = fecha_out.strftime('%Y-%m-%d')

    archivo.write(f"INSERT INTO InformacionClientes(tipo_documento, num_documento, nombre, correo) VALUES ('{tipo_doc}', {num_doc}, '{nombre}', '{correo}');\n")
    archivo.write(f"INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo) VALUES ('{tipo_doc}', {num_doc}, '{nombre}', '{correo}', 'cliente');\n")
    archivo.write(f"INSERT INTO Reservas (fecha_inicio, fecha_salida, num_personas, Usuarios_tipo_documento, Usuarios_num_documento, Usuarios_nombre, Usuarios_correo, PlanesConsumo_id) VALUES (TO_DATE('{fecha_in}','YYYY-MM-DD'),TO_DATE('{fecha_out}','YYYY-MM-DD'), 2, '{tipo_doc}',{num_doc},'{nombre}','{correo}', 1);\n")
    archivo.write(f"INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo) VALUES ({capacidad}, {precio_hab}, '{tipo_hab}');\n")
    archivo.write(f"INSERT INTO Reservan (Habitaciones_id, Reservas_id) VALUES ({_+1},(select id from reservas where usuarios_num_documento = {num_doc} fetch first 1 row only));\n")
    archivo.write(f"INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso) VALUES ((select id from reservas where usuarios_num_documento = {num_doc} fetch first 1 row only),{num_doc}, '{tipo_doc}',TO_DATE('{fecha_in}','YYYY-MM-DD'));\n")

archivo.close()
print(">> Archivo generado con éxito")




