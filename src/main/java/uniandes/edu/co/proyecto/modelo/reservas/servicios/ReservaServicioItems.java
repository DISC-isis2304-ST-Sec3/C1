package uniandes.edu.co.proyecto.modelo.reservas.servicios;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;
import uniandes.edu.co.proyecto.modelo.items.Item;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.time.LocalDateTime;

@Entity
@Table(name = "rev_sev_items")
public class ReservaServicioItems {

    private LocalDateTime fecha;

    @EmbeddedId
    private ReservaServicioItemPK pk;

    public ReservaServicioItems(LocalDateTime fecha, Item item, Habitacion habitacion, Servicio servicio) {
        this.fecha = fecha;
        this.pk = new ReservaServicioItemPK(item, habitacion, servicio);
    }

    public ReservaServicioItems() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public ReservaServicioItemPK getPk() {
        return pk;
    }

    public void setPk(ReservaServicioItemPK pk) {
        this.pk = pk;
    }
}
