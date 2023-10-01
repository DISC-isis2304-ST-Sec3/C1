package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    enum TipoDocumento{
        CC,TI,CE,PA,RC
    }
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    private String email;
    public Usuario(String nombre, String apellido, Integer edad, TipoDocumento tipoDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tipoDocumento = tipoDocumento;
    }
    public Usuario()
    {;}
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
