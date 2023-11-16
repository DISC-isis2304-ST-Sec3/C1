package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reservas")
public class Reserva {

    private String fechaEntrada;
    private String fechaSalida;
    private int numeroPersonas;
    private ObjectId habitacion;

    @DBRef
    private Cliente responsable;

    public Reserva(String fechaEntrada, String fechaSalida, int numeroPersonas, ObjectId habitacion,
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
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
