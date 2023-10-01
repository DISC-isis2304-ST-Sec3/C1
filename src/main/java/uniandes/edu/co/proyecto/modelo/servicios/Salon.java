package uniandes.edu.co.proyecto.modelo.servicios;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Entity
@Table(name = "salones")
public class Salon {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private Double costoHora;
    private Integer tiempoLimpieza;

    public enum TipoSalon{REUNION, CONFERENCIA}
    private TipoSalon tipoSalon;

    public Salon(Integer servicioId, Integer capacidad, Double costoHora, Integer tiempoLimpieza, TipoSalon tipoSalon) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.tiempoLimpieza = tiempoLimpieza;
        this.tipoSalon = tipoSalon;
    }

    public Salon() {
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

    public Double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }

    public Integer getTiempoLimpieza() {
        return tiempoLimpieza;
    }

    public void setTiempoLimpieza(Integer tiempoLimpieza) {
        this.tiempoLimpieza = tiempoLimpieza;
    }

    public TipoSalon getTipoSalon() {
        return tipoSalon;
    }

    public void setTipoSalon(TipoSalon tipoSalon) {
        this.tipoSalon = tipoSalon;
    }
}
