package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
    enum TipoRol{
        CLIENTE,RECEPCIONISTA,CAJERO,ADMINISTRADOR,GERENTE,HUESPED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Enumerated(EnumType.STRING)
    private TipoRol tipoRol;
    public Rol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }
    public Rol()
    {;}
    public TipoRol getTipoRol() {
        return tipoRol;
    }
    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }
    
}

