package uniandes.edu.co.proyecto.modelo.spa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.time.LocalDateTime;


@Entity
@Table(name="spa")
public class Spa {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private Integer franja;

    public Spa(Integer servicioId, Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, Integer franja) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.franja = franja;
    }

    public Spa() {
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDateTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    public LocalDateTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }

    public Integer getFranja() {
        return franja;
    }

    public void setFranja(Integer franja) {
        this.franja = franja;
    }
}
