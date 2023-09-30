package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="vigencias")
public class Vigencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Date fechaInicio;
    private Date fechaFin;

    public Vigencia(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Vigencia() 
    {;}

    public Integer getId() {
        return id;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    

}
