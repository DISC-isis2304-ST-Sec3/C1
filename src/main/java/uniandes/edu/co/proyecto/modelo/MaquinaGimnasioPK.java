package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//relacion entre maquina y gimnasio
@Embeddable
public class MaquinaGimnasioPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_maquina", referencedColumnName="id")
    private Maquina idMaquina;
    
    @ManyToOne
    @JoinColumn(name="id_gimnasio", referencedColumnName="id")
    private Gimnasio idGimnasio;

    public MaquinaGimnasioPK(Maquina idMaquina, Gimnasio idGimnasio) {
        super();
        this.idMaquina = idMaquina;
        this.idGimnasio = idGimnasio;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Gimnasio getIdGimnasio() {
        return idGimnasio;
    }

    public void setIdGimnasio(Gimnasio idGimnasio) {
        this.idGimnasio = idGimnasio;
    }
    
}
