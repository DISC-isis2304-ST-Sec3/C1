package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="vigencias")
public class Vigencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Vigencia(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Vigencia() 
    {;}

    public Integer getId() {
        return id;
    }
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    

}
