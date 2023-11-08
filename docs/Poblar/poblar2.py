import random
from faker import Faker
from datetime import datetime, timedelta, time

fake = Faker()

tipos_servicio = ['spa', 'bar', 'internet', 'lavadoSecadoEmbolado', 'prestamo', 'restaurante', 'salon', 'supermercado', 'tienda']

archivo = open("./Scripts/poblarNuevo2.sql", "w")

for _ in range(300000):

    id_hab = random.randint(1, 45000)
    servicio = random.choice(tipos_servicio)
    descripcion = fake.text(max_nb_chars=200)
    costo = random.randint(2500, 10000000)
    duracion = random.randint(1, 8)

    dia = fake.date_this_decade(before_today=True)
    hora_aleatoria = time(random.randint(8, 21), random.randint(0, 59), 0)
    hora = hora_aleatoria.strftime('%H:%M:%S')

    archivo.write(f"INSERT INTO Consumos (Habitaciones_id, TiposServicio_tipo, descripcion, costo) VALUES ({id_hab}, '{servicio}', '{descripcion}', {costo});\n")

    if servicio in ['spa', 'salon']:
        archivo.write(f"INSERT INTO ReservasServicio (duracion_hora, dia, hora, Habitaciones_id) VALUES ({duracion}, TO_DATE('{dia}','YYYY-MM-DD'),'{hora}',{id_hab});\n")

archivo.close()
print(">> Archivo generado con éxito")




