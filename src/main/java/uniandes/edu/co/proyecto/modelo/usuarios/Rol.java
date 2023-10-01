package uniandes.edu.co.proyecto.modelo.usuarios;

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
        CLIENTE,
        RECEPCIONISTA,
        CAJERO,
        ADMINISTRADOR,
        GERENTE,
        HUESPED
    }
    @Id
    private TipoRol nombre;

    public Rol(TipoRol tipoRol) {
        this.nombre = tipoRol;
    }
    public Rol() {

    }

    public TipoRol getNombre() {
        return nombre;
    }

    public void setNombre(TipoRol nombre) {
        this.nombre = nombre;
    }
}

