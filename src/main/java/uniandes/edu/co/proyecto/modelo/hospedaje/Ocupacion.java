package uniandes.edu.co.proyecto.modelo.hospedaje;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocupaciones")
public class Ocupacion {
    private LocalDateTime fecha;
    @EmbeddedId
    private OcupacionPK pk;

    public Ocupacion(Habitacion habitacion, Estancia estancia, LocalDateTime fecha){
        this.pk = new OcupacionPK(habitacion, estancia);
        this.fecha = fecha;
    }
    public Ocupacion() {

    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public OcupacionPK getPk() {
        return pk;
    }
    public void setPk(OcupacionPK pk) {
        this.pk = pk;
    }


}
