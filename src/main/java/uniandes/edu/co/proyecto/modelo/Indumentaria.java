package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "indumentarias")
public class Indumentaria extends Servicio{
    private Integer elementos;
    private double valorBase;
    private double valorElemento;
    public Indumentaria(String nombre, Integer elementos, double valorBase, double valorElemento){
        super(nombre);
        this.elementos = elementos;
        this.valorBase = valorBase;
        this.valorElemento = valorElemento;
    }
    public Indumentaria()
    {;}
    public Integer getElementos() {
        return elementos;
    }
    public double getValorBase() {
        return valorBase;
    }
    public double getValorElemento() {
        return valorElemento;
    }
    public void setElementos(Integer elementos) {
        this.elementos = elementos;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    public void setValorElemento(double valorElemento) {
        this.valorElemento = valorElemento;
    }
    
    
}
