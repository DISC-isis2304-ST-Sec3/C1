package uniandes.edu.co.proyecto.modelo.servicios;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscinas")
public class Piscina{

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private DecimalFormat valor;
    private Double profundidad;

    public Piscina(Integer servicioId, Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, DecimalFormat valor, Double profundidad) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.valor = valor;
        this.profundidad = profundidad;
    }

    public Piscina() {
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

    public DecimalFormat getValor() {
        return valor;
    }

    public void setValor(DecimalFormat valor) {
        this.valor = valor;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Double profundidad) {
        this.profundidad = profundidad;
    }
}
