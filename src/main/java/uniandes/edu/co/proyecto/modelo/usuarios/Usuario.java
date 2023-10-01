package uniandes.edu.co.proyecto.modelo.usuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private String documento;
    private String nombre;
    private String apellido;
    private Integer edad;
    enum TipoDocumento{CC,TI,CE,PA,RC}
    private TipoDocumento tipoDocumento;
    private String email;

    @OneToOne
    @JoinColumn(name = "rol", referencedColumnName = "nombre")
    private Rol rol;

    public Usuario(String documento, String nombre, String apellido, Integer edad, TipoDocumento tipoDocumento, String email, Rol rol) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tipoDocumento = tipoDocumento;
        this.email = email;
        this.rol = rol;
    }

    public Usuario() {

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
