package uniandes.edu.co.proyecto.modelo.reservas.estancias;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaHabitacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "reserva_id", referencedColumnName = "id")
    private ReservaEstancia reserva;

    @ManyToOne
    @JoinColumn(name = "habitacion_numero", referencedColumnName = "numero")
    private Habitacion habitacion;

    public ReservaHabitacionPK(ReservaEstancia reserva, Habitacion habitacion) {
        this.reserva = reserva;
        this.habitacion = habitacion;
    }

    public ReservaHabitacionPK() {
    }

    public ReservaEstancia getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEstancia reserva) {
        this.reserva = reserva;
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
        ReservaHabitacionPK that = (ReservaHabitacionPK) o;
        return Objects.equals(reserva, that.reserva) && Objects.equals(habitacion, that.habitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserva, habitacion);
    }
}
