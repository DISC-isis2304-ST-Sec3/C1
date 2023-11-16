package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("tipos_habitacion")
public class TipoHabitacion {

    private String tipo;

    public TipoHabitacion(String tipo) {
        super();
        this.tipo = tipo;
    }

    public TipoHabitacion() {
        super();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
