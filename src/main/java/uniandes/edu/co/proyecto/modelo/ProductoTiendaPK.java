package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre producto y tienda
@Embeddable
public class ProductoTiendaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName="id")
    private Producto idProducto;
    
    @ManyToOne
    @JoinColumn(name="id_tienda", referencedColumnName="id")
    private Tienda idTienda;

    public ProductoTiendaPK(Producto idProducto, Tienda idTienda) {
        super();
        this.idProducto = idProducto;
        this.idTienda = idTienda;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Tienda idTienda) {
        this.idTienda = idTienda;
    }

    
}
