package uniandes.edu.co.proyecto.modelo.bar;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Entity
@Table(name = "bares_productos")
public class BarProductos {
    @EmbeddedId
    private BarProductosPK pk;

    public BarProductos(Producto producto, Bar bar){

        this.pk = new BarProductosPK(producto, bar);
    }

    public BarProductos() {

    }

    public BarProductosPK getPk() {
        return pk;
    }
    public void setPk(BarProductosPK pk) {
        this.pk = pk;
    }
    
}
