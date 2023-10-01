package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//relacion entre TIPOHABITACION y DOTACION
@Embeddable
public class DotacionTipoHabitacionPK {
    @ManyToOne
    @JoinColumn(name="nombre_tipo_habitacion", referencedColumnName="nombre")
    private TipoHabitacion nombreTipoHabitacion;
    
    @ManyToOne
    @JoinColumn(name="nombre_dotacion", referencedColumnName="nombre")
    private Dotacion nombreDotacion;

    public DotacionTipoHabitacionPK(TipoHabitacion nombreTipoHabitacion, Dotacion nombreDotacion) {
        super();
        this.nombreTipoHabitacion = nombreTipoHabitacion;
        this.nombreDotacion = nombreDotacion;
    }

    public TipoHabitacion getNombreTipoHabitacion() {
        return nombreTipoHabitacion;
    }

    public void setNombreTipoHabitacion(TipoHabitacion nombreTipoHabitacion) {
        this.nombreTipoHabitacion = nombreTipoHabitacion;
    }

    public Dotacion getNombreDotacion() {
        return nombreDotacion;
    }

    public void setNombreDotacion(Dotacion nombreDotacion) {
        this.nombreDotacion = nombreDotacion;
    }
    
}
