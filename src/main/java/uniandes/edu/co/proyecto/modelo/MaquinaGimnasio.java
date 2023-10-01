package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquinas_gimnasios")
public class MaquinaGimnasio {
    @EmbeddedId
    private MaquinaGimnasioPK pk;
    public MaquinaGimnasio(Maquina idMaquina, Gimnasio idGimnasio){
        this.pk = new MaquinaGimnasioPK(idMaquina, idGimnasio);
    }
    public MaquinaGimnasio()
    {;}
    public MaquinaGimnasioPK getPk() {
        return pk;
    }
    public void setPk(MaquinaGimnasioPK pk) {
        this.pk = pk;
    }
    
}
