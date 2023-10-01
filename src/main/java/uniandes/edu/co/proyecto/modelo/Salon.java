package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
@Entity
@Table(name = "salones")
public class Salon extends Servicio{
    private Integer capacidad;
    private double costoHora;
    private Integer tiempoLimpieza;
    public enum TipoSalon{
        REUNION, CONFERENCIA
    }
    @Enumerated(EnumType.STRING)
    private TipoSalon tipoSalon;

    public Salon(String nombre, Integer capacidad, double costoHora, Integer tiempoLimpieza, TipoSalon tipoSalon) {
        super();
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.tiempoLimpieza = tiempoLimpieza;
        this.tipoSalon = tipoSalon;
    }

    public Salon()
    {;}

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
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
