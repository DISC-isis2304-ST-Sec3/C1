package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="productos")
public class Producto extends Item {
    

    private String origen;


    public Producto( String nombre, String origen) {
        
        super();
        // this.setNombre(nombre);
        this.origen = origen;
        
    }

    public Producto() 
    {;}

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }



}