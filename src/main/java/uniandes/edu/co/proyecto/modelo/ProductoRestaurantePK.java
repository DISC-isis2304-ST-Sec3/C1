package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre producto y restaurante
@Embeddable
public class ProductoRestaurantePK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName="id")
    private Producto idProducto;
    
    @ManyToOne
    @JoinColumn(name="id_restaurante", referencedColumnName="id")
    private Restaurante idRestaurante;

    public ProductoRestaurantePK(Producto idProducto, Restaurante idRestaurante) {
        super();
        this.idProducto = idProducto;
        this.idRestaurante = idRestaurante;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Restaurante getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Restaurante idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    
    
}
