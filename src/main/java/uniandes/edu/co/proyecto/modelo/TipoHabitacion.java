package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tipo_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    private Double precioBase;
    private Integer capacidad;

    // private List< Dotaciones > dotaciones = new ArrayList<Dotaciones>() ;

    public TipoHabitacion(Double precioBase, Integer capacidad) {
        this.precioBase = precioBase;
        this.capacidad = capacidad;
        // this.dotaciones = dotaciones;
    }

    public TipoHabitacion()
    {;}

    public String getNombre() {
        return nombre;
    }
    public Double getPrecioBase() {
        return precioBase;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    // public List<Dotaciones> getDotaciones() {
    //     return dotaciones;
    // }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    // public void setDotaciones(List<Dotaciones> dotaciones) {
    //     this.dotaciones = dotaciones;
    // }



}
