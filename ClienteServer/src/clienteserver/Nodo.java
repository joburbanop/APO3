/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteserver;

/**
 *
 * @author joburbanop
 */
public class Nodo<Paciente> {
    
    /*---------------------------
    *Atributos
    *--------------------------*/
    private Paciente paciente;
    private Nodo<Paciente> siguiente;
    
    /*----------------------------------------------
    *Metodos
    *---------------------------------------------------*/
    public Nodo(Paciente valor) {
        this.paciente = valor;
        this.siguiente = null;
    }
    
    public Paciente getValor() {
        return paciente;
    }
    
    public void setPaciente(Paciente valor) {
        this.paciente = valor;
    }
    
    public Nodo<Paciente> getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodo<Paciente> siguiente) {
        this.siguiente = siguiente;
    }
    
}
