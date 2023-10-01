package uniandes.edu.co.proyecto.modelo.bar;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Producto;


@Embeddable
public class BarProductosPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="producto_id", referencedColumnName="item_id")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="bar_id", referencedColumnName="servicio_id")
    private Bar bar;

    public BarProductosPK(Producto producto, Bar bar) {
        this.producto = producto;
        this.bar = bar;
    }

    public BarProductosPK() {

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarProductosPK that = (BarProductosPK) o;
        return Objects.equals(producto, that.producto) && Objects.equals(bar, that.bar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, bar);
    }
}
