package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_restaurantes")
public class ProductoRestaurante {
    @EmbeddedId
    private ProductoRestaurantePK pk;
    public ProductoRestaurante(Producto idProducto, Restaurante idRestaurante){
        this.pk = new ProductoRestaurantePK(idProducto, idRestaurante);
    }
    public ProductoRestaurante()
    {;}
    public ProductoRestaurantePK getPk() {
        return pk;
    }
    public void setPk(ProductoRestaurantePK pk) {
        this.pk = pk;
    }
    
}
