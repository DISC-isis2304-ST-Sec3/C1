package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "salones")

//falta terminar
public class Salon extends Servicio{
    private Integer capacidad;
    private double costoHora;
    private Integer tiempoLimpieza;
    public enum TipoSalon{
        REUNION, CONFERENCIA
    }
    private TipoSalon tipoSalon;

}
