package uniandes.edu.co.proyecto.modelo.items;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    
    @Id
    private Integer id;
    private String nombre; 
    private double valor;

    public Item(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    public Item()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
