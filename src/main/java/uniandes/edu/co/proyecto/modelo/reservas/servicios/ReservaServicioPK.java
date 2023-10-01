package uniandes.edu.co.proyecto.modelo.reservas.servicios;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Embeddable
public class ReservaServicioPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="servicio_id", referencedColumnName="id")
    private Servicio servicio;
    
    @ManyToOne
    @JoinColumn(name="numero_habitacion", referencedColumnName="numero")
    private Habitacion habitacion;

    public ReservaServicioPK(Servicio servicio, Habitacion habitacion) {
        this.servicio = servicio;
        this.habitacion = habitacion;
    }

    public ReservaServicioPK() {

    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaServicioPK that = (ReservaServicioPK) o;
        return Objects.equals(servicio, that.servicio) && Objects.equals(habitacion, that.habitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicio, habitacion);
    }
}
