package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("habitaciones")
public class Habitacion {

    @Id
    private String id;

    private int numero;
    private int capacidad;
    private int costo;

    @DBRef
    private TipoHabitacion tipo;
    @DBRef
    private List<Consumo> consumos;

    public Habitacion(int numero, int capacidad, int costo, TipoHabitacion tipo, List<Consumo> consumos) {
        super();
        this.numero = numero;
        this.capacidad = capacidad;
        this.costo = costo;
        this.tipo = tipo;
        this.consumos = consumos;
    }

    public Habitacion() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

}
