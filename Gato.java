public class Gato {
    /*----------------------
     * ATRIBUTOS
     *-----------*/
    private String nombre;
    private int edad;
    private String dueno;


    /*------------------------
     * METODOS
     *-----------------*/
    public  Gato(String nombre, int edad, String dueno) {
        this.nombre = nombre;
        this.edad = edad;
        this.dueno = dueno;
    
    }

    public void dormir(){
        System.out.println("El gato " + this.nombre + " esta durmiendo");

    }

    public void comer(){
        System.out.println("El gato de " + this.edad + " años de edad, esta comiendo");

    }
    
    public void jugar(){
        System.out.println("Estoy jugando con: " + this.nombre);

    }
    public void correr(){
        System.out.println("El gato esta corriendo con su dueño " + this.dueno);

    }
    


}
