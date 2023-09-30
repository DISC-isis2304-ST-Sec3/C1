package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    public enum TipoRol {
        CLIENTE, RECEPCIONISTA, CAJERO, ADMINISTRADOR, GERENTE, HUESPED,
    }

    private TipoRol tipoRol;

    public Rol(String nombre, TipoRol tipoRol){
        this.nombre = nombre;

        this.tipoRol = tipoRol;
    }

    public Rol()
    {;}

    public String getNombre() {
        return nombre;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    
    

}
