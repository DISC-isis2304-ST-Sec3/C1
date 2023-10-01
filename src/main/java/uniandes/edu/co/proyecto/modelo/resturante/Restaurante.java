package uniandes.edu.co.proyecto.modelo.resturante;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {


    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private String estilo;

    public Restaurante(Integer servicioId, Integer capacidad, String estilo) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Restaurante() {
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
