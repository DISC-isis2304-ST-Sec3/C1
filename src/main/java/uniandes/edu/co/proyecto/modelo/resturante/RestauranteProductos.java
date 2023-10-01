package uniandes.edu.co.proyecto.modelo.resturante;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Entity
@Table(name = "restaurante_prods")
public class RestauranteProductos {
    @EmbeddedId
    private RestauranteProductosPK pk;

    public RestauranteProductos(Producto producto, Restaurante restaurante){
        this.pk = new RestauranteProductosPK(producto, restaurante);
    }
    public RestauranteProductos() {}
    public RestauranteProductosPK getPk() {
        return pk;
    }
    public void setPk(RestauranteProductosPK pk) {
        this.pk = pk;
    }
    
}
