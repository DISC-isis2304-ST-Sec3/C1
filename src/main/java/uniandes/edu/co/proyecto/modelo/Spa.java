package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name="spa")
public class Spa extends Servicio {

    private Integer capacidad;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private Integer franja;

    public Spa(Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, Integer franja) {
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.franja = franja;
    }

    public Spa()
    {;}

    public Integer getCapacidad() {
        return capacidad;
    }

    public LocalDateTime getApertura() {
        return apertura;
    }

    public LocalDateTime getCierre() {
        return cierre;
    }

    public Integer getFranja() {
        return franja;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }

    public void setFranja(Integer franja) {
        this.franja = franja;
    }

    

    

}
