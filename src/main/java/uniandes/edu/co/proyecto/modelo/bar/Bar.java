package uniandes.edu.co.proyecto.modelo.bar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.servicios.Servicio;

@Entity
@Table(name = "bares")
public class Bar {

    @Id
    @Column(name = "servicio_id")
    private Integer servicioId;
    private Integer capacidad;
    private String estilo;

    public Bar(Integer servicioId, Integer capacidad, String estilo) {
        this.servicioId = servicioId;
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Bar() {
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
