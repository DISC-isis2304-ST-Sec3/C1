package uniandes.edu.co.proyecto.modelo.servicios;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    private Integer id;
    private String nombre;

    public Servicio(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Servicio() {
    }

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
}
