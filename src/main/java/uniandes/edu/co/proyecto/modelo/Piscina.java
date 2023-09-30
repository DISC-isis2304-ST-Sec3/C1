package uniandes.edu.co.proyecto.modelo;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscinas")
public class Piscina extends Servicio{
    private Integer capacidad;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private DecimalFormat valor;
    private Double profundidad;
    public Piscina(String nombre,Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, DecimalFormat valor, Double profundidad) {
        super(nombre);
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.valor = valor;
        this.profundidad = profundidad;
    }
    public Piscina()
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
    public DecimalFormat getValor() {
        return valor;
    }
    public Double getProfundidad() {
        return profundidad;
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
    public void setValor(DecimalFormat valor) {
        this.valor = valor;
    }
    public void setProfundidad(Double profundidad) {
        this.profundidad = profundidad;
    }
    

}
