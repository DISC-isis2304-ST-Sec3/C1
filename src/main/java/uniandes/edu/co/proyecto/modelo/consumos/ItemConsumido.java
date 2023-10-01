package uniandes.edu.co.proyecto.modelo.consumos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.items.Item;

@Entity
@Table(name = "items_consumidos")
public class ItemConsumido {
    @EmbeddedId
    private ItemConsumidoPK pk;

    public ItemConsumido(Item item, Consumo consumo){
        this.pk = new ItemConsumidoPK(item, consumo);
    }

    public ItemConsumido() {

    }

    public ItemConsumidoPK getPk() {
        return pk;
    }
    public void setPk(ItemConsumidoPK pk) {
        this.pk = pk;
    }
    
}
