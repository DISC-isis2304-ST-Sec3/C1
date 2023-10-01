package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "items_consumidos")
public class ItemConsumido {
    @EmbeddedId
    private ItemConsumidoPK pk;
    public ItemConsumido(Item idItem, Consumo idConsumo){
        this.pk = new ItemConsumidoPK(idItem, idConsumo);
    }
    public ItemConsumido()
    {;}
    public ItemConsumidoPK getPk() {
        return pk;
    }
    public void setPk(ItemConsumidoPK pk) {
        this.pk = pk;
    }
    
}
