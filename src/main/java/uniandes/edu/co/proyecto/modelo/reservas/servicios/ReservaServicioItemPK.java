package uniandes.edu.co.proyecto.modelo.reservas.servicios;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.hospedaje.Habitacion;
import uniandes.edu.co.proyecto.modelo.items.Item;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaServicioItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "numero_habitacion", referencedColumnName = "numero")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    public ReservaServicioItemPK(Item item, Habitacion habitacion, Servicio servicio) {
        this.item = item;
        this.habitacion = habitacion;
        this.servicio = servicio;
    }

    public ReservaServicioItemPK() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaServicioItemPK that = (ReservaServicioItemPK) o;
        return Objects.equals(item, that.item) && Objects.equals(habitacion, that.habitacion) && Objects.equals(servicio, that.servicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, habitacion, servicio);
    }
}
