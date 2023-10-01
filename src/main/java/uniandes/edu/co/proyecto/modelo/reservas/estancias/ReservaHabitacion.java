package uniandes.edu.co.proyecto.modelo.reservas.estancias;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;

@Entity
@Table(name="reserva_habs")
public class ReservaHabitacion {

    @EmbeddedId
    private ReservaHabitacionPK pk;

    public ReservaHabitacion(ReservaEstancia reservaEstancia, Habitacion habitacion) {
        this.pk = new ReservaHabitacionPK(reservaEstancia, habitacion);
    }

    public ReservaHabitacion() {

    }

    public ReservaHabitacionPK getPk() {
        return pk;
    }

    public void setPk(ReservaHabitacionPK pk) {
        this.pk = pk;
    }
}
