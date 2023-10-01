package uniandes.edu.co.proyecto.modelo.tienda;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Embeddable
public class TiendaProductoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="producto_id", referencedColumnName="item_id")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="tienda_id", referencedColumnName="servicio_id")
    private Tienda tienda;

    public TiendaProductoPK(Producto producto, Tienda tienda) {
        this.producto = producto;
        this.tienda = tienda;
    }

    public TiendaProductoPK() {

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiendaProductoPK that = (TiendaProductoPK) o;
        return Objects.equals(producto, that.producto) && Objects.equals(tienda, that.tienda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, tienda);
    }
}
