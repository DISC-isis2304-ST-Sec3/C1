package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientes")
public class Cliente {

    private String tipoDocumento;
    private int numDocumento;
    private String nombre;
    private String correo;

    public Cliente(String tipoDocumento, int numDocumento, String nombre, String correo) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Cliente() {
        super();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
