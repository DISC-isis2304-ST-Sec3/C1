package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios_incluidos")
public class ServicioIncluido {
    private double descuento;
    @EmbeddedId
    private ServicioIncluidoPK pk;
    public ServicioIncluido(Servicio idServicio, PlanDeConsumo nombrePlanDeConsumo, double descuento){
        this.pk = new ServicioIncluidoPK(idServicio, nombrePlanDeConsumo);
        this.descuento = descuento;
    }
    public ServicioIncluido()
    {;}
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public ServicioIncluidoPK getPk() {
        return pk;
    }
    public void setPk(ServicioIncluidoPK pk) {
        this.pk = pk;
    }

}
