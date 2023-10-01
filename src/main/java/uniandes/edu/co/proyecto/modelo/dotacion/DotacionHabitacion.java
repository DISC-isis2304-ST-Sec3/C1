package uniandes.edu.co.proyecto.modelo.dotacion;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.DotacionHabitacionPK;
import uniandes.edu.co.proyecto.modelo.hospedaje.TipoHabitacion;

@Entity
@Table(name = "dotacion_habitacion")
public class DotacionHabitacion {
    @EmbeddedId
    private DotacionHabitacionPK pk;

    public DotacionHabitacion(TipoHabitacion nombreTipoHabitacion, Dotacion nombreDotacion){
        this.pk = new DotacionHabitacionPK(nombreTipoHabitacion, nombreDotacion);
    }

    public DotacionHabitacion() {

    }
}
