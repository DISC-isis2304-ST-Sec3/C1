package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    private String tipo;

    public Habitacion(Integer numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }
    public String getTipo() {
        return tipo;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
