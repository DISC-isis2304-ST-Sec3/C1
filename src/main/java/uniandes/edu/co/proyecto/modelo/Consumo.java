package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("consumos")
public class Consumo {

    @Id
    private String id;

    @DBRef
    private Servicio servicio;

    private String fecha;

    public Consumo(Servicio servicio, String fecha) {
        super();
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public Consumo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
