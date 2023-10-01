package uniandes.edu.co.proyecto.modelo.tienda;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Entity
@Table(name = "tiendas_productos")
public class TiendaProducto {
    @EmbeddedId
    private TiendaProductoPK pk;

    public TiendaProducto(Producto producto, Tienda tienda){
        this.pk = new TiendaProductoPK(producto, tienda);
    }
    public TiendaProducto() {
    }
}
