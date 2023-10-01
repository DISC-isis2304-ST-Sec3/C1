package uniandes.edu.co.proyecto.modelo.gimnasio;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class GimnasioMaquinaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="maquina_nombre", referencedColumnName="nombre")
    private Maquina maquina;
    
    @ManyToOne
    @JoinColumn(name="gimnasio_id", referencedColumnName="servicio_id")
    private Gimnasio gimnasio;

    public GimnasioMaquinaPK(Maquina maquina, Gimnasio gimnasio) {
        this.maquina = maquina;
        this.gimnasio = gimnasio;
    }

    public GimnasioMaquinaPK() {

    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GimnasioMaquinaPK that = (GimnasioMaquinaPK) o;
        return Objects.equals(maquina, that.maquina) && Objects.equals(gimnasio, that.gimnasio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maquina, gimnasio);
    }
}
