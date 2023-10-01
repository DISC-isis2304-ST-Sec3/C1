package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="estancias")
public class Estancia extends ReservaEstancia{

    public Estancia() {
        super();
    }
    

}