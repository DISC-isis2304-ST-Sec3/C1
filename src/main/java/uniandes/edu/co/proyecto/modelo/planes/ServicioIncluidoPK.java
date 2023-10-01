package uniandes.edu.co.proyecto.modelo.planes;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServicioIncluidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="servicios_id", referencedColumnName="id")
    private Servicio servicio;
    
    @ManyToOne
    @JoinColumn(name="plan_de_consumo", referencedColumnName="nombre")
    private PlanDeConsumo planDeConsumo;

    public ServicioIncluidoPK(Servicio servicio, PlanDeConsumo planDeConsumo) {
        this.servicio = servicio;
        this.planDeConsumo = planDeConsumo;
    }

    public ServicioIncluidoPK() {

    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
        ServicioIncluidoPK that = (ServicioIncluidoPK) o;
        return Objects.equals(servicio, that.servicio) && Objects.equals(planDeConsumo, that.planDeConsumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicio, planDeConsumo);
    }
}
