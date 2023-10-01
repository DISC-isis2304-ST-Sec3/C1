package uniandes.edu.co.proyecto.modelo.planes;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Producto;

@Embeddable
public class ProductoIncluidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="producto_id", referencedColumnName="item_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name="plan_de_consumo", referencedColumnName="nombre")
    private PlanDeConsumo planDeConsumo;

    public ProductoIncluidoPK(Producto producto, PlanDeConsumo planDeConsumo) {
        this.producto = producto;
        this.planDeConsumo = planDeConsumo;
    }

    public ProductoIncluidoPK() {

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public PlanDeConsumo getPlanDeConsumo() {
        return planDeConsumo;
    }

    public void setPlanDeConsumo(PlanDeConsumo planDeConsumo) {
        this.planDeConsumo = planDeConsumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoIncluidoPK that = (ProductoIncluidoPK) o;
        return Objects.equals(producto, that.producto) && Objects.equals(planDeConsumo, that.planDeConsumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, planDeConsumo);
    }
}
