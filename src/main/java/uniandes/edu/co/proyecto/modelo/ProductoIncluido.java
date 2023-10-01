package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_incluidos")
public class ProductoIncluido {
    private Integer cantidad;
    @EmbeddedId
    private ProductoIncluidoPK pk;
    public ProductoIncluido(Producto idProducto, PlanDeConsumo nombrePlanDeConsumo, Integer cantidad){
        this.pk = new ProductoIncluidoPK(idProducto, nombrePlanDeConsumo);
        this.cantidad = cantidad;
    }
    public ProductoIncluido()
    {;}
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
