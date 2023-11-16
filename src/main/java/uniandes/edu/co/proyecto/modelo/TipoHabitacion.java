package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tipos_habitacion")
public class TipoHabitacion {

    @Id
    private String id;

    private String tipo;
    private int jacuzzi;
    private int comedor;
    private int cocina;

    public TipoHabitacion(String tipo, int jacuzzi, int comedor, int cocina) {
        super();
        this.tipo = tipo;
        this.jacuzzi = jacuzzi;
        this.comedor = comedor;
        this.cocina = cocina;
    }

    public TipoHabitacion() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(int jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public int getComedor() {
        return comedor;
    }

    public void setComedor(int comedor) {
        this.comedor = comedor;
    }

    public int getCocina() {
        return cocina;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

}
