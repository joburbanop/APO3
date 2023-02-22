package Mundo;

import Interfaz.Ventana;

public class Operaciones {
    /*--------------------------------
     * Atributos
     *------------------------------*/
    private String totalStr;

    
    /*--------------------------
     *Metodos 
     *---------------------*/ 


    /**
     * este metodo nos permite verificar los operadores y 
     * los  numeros que hallan
     * @param entrada cadena de texto que se va ha analizar 
     */
    public void verificarSeparadores(String entrada){
        
        //separar los numeros no importa que separador se utilice
        String[] numeros = entrada.split("\\+|\\-|\\*|\\/"); 
        /*System.out.println("Numeros: ");
        for (String numero : numeros) {
            System.out.println(numero);
        }*/

        // se optiene los operadores utilizando los numero como separadores o los decimales
        String[] operadores = entrada.split("[\\d\\.]+"); 
        /*System.out.println("operadores: ");
        for (String operador : operadores) {
            System.out.println(operador);
        }*/
        
        operaciones(numeros,operadores);
    }


    /**
     * metodo creado para realizar operaciones 
     * @param numeros los numeros que se van ha operar 
     * @param operadores las operacines que se van aplicar 
     */
    public void operaciones (String[] numeros, String[] operadores) {
        double total = Double.parseDouble(numeros[0]);

        for (int i = 1; i < numeros.length; i++) {
            switch (operadores[i]) {
                case "+":
                    total += Double.parseDouble(numeros[i]);
                    break;
                case "-":
                    total -= Double.parseDouble(numeros[i]);
                    break;
                case "*":
                    total *= Double.parseDouble(numeros[i]);
                    break;
                case "/":
                    total /= Double.parseDouble(numeros[i]);
                    break;
            }
        }
        totalStr=total+"";
    }

    /**
     * 
     * @return el total con de las operaciones
     */
    public String getTotalStr() {
        return totalStr;
    }

    
}
