package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasios")
public class Gimnasio extends Servicio{
    private Integer capacidad;
    private LocalDateTime apertura; //revisar tipo de dato
    private LocalDateTime cierre;
    private double valor;

    public Gimnasio(String nombre, Integer capacidad, LocalDateTime apertura, LocalDateTime cierre, Double valor) {
        super(nombre);
        this.cierre = cierre;
        this.apertura = apertura;
        this.valor = valor;
        this.capacidad = capacidad;
    }
    public Gimnasio()
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
    public Double getValor() {
        return valor;
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
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
