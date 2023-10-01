package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dotaciones")
public class Dotacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;

    private Double valorAgregado;

    public Dotacion(Double valorAgregado) {
        this.valorAgregado = valorAgregado;
    }

    public Dotacion() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public Double getValorAgregado() {
        return valorAgregado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValorAgregado(Double valorAgregado) {
        this.valorAgregado = valorAgregado;
    }

    

}