package uniandes.edu.co.proyecto.modelo.planes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="vigencias")
public class Vigencia {
    
    @Id
    private Integer id;
    @Column(name = "inicio")
    private LocalDateTime fechaInicio;
    @Column(name = "final")
    private LocalDateTime fechaFinal;

    public Vigencia(Integer id, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Vigencia() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
