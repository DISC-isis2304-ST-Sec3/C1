package uniandes.edu.co.proyecto.modelo.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="productos")
public class Producto {

    @Id
    @Column(name = "item_id")
    private Integer itemId;
    private String origen;

    public Producto(Integer itemId, String origen) {
        this.itemId = itemId;
        this.origen = origen;
    }

    public Producto() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}