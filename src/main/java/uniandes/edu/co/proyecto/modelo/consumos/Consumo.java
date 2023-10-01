package uniandes.edu.co.proyecto.modelo.consumos;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.hospedaje.Estancia;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.time.LocalDateTime;

@Entity
@Table(name="consumos")
public class Consumo {
    
    @Id
    private Integer id;
    private Double valorTotal;
    private LocalDateTime fecha;

    @OneToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicios;

    @OneToOne
    @JoinColumn(name = "estancia_id", referencedColumnName = "id")
    private Estancia estancia ;

    public Consumo(Integer id, Double valorTotal, LocalDateTime fecha, Servicio servicios, Estancia estancia) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.servicios = servicios;
        this.estancia = estancia;
    }

    public Consumo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Servicio getServicios() {
        return servicios;
    }

    public void setServicios(Servicio servicios) {
        this.servicios = servicios;
    }

    public Estancia getEstancia() {
        return estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }
}
