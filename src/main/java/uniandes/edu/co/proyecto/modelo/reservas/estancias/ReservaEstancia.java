package uniandes.edu.co.proyecto.modelo.reservas.estancias;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.usuarios.Usuario;

import java.time.LocalDateTime;


@Entity
@Table(name="reservas_estancias")
public class ReservaEstancia {
    
    @Id
    private Integer id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Integer cantidadHuespedes;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "documento")
    private Usuario usuario;

    public ReservaEstancia(Integer id, LocalDateTime inicio, LocalDateTime fin, Integer cantidadHuespedes, Usuario usuario) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.cantidadHuespedes = cantidadHuespedes;
        this.usuario = usuario;
    }

    public ReservaEstancia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public Integer getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
