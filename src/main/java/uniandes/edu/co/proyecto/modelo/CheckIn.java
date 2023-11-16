package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("checkIn")
public class CheckIn {

    private ObjectId reserva;
    private ObjectId cliente;
    private String fechaIngreso;

    public CheckIn(ObjectId reserva, ObjectId cliente, String fechaIngreso) {
        super();
        this.reserva = reserva;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
    }

    public CheckIn() {
        super();
    }

    public ObjectId getReserva() {
        return reserva;
    }

    public void setReserva(ObjectId reserva) {
        this.reserva = reserva;
    }

    public ObjectId getCliente() {
        return cliente;
    }

    public void setCliente(ObjectId cliente) {
        this.cliente = cliente;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
