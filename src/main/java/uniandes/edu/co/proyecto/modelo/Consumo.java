package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import uniandes.edu.co.proyecto.modelo.Item;

@Entity
@Table(name="consumos")
public class Consumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double valorTotal;
    private String fecha;


    // atributos extra
    // private Item darItems; 

    public Consumo(Double valorTotal, String fecha) {
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        // this.darItems = darItems;
    }

    public Consumo() 
    {;}

    public Integer getId() {
        return id;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public String getFecha() {
        return fecha;
    }
    // public Item getDarItems() {
    //     return darItems;
    // }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    // public void setDarItems(Item darItems) {
    //     this.darItems = darItems;
    // }

}
