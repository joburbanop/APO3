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
        dormir();
        comer();
        jugar();

    }

    public void dormir(){
        System.out.println("Estoy durmiendo");

    }

    public void comer(){
        System.out.println("Estoy comiendo");

    }
    
    public void jugar(){
        System.out.println("Estoy jugando con: " + this.nombre);

    }
    public void correr(){
        System.out.println("Estoy corriendo");

    }



}
