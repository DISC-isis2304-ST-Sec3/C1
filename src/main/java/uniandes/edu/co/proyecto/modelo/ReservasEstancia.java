package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="reservas_estancias")
public class ReservasEstancia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private String fechaInicio;
    private String fechaFin;
    private Integer cantidadHuespes;

    public ReservasEstancia(String fechaInicio, String fechaFin, Integer cantidadHuespes) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadHuespes = cantidadHuespes;
    }

    public ReservasEstancia() 
    {;}

    public Integer getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public Integer getCantidadHuespes() {
        return cantidadHuespes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCantidadHuespes(Integer cantidadHuespes) {
        this.cantidadHuespes = cantidadHuespes;
    }

    


}
