package mundo;

import java.util.ArrayList;

public class Pasiente extends Usuario {

    /*----------------------------------------
     * Atributos
     *--------------------------------------*/
    private String peso;

    private String alto;

    private String tipoDeSangre;

    public ArrayList<Pasiente> pasientes = new ArrayList<>();
    /*------------------------------------------
     * Metodos
    *--------------------------------------------*/

    public Pasiente(String nombre, String email, String tipoDeSangre, String cedula) {
        super(nombre, email, cedula);
        this.tipoDeSangre = tipoDeSangre;
        this.peso = null;
        this.alto = null;
    }
    public Pasiente()
    {
        
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
   
    public  ArrayList<Pasiente> basePasientes( ) {
        pasientes.add(new Pasiente("David Santiago ", "santi@gamil.com", "O+", "1086363979"));
        pasientes.add(new Pasiente("ernesto  ", "ernesto@gamil.com", "O-", "1086363777"));
        pasientes.add(new Pasiente("Jonathan Camilo", "joburbanop589@gmail.com", "A+", "12345678"));
        
        return pasientes;
        
    }
    public void agregarPasiente(Pasiente pasiente)
    { 
        pasientes.add(pasiente);
        System.out.println("tamaño "+basePasientes().size());
        System.out.println("tamanño array "+pasientes.size());
        
    }
    

}
