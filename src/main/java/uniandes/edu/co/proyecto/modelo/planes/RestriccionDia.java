package uniandes.edu.co.proyecto.modelo.planes;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restriccion_dias")
public class RestriccionDia {

    @Id
    private Integer id;
    private Integer lunes;
    private Integer martes;
    private Integer miercoles;
    private Integer jueves;
    private Integer viernes;
    private Integer sabado;
    private Integer domingo;

    public RestriccionDia(Integer id, Integer lunes, Integer martes, Integer miercoles, Integer jueves, Integer viernes, Integer sabado, Integer domingo) {
        this.id = id;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public RestriccionDia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLunes() {
        return lunes;
    }

    public void setLunes(Integer lunes) {
        this.lunes = lunes;
    }

    public Integer getMartes() {
        return martes;
    }

    public void setMartes(Integer martes) {
        this.martes = martes;
    }

    public Integer getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Integer miercoles) {
        this.miercoles = miercoles;
    }

    public Integer getJueves() {
        return jueves;
    }

    public void setJueves(Integer jueves) {
        this.jueves = jueves;
    }

    public Integer getViernes() {
        return viernes;
    }

    public void setViernes(Integer viernes) {
        this.viernes = viernes;
    }

    public Integer getSabado() {
        return sabado;
    }

    public void setSabado(Integer sabado) {
        this.sabado = sabado;
    }

    public Integer getDomingo() {
        return domingo;
    }

    public void setDomingo(Integer domingo) {
        this.domingo = domingo;
    }
}
