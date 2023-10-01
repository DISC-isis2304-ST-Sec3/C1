package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="spa")
public class Spa extends Servicio {

    private Integer capacidad;
    private Date apertura;
    private Date cierre;
    private Integer franja;

    public Spa(Integer capacidad, Date apertura, Date cierre, Integer franja) {
        this.capacidad = capacidad;
        this.apertura = apertura;
        this.cierre = cierre;
        this.franja = franja;
    }

    public Spa()
    {;}

    public Integer getCapacidad() {
        return capacidad;
    }

    public Date getApertura() {
        return apertura;
    }

    public Date getCierre() {
        return cierre;
    }

    public Integer getFranja() {
        return franja;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }

    public void setCierre(Date cierre) {
        this.cierre = cierre;
    }

    public void setFranja(Integer franja) {
        this.franja = franja;
    }

    

    

}
