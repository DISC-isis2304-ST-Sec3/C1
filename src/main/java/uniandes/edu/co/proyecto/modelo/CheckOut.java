package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("checkOut")
public class CheckOut {

    private ObjectId reserva;
    private ObjectId habitacion;
    private String fechaSalida;

    public CheckOut(ObjectId reserva, ObjectId habitacion, String fechaSalida) {
        super();
        this.reserva = reserva;
        this.habitacion = habitacion;
        this.fechaSalida = fechaSalida;
    }

    public CheckOut() {
        super();
    }

    public ObjectId getReserva() {
        return reserva;
    }

    public void setReserva(ObjectId reserva) {
        this.reserva = reserva;
    }

    public ObjectId getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
