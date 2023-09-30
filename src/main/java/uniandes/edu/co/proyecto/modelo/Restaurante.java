package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante extends Servicio{
    private Integer capacidad;
    private String estilo;
    public Restaurante(String nombre, Integer capacidad, String estilo){
        super();
        this.capacidad = capacidad;
        this.estilo = estilo;
    }   
    public Restaurante()
    {;}
    public Integer getCapacidad() {
        return capacidad;
    }
    public String getEstilo() {
        return estilo;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
}
