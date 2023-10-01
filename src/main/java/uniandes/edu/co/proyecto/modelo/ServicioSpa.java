package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio_spa")
public class ServicioSpa {
    private Integer duracion;
    @EmbeddedId
    private ServicioSpaPK pk;
    public ServicioSpa(Spa idSpa, Item idItem, Integer duracion){
        this.pk = new ServicioSpaPK(idSpa, idItem);
        this.duracion = duracion;
    }
    public ServicioSpa()
    {;}
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public ServicioSpaPK getPk() {
        return pk;
    }
    public void setPk(ServicioSpaPK pk) {
        this.pk = pk;
    }

    
}
