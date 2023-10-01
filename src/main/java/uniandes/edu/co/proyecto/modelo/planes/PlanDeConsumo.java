package uniandes.edu.co.proyecto.modelo.planes;

import jakarta.persistence.*;

@Entity
@Table(name="planes_de_consumo")
public class PlanDeConsumo {
    
    @Id
    private String nombre;
    private Double descuento;
    private Integer minimasNoches;
    private Double valor;

    @ManyToOne
    @JoinColumn(name="vigencia_id", referencedColumnName="id")
    private Vigencia vigencia;

    @ManyToOne
    @JoinColumn(name="restriccion_id", referencedColumnName="id")
    private RestriccionDia restriccion;

    public PlanDeConsumo(String nombre, Double descuento, Integer minimasNoches, Double valor) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.minimasNoches = minimasNoches;
        this.valor = valor;
    }

    public PlanDeConsumo() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getMinimasNoches() {
        return minimasNoches;
    }

    public void setMinimasNoches(Integer minimasNoches) {
        this.minimasNoches = minimasNoches;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
