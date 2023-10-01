package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas_servicios")
public class ReservaServicio {
    private LocalDateTime fecha;
    private Integer duracion;
    @EmbeddedId
    private ReservaServicioPK pk;
    public ReservaServicio(Servicio idServicio, Habitacion numeroHabitacion, LocalDateTime fecha, Integer duracion){
        this.pk = new ReservaServicioPK(idServicio, numeroHabitacion);
        this.fecha = fecha;
        this.duracion = duracion;
    }
    public ReservaServicio()
    {;}
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public ReservaServicioPK getPk() {
        return pk;
    }
    public void setPk(ReservaServicioPK pk) {
        this.pk = pk;
    }

    
}
