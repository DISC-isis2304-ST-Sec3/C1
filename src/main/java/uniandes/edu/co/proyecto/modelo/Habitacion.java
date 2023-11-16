package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("habitaciones")
public class Habitacion {

    private int numero;
    private int capacidad;
    private double costo;

    @DBRef
    private TipoHabitacion tipo;

    public Habitacion(int numero, int capacidad, double costo, TipoHabitacion tipo) {
        super();
        this.numero = numero;
        this.capacidad = capacidad;
        this.costo = costo;
        this.tipo = tipo;
    }

    public Habitacion() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

}
