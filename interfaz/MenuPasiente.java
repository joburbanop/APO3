
import mundo.*;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import java.awt.Image;

/*
 * estulizado tanto para registrar como adminitrar el pasiente 
 */
public class MenuPasiente extends JFrame {
    /*----------------------------------
    * Atributos
    *------------------------------*/
    private JLabel saludo, explicacion, vectorDatosIngreso[];
    private ImageIcon imagenEliminar, imagenGuardar;
    private JPanel panel;
    private Font estiloTexto;
    private JTextField datosJTextField[];
    private JButton botonEliminar, botonGuardar;
    public final static String[] VECTORMENDAJES = { "Nombres * ", "Apellidos * ", "Email * ", "Tipo de sangre *",
            "Cedula * ", "Peso ", "Altura ", "Telefono *" };
    public final static String[] VECTORDATOSMENSAJE = { "Nombres... ", "Apellidos... ", "example@gmail.com",
            "Tipo de sangre...",
            "Cedula...", "Peso kg", "Altura mts", "Telefono..." };
    /*-----------------------------
     * Metodos
     *---------------------------*/
    public MenuPasiente() {
        /*-----------------
         * Configuracion basica
         *----------------*/
        // super.setResizable(false);// no se pueda maximizar
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla
        super.setBackground(new Color(0x9DABAF));
        super.setVisible(true);
        /*
         * creacion de objetos necesarios
         */
        saludo = new JLabel();
        explicacion = new JLabel();
        vectorDatosIngreso = new JLabel[8];
        datosJTextField = new JTextField[8];
        imagenEliminar = new ImageIcon("supprimer.png");
        imagenGuardar = new ImageIcon("5673974.png");
        botonEliminar = new JButton("Borrar");
        botonGuardar = new JButton("Guardar");
        

        estiloTexto = new Font("Roboto", Font.PLAIN, 12);
        crearPanel();
        tituloVentana();
        JLabelSaludar();
        JLabeliDeDatos();
        imagenDatos();
        botonesAcciones();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBackground(new Color(0x9DABAF));
        this.getContentPane().add(panel);

    }

    private void tituloVentana() {
        if (Loguin.getRegistrar()) {
            super.setTitle("Menu pasiente");
        } else {
            super.setTitle("Registrar pasiente");
        }

    }

    private void JLabelSaludar() {
        saludo.setFont(estiloTexto);
        saludo.setBounds(150, 20, 300, 40);
        if (Loguin.getRegistrar()) {
            saludo.setText("Bienvenido " + Loguin.getPasieteLogeado().getNombre());
            panel.add(saludo);
        } else {
            saludo.setLocation(200, 20);
            saludo.setText("Regístrate aquí");
            explicacion.setText("espacios obligatorios  * ");
            explicacion.setFont(new Font("Roboto", Font.PLAIN, 12));
            explicacion.setBounds(50, 55, 300, 40);
            panel.add(explicacion);
            panel.add(saludo);
        }

    }

    private void JLabeliDeDatos() {
        if (Loguin.getRegistrar()) {

        } else {
            /*
             * con este ciclo creamos todos los JLabel para
             * su ingreso en pantalla 
             */
            for (int i = 0; i < VECTORMENDAJES.length; i++) {
                /*
                 * las etiquetas de que datos se debe ingresar 
                 * estas estiqueas ya estan creasdas en un vector
                 */
                this.vectorDatosIngreso[i] = new JLabel(VECTORMENDAJES[i]);
                this.vectorDatosIngreso[i].setFont(new Font("Roboto", Font.PLAIN, 12));
                this.vectorDatosIngreso[i].setBounds(50, 100 + (i * 40), 200, 40);
                panel.add(this.vectorDatosIngreso[i]);

                /*
                 * casillas para ingresar datos 
                 */
                this.datosJTextField[i]=new JTextField(VECTORDATOSMENSAJE[i]);
                this.datosJTextField[i].setFont(new Font("Roboto", Font.PLAIN, 15));
                this.datosJTextField[i].setBounds(200, 100+(i*40), 300, 30);
                panel.add(this.datosJTextField[i]);
            }

        }

    }

    /**
     * metodo que crea los botones eleminar y guardar
     * 
     * @return
     * 
     * @param
     * 
     */
    private void imagenDatos() {
        if (Loguin.getRegistrar()) {

        } else {
            Color colorFondo = new Color(0x9DABAF);
            /*
             * boton he imgenen del boton elminar
             */
            imagenEliminar = new ImageIcon("supprimer.png");
            botonEliminar.setBounds(190, 450, 90, 80);
            botonEliminar.setIcon(new ImageIcon(imagenEliminar.getImage().getScaledInstance(botonEliminar.getWidth(),
                    botonEliminar.getHeight(), Image.SCALE_SMOOTH)));
            botonEliminar.setBackground(colorFondo);
            botonEliminar.setBorderPainted(false);
            botonEliminar.setForeground(colorFondo);
            panel.add(botonEliminar);

            /*
             * boton gurdar he imegen
             */
            imagenGuardar = new ImageIcon("5673974.png");
            botonGuardar.setBounds(390, 450, 80, 80);
            botonGuardar.setIcon((new ImageIcon(imagenGuardar.getImage().getScaledInstance(botonGuardar.getWidth(),
                    botonGuardar.getHeight(), Image.SCALE_SMOOTH))));
            botonGuardar.setBackground(colorFondo);
            botonGuardar.setBorderPainted(false);
            botonGuardar.setForeground(colorFondo);

            panel.add(botonGuardar);

        }
    }

    private void botonesAcciones() {
        if (Loguin.getRegistrar()) {

        } else {
            ActionListener botonAccion = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (arg0.getSource() == botonEliminar) {
                        accionBotonEliminar();
                        JOptionPane.showMessageDialog(null, datosJTextField[2].getText());
                    }
                    if (arg0.getSource() == botonGuardar) {
    
                          
                        accionBotonGuardar(new Pasiente(datosJTextField[0].getText()+datosJTextField[1].getText(), datosJTextField[2].getText(),datosJTextField[3].getText(), datosJTextField[4].getText()));
                        System.out.println("pasiente registrado");
                        
                    }

                }
            };
            botonEliminar.addActionListener(botonAccion);
            botonGuardar.addActionListener(botonAccion);
        }
    }
    public void accionBotonGuardar(Pasiente pasiente)
    {
        System.out.println("se llamo ");
       Pasiente baseDeDatos= new Pasiente();
       baseDeDatos.agregarPasiente(pasiente);
        
    
    }
    public void accionBotonEliminar()
    {

    }
}
