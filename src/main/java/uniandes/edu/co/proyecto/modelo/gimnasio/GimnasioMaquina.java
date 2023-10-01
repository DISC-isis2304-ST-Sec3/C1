package uniandes.edu.co.proyecto.modelo.gimnasio;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gym_maqs")
public class GimnasioMaquina {
    @EmbeddedId
    private GimnasioMaquinaPK pk;
    public GimnasioMaquina(Maquina maquina, Gimnasio gimnasio){
        this.pk = new GimnasioMaquinaPK(maquina, gimnasio);
    }
    public GimnasioMaquina() {

    }

    public GimnasioMaquinaPK getPk() {
        return pk;
    }
    public void setPk(GimnasioMaquinaPK pk) {
        this.pk = pk;
    }
    
}
