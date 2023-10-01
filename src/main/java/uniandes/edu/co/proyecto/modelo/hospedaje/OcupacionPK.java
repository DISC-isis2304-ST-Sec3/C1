package uniandes.edu.co.proyecto.modelo.hospedaje;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

//relacion entre habitacion y estancia
@Embeddable
public class OcupacionPK {
    @ManyToOne
    @JoinColumn(name="habitacion_numero", referencedColumnName="numero")
    private Habitacion habitacion;
    
    @ManyToOne
    @JoinColumn(name="estancia_id", referencedColumnName="id")
    private Estancia estancia;

    public OcupacionPK(Habitacion habitacion, Estancia estancia) {
        this.habitacion = habitacion;
        this.estancia = estancia;
    }

    public OcupacionPK() {
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Estancia getEstancia() {
        return estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OcupacionPK that = (OcupacionPK) o;
        return Objects.equals(habitacion, that.habitacion) && Objects.equals(estancia, that.estancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, estancia);
    }
}
