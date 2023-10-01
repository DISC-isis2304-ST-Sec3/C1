package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//relacion entre item y consumo
@Embeddable
public class ItemConsumidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_item", referencedColumnName="id")
    private Item idItem;
    
    @ManyToOne
    @JoinColumn(name="id_consumo", referencedColumnName="id")
    private Consumo idConsumo;

    public ItemConsumidoPK(Item idItem, Consumo idConsumo) {
        super();
        this.idItem = idItem;
        this.idConsumo = idConsumo;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Consumo getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Consumo idConsumo) {
        this.idConsumo = idConsumo;
    }
    

    
}
