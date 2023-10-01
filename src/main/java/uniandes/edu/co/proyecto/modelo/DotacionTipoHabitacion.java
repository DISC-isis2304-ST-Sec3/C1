package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dotaciones_tipo_habitacion")
public class DotacionTipoHabitacion {
    @EmbeddedId
    private DotacionTipoHabitacionPK pk;
    public DotacionTipoHabitacion(TipoHabitacion nombreTipoHabitacion, Dotacion nombreDotacion){
        this.pk = new DotacionTipoHabitacionPK(nombreTipoHabitacion, nombreDotacion);
    }
    public DotacionTipoHabitacion()
    {;}
}
