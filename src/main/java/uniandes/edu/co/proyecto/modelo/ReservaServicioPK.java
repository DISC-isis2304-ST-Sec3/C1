package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre servicio y habitacion *-*
@Embeddable
public class ReservaServicioPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_servicio", referencedColumnName="id")
    private Servicio idServicio;
    
    @ManyToOne
    @JoinColumn(name="numero_habitacion", referencedColumnName="numero")
    private Habitacion numeroHabitacion;

    public ReservaServicioPK(Servicio idServicio, Habitacion numeroHabitacion) {
        super();
        this.idServicio = idServicio;
        this.numeroHabitacion = numeroHabitacion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Habitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Habitacion numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    
    
}
