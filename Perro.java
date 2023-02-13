import java.util.Scanner;

public class Perro {
    Scanner consola = new Scanner(System.in);
    /*Atributos */

    private String nombre;
    private int edad;
    private String raza;
    private String color;


    public Perro(String nombre, int edad, String raza, String color){
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.color = color;
    }

    public void morder(){
        System.out.println(this.nombre + " esta mordiendo");
    }

    public void saltar(){
        System.out.println("El perro de nombre: " + this.raza + " esta saltando");
    }

    public void jugar(){
        System.out.println("El perro de color " + this.color + " esta jugando");

    }

    public int calcularEdad(){
        System.out.println("Ingresa la edad del perro en años: ");
        edad = consola.nextInt();

        
            while(edad < 0){
                System.out.println("La edad debe ser mayor o igual a 0");
                edad = consola.nextInt();
            }
            
              
            if (edad > 10){
                System.out.println("El perro de edad " + this.edad + " años es viejo");
            }else{   
                System.out.println("El perro de edad " + this.edad + " años es joven");
            }
        
        return edad;
    }
}
