package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiendas")
public class Tienda extends Servicio{
    private String tipo;
    public Tienda(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }
    public Tienda()
    {;}
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
