package uniandes.edu.co.proyecto.modelo.dotacion;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dotaciones")
public class Dotacion {

    @Id
    private String nombre;

    private Double valorAgregado;

    public Dotacion(String nombre, Double valorAgregado) {
        this.nombre = nombre;
        this.valorAgregado = valorAgregado;
    }

    public Dotacion() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValorAgregado() {
        return valorAgregado;
    }

    public void setValorAgregado(Double valorAgregado) {
        this.valorAgregado = valorAgregado;
    }
}
