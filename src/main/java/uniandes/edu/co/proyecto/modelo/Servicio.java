package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("servicios")
public class Servicio {

    private String tipo;
    private double costo;
    private String descripcion;

    public Servicio(String tipo, double costo, String descripcion) {
        super();
        this.tipo = tipo;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public Servicio() {
        super();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
