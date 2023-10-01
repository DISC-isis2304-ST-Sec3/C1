package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
//relacion entre servicio y plan de consumo
@Embeddable
public class ServicioIncluidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_servicio", referencedColumnName="id")
    private Servicio idServicio;
    
    @ManyToOne
    @JoinColumn(name="nombre_plan_de_consumo", referencedColumnName="nombre")
    private PlanDeConsumo nombrePlanDeConsumo;

    public ServicioIncluidoPK(Servicio idServicio, PlanDeConsumo nombrePlanDeConsumo) {
        super();
        this.idServicio = idServicio;
        this.nombrePlanDeConsumo = nombrePlanDeConsumo;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public PlanDeConsumo getNombrePlanDeConsumo() {
        return nombrePlanDeConsumo;
    }

    public void setNombrePlanDeConsumo(PlanDeConsumo nombrePlanDeConsumo) {
        this.nombrePlanDeConsumo = nombrePlanDeConsumo;
    }
    
}
