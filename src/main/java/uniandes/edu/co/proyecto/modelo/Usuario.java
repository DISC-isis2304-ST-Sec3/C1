package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    private String nombre;
    private String apellido;
    private Integer edad;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String documento;

    private String email;
    private String tipoDocumento;

    public Usuario(String nombre, String apellido, Integer edad, String email, String tipoDocumento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
    }
    public Usuario()
    {;}
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public String getDocumento() {
        return documento;
    }
    public String getEmail() {
        return email;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    
}
