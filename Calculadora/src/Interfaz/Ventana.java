package Interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Mundo.Operaciones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Ventana extends JFrame {
    
    /*----------------------------------
     * Atributos y Relaciones
     *--------------------------------*/
    private JTextField ingreso;
    private String cadena;
    private Operaciones operaciones;
    

    /*----------------------------
     * Metodos
     *---------------------------*/
    public Ventana(){
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        operaciones=new Operaciones();
        
        // Creamos el panel principal
        JPanel panel = new JPanel(new BorderLayout());

         // Creamos la entrada de texto
         ingreso = new JTextField("");
         ingreso.setEditable(false);
         ingreso.setHorizontalAlignment(JTextField.RIGHT);
         ingreso.setPreferredSize(new Dimension(300,70));
         ingreso.setFont(new Font("Arial",Font.PLAIN,40));
         panel.add(ingreso, BorderLayout.NORTH);
        
         
        // Creamos los botones
        String[] buttonLabels = {
            "7", "8", "9", "CE",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "/"
        };
        
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4,10,10));
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial",Font.PLAIN,20));
            
            button.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent arg0) {
                   for (String string : buttonLabels) {
                       
                    if (arg0.getSource()==button) {
                            switch (button.getText()) {
                                case "0":
                                    //System.out.println(ingreso.getText()=="");
                                    //System.out.println(ingreso.getText().equals(""));
                                    if (ingreso.getText().equals("")) {
                                        ingreso.setText("0.");
                                    } else {
                                        ingreso.setText(ingreso.getText()+"0");
                                    }
                                    break;

                                case "1":
                                    ingreso.setText(ingreso.getText()+"1");
                                    break;
                                case "2":
                                    ingreso.setText(ingreso.getText()+"2");
                                    break;
                                case "3":
                                    ingreso.setText(ingreso.getText()+"3");
                                    break;
                                case "4":
                                    ingreso.setText(ingreso.getText()+"4");
                                    break;
                                case "5":
                                    ingreso.setText(ingreso.getText()+"5");
                                    break;
                                case "6":
                                    ingreso.setText(ingreso.getText()+"6");
                                    break;
                                case "7":
                                    ingreso.setText(ingreso.getText()+"7");
                                    break;
                                case "8":
                                    ingreso.setText(ingreso.getText()+"8");
                                    break;
                                case "9":
                                    ingreso.setText(ingreso.getText()+"9");
                                    break;
                                default:
                                    break;
                                case "CE":
                                    cadena=ingreso.getText();
                                    //System.out.println(cadena.length());
                                    if (cadena.length()>0) {
                                        cadena = cadena.substring(0, cadena.length() - 1);
                                        ingreso.setText(cadena);
                                    }else{
                                        ingreso.setText("");
                                    }
                                    
                                    break;
                                
                                case "=":
                                    if (ingreso.getText().equals("")) {
                                        
                                    } else {
                                        operaciones.verificarSeparadores(ingreso.getText());
                                    ingreso.setText(operaciones.getTotalStr());
                                    }
                                    break;

                                case "+":
                                    ingreso.setText(ingreso.getText()+"+");
                                    break;

                                case "-":
                                    ingreso.setText(ingreso.getText()+"-");
                                    break;

                                case "*":
                                    ingreso.setText(ingreso.getText()+"*");
                                    break;

                                case "/":
                                ingreso.setText(ingreso.getText()+"/");
                                    break;
                            }
                            break;
                        }
                   }
                }
            });
            buttonPanel.add(button);
        }
        
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Agregamos el panel principal a la ventana
        getContentPane().add(panel);


         // Mostramos la ventana
         setSize(500, 500);
         setLocationRelativeTo(null);
         setVisible(true);
    }


    public JTextField getIngreso() {
        return ingreso;
    }
    
}