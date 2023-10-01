package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_bares")
public class ProductoBar {
    @EmbeddedId
    private ProductoBarPK pk;
    public ProductoBar(Producto idProducto, Bar idBar){
        this.pk = new ProductoBarPK(idProducto, idBar);
    }
    public ProductoBar()
    {;}
    public ProductoBarPK getPk() {
        return pk;
    }
    public void setPk(ProductoBarPK pk) {
        this.pk = pk;
    }
    
}
