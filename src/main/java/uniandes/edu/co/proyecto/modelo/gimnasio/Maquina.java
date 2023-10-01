package uniandes.edu.co.proyecto.modelo.gimnasio;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquinas")
public class Maquina {
    @Id
    private String nombre;

    public Maquina(String nombre) {
        this.nombre = nombre;
    }

    public Maquina() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
