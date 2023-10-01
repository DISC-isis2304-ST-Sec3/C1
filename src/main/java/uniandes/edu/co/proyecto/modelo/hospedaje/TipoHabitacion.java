package uniandes.edu.co.proyecto.modelo.hospedaje;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.dotacion.Dotacion;

import java.util.List;


@Entity
@Table(name="tipos_habitacion")
public class TipoHabitacion {

    @Id
    private String nombre;
    private Double precioBase;
    private Integer capacidad;

    public TipoHabitacion(String nombre, Double precioBase, Integer capacidad) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.capacidad = capacidad;
    }

    public TipoHabitacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
