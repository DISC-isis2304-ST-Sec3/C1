package uniandes.edu.co.proyecto.modelo.tienda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Entity
@Table(name = "tiendas")
public class Tienda  {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;

    private String tipo;

    public Tienda(Integer servicioId, String tipo) {
        this.servicioId = servicioId;
        this.tipo = tipo;
    }

    public Tienda() {
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
