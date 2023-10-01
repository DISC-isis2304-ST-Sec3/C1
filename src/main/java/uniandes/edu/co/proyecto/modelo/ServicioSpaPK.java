package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre spa e item
@Embeddable
public class ServicioSpaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_spa", referencedColumnName="id")
    private Spa idSpa;
    
    @ManyToOne
    @JoinColumn(name="id_item", referencedColumnName="id")
    private Item idItem;

    public ServicioSpaPK(Spa idSpa, Item idItem) {
        super();
        this.idSpa = idSpa;
        this.idItem = idItem;
    }

    public Spa getIdSpa() {
        return idSpa;
    }

    public void setIdSpa(Spa idSpa) {
        this.idSpa = idSpa;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    
}
