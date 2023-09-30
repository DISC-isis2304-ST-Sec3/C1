package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planes_de_consumo")
public class PlanDeConsumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    
    
    private String descuento;
    private String minimasNoches;
    private String valor;

    public PlanDeConsumo( String descuento, String minimasNoches, String valor) {

        this.descuento = descuento;
        this.minimasNoches = minimasNoches;
        this.valor = valor;
    }

    public PlanDeConsumo() 
    {;}

    public String getNombre() {
        return nombre;
    }

    public String getDescuento() {
        return descuento;
    }

    public String getMinimasNoches() {
        return minimasNoches;
    }

    public String getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setMinimasNoches(String minimasNoches) {
        this.minimasNoches = minimasNoches;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    


}
