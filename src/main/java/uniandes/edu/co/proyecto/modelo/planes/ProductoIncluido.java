package uniandes.edu.co.proyecto.modelo.planes;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Entity
@Table(name="productos_incluidos")
public class ProductoIncluido {
    private Integer cantidad;
    @EmbeddedId
    private ProductoIncluidoPK pk;

    public ProductoIncluido(Producto producto, PlanDeConsumo planDeConsumo, Integer cantidad){
        this.pk = new ProductoIncluidoPK(producto, planDeConsumo);
        this.cantidad = cantidad;
    }
    public ProductoIncluido() {

    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public ProductoIncluidoPK getPk() {
        return pk;
    }
    public void setPk(ProductoIncluidoPK pk) {
        this.pk = pk;
    }

    
    
}
