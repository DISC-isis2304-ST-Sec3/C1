package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre producto y plan de consumo
@Embeddable
public class ProductoIncluidoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName="id")
    private Producto idProducto;
    @ManyToOne
    @JoinColumn(name="nombre_plan_de_consumo", referencedColumnName="nombre")
    private PlanDeConsumo nombrePlanDeConsumo;

    public ProductoIncluidoPK(Producto idProducto, PlanDeConsumo nombrePlanDeConsumo) {
        super();
        this.idProducto = idProducto;
        this.nombrePlanDeConsumo = nombrePlanDeConsumo;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public PlanDeConsumo getNombrePlanDeConsumo() {
        return nombrePlanDeConsumo;
    }

    public void setNombrePlanDeConsumo(PlanDeConsumo nombrePlanDeConsumo) {
        this.nombrePlanDeConsumo = nombrePlanDeConsumo;
    }
    

}
