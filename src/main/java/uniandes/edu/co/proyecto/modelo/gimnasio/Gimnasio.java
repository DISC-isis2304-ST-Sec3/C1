package uniandes.edu.co.proyecto.modelo.gimnasio;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Entity
@Table(name = "gimnasios")
public class Gimnasio {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private Double valor;

    public Gimnasio(Integer servicioId, Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, Double valor) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.valor = valor;
    }

    public Gimnasio() {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
