package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("checkIn")
public class CheckIn {

    @Id
    private String id;

    private ObjectId reserva;
    private ObjectId cliente;
    private LocalDate fechaIngreso;

    public CheckIn(ObjectId reserva, ObjectId cliente, LocalDate fechaIngreso) {
        super();
        this.reserva = reserva;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
    }

    public CheckIn() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
