package uniandes.edu.co.proyecto.modelo.spa;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Item;

@Entity
@Table(name = "servicios_spa")
public class ServicioSpa {
    private Integer duracion;
    @EmbeddedId
    private ServicioSpaPK pk;

    public ServicioSpa(Spa spa, Item item, Integer duracion){
        this.pk = new ServicioSpaPK(spa, item);
        this.duracion = duracion;
    }

    public ServicioSpa() {

    }

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
