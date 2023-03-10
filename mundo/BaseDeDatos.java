package mundo;
import java.util.ArrayList;
import java.util.Collection;

public class BaseDeDatos {
    /*----------------------------------
    * Atributos
    *------------------------------*/
    // arreglos dinamicos
    private ArrayList<Doctor> doctores = new ArrayList();

    public ArrayList<Pasiente> pasientes = new ArrayList();

    private static int numeroPasiente=0;

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }




    public ArrayList<Pasiente> getPasientes() {
        return pasientes;
    }





    /*-----------------------------
     * Metodos
     *---------------------------*/
    public BaseDeDatos( String nombre, String especialidad, String clave)
    {
        doctores.add(new Doctor(nombre, especialidad, clave));
    }
    
    

    public BaseDeDatos()
    {
       
    }
   

   
    public void agregarPasiente (Pasiente pasiente)
    {
        numeroPasiente++;
        System.out.println(pasientes.listIterator());
        pasientes.add(pasiente);
        System.out.println("tamaño de base pasiente " +pasientes.size());
        for (int i = 0; i < pasientes.size(); i++) {
            System.out.println("pasiente en la posicion 0 "+pasientes.get(i).getCedula());
        }          
      
        
        System.out.println(numeroPasiente);
    }




    public static int getNumeroPasiente() {
        return numeroPasiente;
    }
    
    
}
