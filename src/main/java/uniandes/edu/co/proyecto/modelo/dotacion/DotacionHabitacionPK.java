package uniandes.edu.co.proyecto.modelo.dotacion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.hospedaje.TipoHabitacion;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DotacionHabitacionPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="tipo_habitacion", referencedColumnName="nombre")
    private TipoHabitacion nombreTipoHabitacion;

    @ManyToOne
    @JoinColumn(name="dotacion", referencedColumnName="nombre")
    private Dotacion nombreDotacion;

    public DotacionHabitacionPK(TipoHabitacion nombreTipoHabitacion, Dotacion nombreDotacion) {
        super();
        this.nombreTipoHabitacion = nombreTipoHabitacion;
        this.nombreDotacion = nombreDotacion;
    }

    public DotacionHabitacionPK() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DotacionHabitacionPK that = (DotacionHabitacionPK) o;
        return Objects.equals(nombreTipoHabitacion, that.nombreTipoHabitacion) && Objects.equals(nombreDotacion, that.nombreDotacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreTipoHabitacion, nombreDotacion);
    }
}