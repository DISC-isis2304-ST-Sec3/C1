package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre producto y bar
@Embeddable
public class ProductoBarPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName="id")
    private Producto idProducto;
    
    @ManyToOne
    @JoinColumn(name="id_bar", referencedColumnName="id")
    private Bar idBar;

    public ProductoBarPK(Producto idProducto, Bar idBar) {
        super();
        this.idProducto = idProducto;
        this.idBar = idBar;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Bar getIdBar() {
        return idBar;
    }

    public void setIdBar(Bar idBar) {
        this.idBar = idBar;
    }
    
    
}
