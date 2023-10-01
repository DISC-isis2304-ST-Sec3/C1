package uniandes.edu.co.proyecto.modelo.spa;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Item;

@Embeddable
public class ServicioSpaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="spa_id", referencedColumnName="servicio_id")
    private Spa spa;
    
    @ManyToOne
    @JoinColumn(name="items_id", referencedColumnName="id")
    private Item item;

    public ServicioSpaPK(Spa spa, Item item) {
        this.spa = spa;
        this.item = item;
    }

    public ServicioSpaPK() {
    }

    public Spa getSpa() {
        return spa;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioSpaPK that = (ServicioSpaPK) o;
        return Objects.equals(spa, that.spa) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spa, item);
    }
}
