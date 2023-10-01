package uniandes.edu.co.proyecto.modelo.planes;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Entity
@Table(name = "servicios_incluidos")
public class ServicioIncluido {
    private Double descuento;
    @EmbeddedId
    private ServicioIncluidoPK pk;

    public ServicioIncluido(Servicio servicio, PlanDeConsumo planDeConsumo, Double descuento){
        this.pk = new ServicioIncluidoPK(servicio, planDeConsumo);
        this.descuento = descuento;
    }

    public ServicioIncluido() {

    }

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
