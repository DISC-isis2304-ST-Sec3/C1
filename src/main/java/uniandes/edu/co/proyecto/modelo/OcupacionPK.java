package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//relacion entre habitacion y estancia
@Embeddable
public class OcupacionPK {
    @ManyToOne
    @JoinColumn(name="numero_habitacion", referencedColumnName="numero")
    private Habitacion numeroHabitacion;
    
    @ManyToOne
    @JoinColumn(name="idEstancia", referencedColumnName="id")
    private Estancia idEstancia;

    public OcupacionPK(Habitacion numeroHabitacion, Estancia idEstancia) {
        super();
        this.numeroHabitacion = numeroHabitacion;
        this.idEstancia = idEstancia;
    }

    public Habitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Habitacion numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Estancia getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(Estancia idEstancia) {
        this.idEstancia = idEstancia;
    }

    
}
