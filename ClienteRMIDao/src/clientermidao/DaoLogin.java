/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clientermidao;

import java.rmi.RemoteException;
import mundo.Paciente;
import java.rmi.Remote;

/**
 *
 * @author joburbanop
 */
public interface DaoLogin  extends Remote{
    public boolean verificarUsuario(String usuario, String contrasenia) throws RemoteException;
    public boolean cambiarContrasenia(String contrasenia)  throws RemoteException;
    public String getUsuario()throws RemoteException;
    public void eliminar(Paciente paciente) throws RemoteException;
    public void editarDatos(String cedula, String nombre, String sangre, String email) throws RemoteException;
    public void agregarEnArchivo(Paciente valor) throws RemoteException;
    public void agregar(Paciente valor) throws RemoteException;

    public Paciente pacienteLogeado()throws RemoteException;


}
