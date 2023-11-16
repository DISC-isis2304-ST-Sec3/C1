package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("reservas")
public class Reserva {

    @Id
    private String id;

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int numeroPersonas;
    private ObjectId habitacion;

    @DBRef
    private Cliente responsable;

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, int numeroPersonas, ObjectId habitacion,
            Cliente responsable) {
        super();
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroPersonas = numeroPersonas;
        this.habitacion = habitacion;
        this.responsable = responsable;
    }

    public Reserva() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public ObjectId getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getResponsable() {
        return responsable;
    }

    public void setResponsable(Cliente responsable) {
        this.responsable = responsable;
    }

}
