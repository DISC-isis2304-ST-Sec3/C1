package uniandes.edu.co.proyecto.modelo.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    private Integer id;
    private String utensilio;
    private Boolean devuelto;
    private String condicion;

    private Integer servicioId;

    public Prestamo(Integer id, String utensilio, Boolean devuelto, String condicion, Integer servicioId) {
        this.id = id;
        this.utensilio = utensilio;
        this.devuelto = devuelto;
        this.condicion = condicion;
        this.servicioId = servicioId;
    }

    public Prestamo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }
}
