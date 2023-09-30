package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo extends Servicio{
    private String utensilio;
    private Boolean devuelto;
    private String condicion;
    public Prestamo(String nombre, String utensilio, Boolean devuelto, String condicion){
        super(nombre);
        this.utensilio = utensilio;
        this.devuelto = devuelto;
        this.condicion = condicion;
    }
    public Prestamo()
    {;}
    public String getUtensilio() {
        return utensilio;
    }
    public Boolean getDevuelto() {
        return devuelto;
    }
    public String getCondicion() {
        return condicion;
    }
    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }
    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
}
