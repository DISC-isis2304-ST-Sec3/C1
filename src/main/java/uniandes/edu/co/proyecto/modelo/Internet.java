package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "internet")
public class Internet extends Servicio {
    private double capacidad;
    private double valorPorDia;
    private LocalDateTime inicia;
    private LocalDateTime finaliza;

    public Internet(String nombre, double capacidad, double valorPorDia, LocalDateTime inicia, LocalDateTime finaliza) {
        super(nombre);
        this.capacidad = capacidad;
        this.valorPorDia = valorPorDia;
        this.inicia = inicia;
        this.finaliza = finaliza;
    }

    public Internet() 
    {;}

    public double getCapacidad() {
        return capacidad;
    }

    public double getValorPorDia() {
        return valorPorDia;
    }

    public LocalDateTime getInicia() {
        return inicia;
    }

    public LocalDateTime getFinaliza() {
        return finaliza;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public void setValorPorDia(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    public void setInicia(LocalDateTime inicia) {
        this.inicia = inicia;
    }

    public void setFinaliza(LocalDateTime finaliza) {
        this.finaliza = finaliza;
    }
    


}
