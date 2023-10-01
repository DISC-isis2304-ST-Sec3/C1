package uniandes.edu.co.proyecto.modelo.consumos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.items.Item;

@Embeddable
public class ItemConsumidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="item_id", referencedColumnName="id")
    private Item item;
    
    @ManyToOne
    @JoinColumn(name="consumo_id", referencedColumnName="id")
    private Consumo consumo;

    public ItemConsumidoPK(Item item, Consumo consumo) {
        this.item = item;
        this.consumo = consumo;
    }

    public ItemConsumidoPK() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemConsumidoPK that = (ItemConsumidoPK) o;
        return Objects.equals(item, that.item) && Objects.equals(consumo, that.consumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, consumo);
    }
}
