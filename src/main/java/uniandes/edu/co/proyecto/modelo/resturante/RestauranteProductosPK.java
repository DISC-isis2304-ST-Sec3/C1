package uniandes.edu.co.proyecto.modelo.resturante;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Embeddable
public class RestauranteProductosPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="producto_id", referencedColumnName="item_id")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name="restaurante_id", referencedColumnName="servicio_id")
    private Restaurante restaurante;

    public RestauranteProductosPK(Producto producto, Restaurante restaurante) {
        this.producto = producto;
        this.restaurante = restaurante;
    }

    public RestauranteProductosPK() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestauranteProductosPK that = (RestauranteProductosPK) o;
        return Objects.equals(producto, that.producto) && Objects.equals(restaurante, that.restaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, restaurante);
    }
}
