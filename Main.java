

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("paco", 5, "Marco");
        Perro perro = new Perro("Max", 8, "Doberman", "negro");
        //metodos de la clase gato

        System.out.println("Metodos de la clase gato");
        gato.jugar();
        gato.comer();
        gato.dormir();
        //metodos de la clase Perro
        System.out.println("Metodos de la clase perro");
        perro.morder();
        perro.saltar();
        perro.calcularEdad();
    }
}
