package uniandes.edu.co.proyecto.modelo.hospedaje;

import jakarta.persistence.*;

@Entity
@Table(name="estancias")
public class Estancia {

    @Id
    private Integer id;

    public Estancia() {
        super();
    }
    

}