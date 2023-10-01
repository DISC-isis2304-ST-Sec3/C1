package uniandes.edu.co.proyecto.modelo.servicios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.time.LocalDateTime;

@Entity
@Table(name = "internet")
public class Internet {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private double capacidad;
    private double valorPorDia;
    private LocalDateTime inicia;
    private LocalDateTime finaliza;

    public Internet(Integer servicioId, double capacidad, double valorPorDia, LocalDateTime inicia, LocalDateTime finaliza) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.valorPorDia = valorPorDia;
        this.inicia = inicia;
        this.finaliza = finaliza;
    }

    public Internet() {
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getValorPorDia() {
        return valorPorDia;
    }

    public void setValorPorDia(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    public LocalDateTime getInicia() {
        return inicia;
    }

    public void setInicia(LocalDateTime inicia) {
        this.inicia = inicia;
    }

    public LocalDateTime getFinaliza() {
        return finaliza;
    }

    public void setFinaliza(LocalDateTime finaliza) {
        this.finaliza = finaliza;
    }
}
