/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienteserver;

import clientermidao.DaoLogin;
import java.io.BufferedReader;

import mundo.Paciente;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
//librerias necesarias y adicinales para el guardado de datos en archivos 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author joburbanop
 */
public final class ClienteServer extends UnicastRemoteObject implements DaoLogin {
  
    /*--------------------------------------------------------
    *Atributos
    *--------------------------------------------------------*/
    private Nodo<Paciente> cabeza;
    private static ClienteServer lista;
    private Paciente pacienteLogeado;
    
    public ClienteServer() throws RemoteException{
        
        super();
        this.cabeza = null;
        cargarDatosDesdeArchivo();

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ClienteServer());
            System.out.println("Servidor esta activo");
            
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Obtiene la instancia única de la lista enlazada de pacientes.
     * Si la instancia no existe, se crea una nueva.
     * @return La lista enlazada de pacientes.
     */
    public static ClienteServer getClienteServer() throws RemoteException{
        if(lista==null)
            lista=new ClienteServer();
        
        return lista;
    }
    
    /**
    * Agrega un nuevo paciente a la lista enlazada.
    * @param valor El paciente a agregar.
    * @throws RemoteException Si ocurre un error durante la invocación remota.
    */
    @Override
    public void agregar(Paciente valor) throws RemoteException {
        
        Nodo<Paciente> nuevoNodo = new Nodo<Paciente>(valor);

        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            System.out.println("cargando...");
            
        } 
        else {
            Nodo<Paciente> nodoActual = cabeza;
            while (nodoActual.getSiguiente() != null) {
                
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        
        
    }
    
    /**
    * Verifica si existe un usuario con el nombre de usuario y la contraseña especificados.    *
    * @param usuario     El nombre de usuario a verificar.
    * @param contrasenia La contraseña a verificar.
    * @return true si se encuentra un usuario con los valores especificados, false de lo contrario.
    * @throws RemoteException Si ocurre un error durante la invocación remota.
    */
    @Override
    public boolean verificarUsuario(String usuario, String contrasenia) throws RemoteException {
        
        boolean estado = false;
        if (cabeza == null) {
            System.out.println("que");
            estado=false;
            return estado;
        }

        // Itera sobre cada objeto Paciente en la lista de pacientes
        Nodo<Paciente> nodoActual = cabeza;
        while (nodoActual != null) {
            Paciente paciente = (Paciente) nodoActual.getValor();
            pacienteLogeado=nodoActual.getValor();
            
            // Compara el nombre de usuario y la contraseña del objeto con los valores de entrada
            if (paciente.getNombre().equals(usuario) && paciente.getCedula().equals(contrasenia)) {
                // Si los valores coinciden, establece el estado en verdadero y sale del bucle
                
                System.out.print(pacienteLogeado.getCedula());
                estado = true;
                break;
            }
            nodoActual = nodoActual.getSiguiente();
            
            
            
        }

        return estado;
    }
    
    /**
    * Carga los datos de pacientes desde un archivo de texto.
    * Los datos cargados se agregan a la lista enlazada de pacientes.
    */
    public void cargarDatosDesdeArchivo() {
    try {
        

        // Leer el archivo de texto
        FileReader fileReader = new FileReader("data/pacientes.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Leer cada línea del archivo
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            // Dividir la línea en campos separados por comas
            String[] campos = linea.split(",");
            for (int i=0;i<campos.length;i++)
            {
                System.out.println(campos[i]);
            }
            
            // Crear un nuevo objeto Paciente con los datos del archivo
       
            Paciente pacienteCargar = new Paciente( );
            pacienteCargar.setNombre(campos[0]);
            pacienteCargar.setCedula(campos[1]);
            pacienteCargar.setEmail(campos[2]);
            pacienteCargar.setTipoDeSangre(campos[3]);
            agregar(pacienteCargar);
            System.out.print(pacienteCargar.getNombre()+"\n");
            System.out.print(pacienteCargar.getCedula()+"\n");
            System.out.print(pacienteCargar.getEmail()+"\n");
            System.out.print(pacienteCargar.getTipoDeSangre()+"\n");
            
            
            // Agregar el paciente a la lista enlazada
            System.out.print("Archivo cargado");
            
        }

        // Cerrar el archivo
            bufferedReader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos desde el archivo paciente.txt");
            e.printStackTrace();
        }
    }

    @Override
    public boolean cambiarContrasenia(String contrasenia)  throws RemoteException{
        return true;
    }
    private String nombreUsuarioActual; // atributo para almacenar el nombre de usuario actual

    @Override
    public String getUsuario()throws RemoteException {
        return nombreUsuarioActual;
    }

    @Override
    public void eliminar(Paciente paciente) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    public Paciente pacienteLogeado(){
        return pacienteLogeado;
    }

    
    /**
    * Edita los datos de un paciente especificado por su cédula.
    * @param cedula La cédula del paciente que se desea editar.
    * @param nombre El nuevo nombre del paciente.
    * @param sangre El nuevo tipo de sangre del paciente.
    * @param email El nuevo email del paciente.
    * @throws RemoteException Si ocurre un error durante la ejecución remota.
    */
    @Override
    public void editarDatos(String cedula, String nombre, String sangre, String email) throws RemoteException {
        pacienteLogeado.setCedula(cedula);
        pacienteLogeado.setNombre(nombre);
        pacienteLogeado.setTipoDeSangre(sangre);
        pacienteLogeado.setEmail(email);
        
         // Actualizar los datos en el archivo
    try {
        FileWriter fileWriter = new FileWriter("data/pacientes.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        // Recorrer la lista de pacientes y escribir los datos en el archivo
        Nodo<Paciente> nodoActual = cabeza;
        while (nodoActual != null) {
            Paciente paciente = nodoActual.getValor();
            
            // Verificar si es el paciente que se está editando
            if (paciente == pacienteLogeado) {
                // Actualizar los datos en el archivo
                bufferedWriter.write(nombre + "," + cedula + "," + email + "," + sangre);
                bufferedWriter.newLine();
            } 
            
            nodoActual = nodoActual.getSiguiente();
        }
        
            // Cerrar el archivo
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los datos actualizados en el archivo.");
            e.printStackTrace();
        }
    }
    
    /**
    * Agrega los datos de un paciente al archivo "pacientes.txt".
    * @param valor El objeto Paciente que se desea agregar al archivo.
    * @throws RemoteException Si ocurre un error durante la ejecución remota.
    */
    @Override
    public void agregarEnArchivo(Paciente valor) throws RemoteException {
        // Guardar el valor en un archivo txt
        try {
            //garantizamos que la carpeta exista 
            File carpetaData = new File("data");
            if (!carpetaData.exists()) {
                carpetaData.mkdirs();
            }
            
            //se realiza el guradado de documentos de la carpeta data y en un archivo llamado pacientes.txt
            FileWriter fileWriter = new FileWriter("data/pacientes.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
            // Escribir los datos del paciente en el archivo
            bufferedWriter.write(valor.getNombre() + "," + valor.getCedula() +","+ valor.getEmail()+","+valor.getTipoDeSangre()+ "\n");
            System.out.print("se gurado en el archivo");
            // Cerrar el archivo
            bufferedWriter.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error al guardar los datos en el archivo.");
            e.printStackTrace();
        }
    }
    
}
