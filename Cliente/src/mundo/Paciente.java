/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import clientermidao.DaoLogin;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author joburbanop
 */
public class Paciente  implements DaoLogin, Serializable{  
/*----------------------------------------
     * Atributos
     *--------------------------------------*/
    private String peso;

    private String alto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setNumeroDeCelular(String numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Paciente> getPasientes() {
        return pasientes;
    }

    public void setPasientes(ArrayList<Paciente> pasientes) {
        this.pasientes = pasientes;
    }
    
    private String nombre;

    private String email;

    private String direccion;

    private String numeroDeCelular;

    private String clave;

    private String cedula;

    private String apellido;

    private String tipoDeSangre;

    public ArrayList<Paciente> pasientes = new ArrayList<>();
    
    private static Paciente paciente;
    
    /*------------------------------------------
     * Metodos
    *--------------------------------------------*/
    /**
    * Crea una instancia de la clase Paciente con los parámetros proporcionados.
     * @param nombre El nombre del paciente.
     * @param email El correo electrónico del paciente.
     * @param tipoDeSangre El tipo de sangre del paciente.
    * @param cedula La cédula del paciente.
     */
    public Paciente(String nombre, String email, String tipoDeSangre, String cedula) {
        
        this.tipoDeSangre = tipoDeSangre;
        this.peso = null;
        this.alto = null;
    }
    
    
    /**
    * Crea una instancia predeterminada de la clase Paciente.
    */
    public Paciente(){
        
    }
    
    
    /**
    * Obtiene una instancia de la clase Paciente. Si no se ha creado una instancia previamente, se crea una nueva instancia.
    * @return Una instancia de la clase Paciente.
     */
    
    public static Paciente getPaciente(){
        if(paciente==null)
            paciente=new Paciente();
        
        return paciente;
    }
    
    
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    @Override
    public boolean verificarUsuario(String usuario, String contrasenia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cambiarContrasenia(String contrasenia) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUsuario() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Paciente paciente) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarDatos(String cedula, String nombre, String sangre, String email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarEnArchivo(Paciente valor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregar(Paciente valor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente pacienteLogeado() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
