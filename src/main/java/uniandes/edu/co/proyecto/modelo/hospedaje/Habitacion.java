package uniandes.edu.co.proyecto.modelo.hospedaje;

import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    private Integer numero;

    @OneToOne
    @JoinColumn(name = "tipo", referencedColumnName = "nombre")
    private TipoHabitacion tipo;

    public Habitacion(Integer numero, TipoHabitacion tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Habitacion() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
}
