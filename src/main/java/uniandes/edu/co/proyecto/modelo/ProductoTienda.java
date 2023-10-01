package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_tiendas")
public class ProductoTienda {
    @EmbeddedId
    private ProductoTiendaPK pk;
    public ProductoTienda(Producto idProducto, Tienda idTienda){
        this.pk = new ProductoTiendaPK(idProducto, idTienda);
    }
    public ProductoTienda()
    {;}
}
