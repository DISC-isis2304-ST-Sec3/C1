package uniandes.edu.co.proyecto.modelo.servicios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "indumentarias")
public class Indumentaria {

    @Id
    private Integer id;
    private Integer elementos;
    private double valorBase;
    private double valorElemento;

    @Column(name = "servicio_id")
    private Integer servicioId;

    public Indumentaria(Integer id, Integer elementos, double valorBase, double valorElemento, Integer servicioId) {
        this.id = id;
        this.elementos = elementos;
        this.valorBase = valorBase;
        this.valorElemento = valorElemento;
        this.servicioId = servicioId;
    }

    public Indumentaria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getElementos() {
        return elementos;
    }

    public void setElementos(Integer elementos) {
        this.elementos = elementos;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorElemento() {
        return valorElemento;
    }

    public void setValorElemento(double valorElemento) {
        this.valorElemento = valorElemento;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }
}
