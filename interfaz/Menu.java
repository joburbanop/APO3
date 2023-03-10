import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    /*---------------
     * Atributos, Relaciones
     *--------------------*/
    private JPanel panelInicio;
    private JLabel etiqueta, etiquetaMensaje, rolPasiente, rolDoctor;
    private ImageIcon imagenIcono, imgenBotonDoctor, imagenBotonPasiente;
    private JButton botonPasiente, botonDoctor;
    private Font font;
    private static int controlMenu = 0;

    /*----------------------------------------
     * Metodos
     *-----------------------------------------*/
    public Menu() {
        // Basico
        Font font = new Font("Roboto", Font.PLAIN, 12);

        super.setTitle("Agendar Citas"); // titulo
        super.setFont(font);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// se cierre con la x
        super.setResizable(false);// no se pueda maximizar
        super.setSize(400, 600);// tamaño ventana
        super.setLocationRelativeTo(null);// posicion en el centro de la pantalla
        super.setBackground(new Color(100, 129, 140));


        JPanelEdicion();
        imagenesYJLable();
        botonEvento();
        escuchaBotones();

        super.setVisible(true);
    }

    private void JPanelEdicion() {
        panelInicio = new JPanel();
        panelInicio.setLayout(null);// se desactiva el diseño del panel
        // panelInicio.setBackground(Color.WHITE);
        panelInicio.setBackground(new Color(0x9DABAF));

        this.getContentPane().add(panelInicio);// se trae todo lo de la ventana y se adiciona el panel
        panelInicio.setSize(250, 300);

    }

    private void imagenesYJLable() {
        Path imagePath = Paths.get("imagenes", "iconoN.png");
        String imagePathString = imagePath.toAbsolutePath().toString();
        // adicion de imagen a el panel
        Font font = new Font("Roboto", Font.PLAIN, 20);
        etiqueta = new JLabel();
        imagenIcono = new ImageIcon(imagePathString );
        etiqueta.setBounds(68, 10, 250, 280);// dimencionando JLabel

        // se escala el ibjeto imagenIcono a un tamaño adecuado de la etiqueta que lo
        // contiene
        etiqueta.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(etiqueta.getWidth(),
                etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        panelInicio.add(etiqueta);

        // estilo del texto
        
        // mensaje de selecion
        etiquetaMensaje = new JLabel("¿Cuál es tu rol?");
        etiquetaMensaje.setBounds(120, 300, 180, 30);
        etiquetaMensaje.setHorizontalAlignment(SwingConstants.CENTER);// centrar el texto en el JLabel
        etiquetaMensaje.setForeground(Color.BLACK);
        etiquetaMensaje.setFont(font);
        panelInicio.add(etiquetaMensaje);

        // mensaje doctor
        rolDoctor = new JLabel("Doctor");
        rolDoctor.setBounds(50, 345, 100, 30);
        rolDoctor.setHorizontalAlignment(SwingConstants.CENTER);
        rolDoctor.setForeground(Color.BLACK);
        
        rolDoctor.setFont(font);
        panelInicio.add(rolDoctor);

        // mensaje pasiente
        rolPasiente = new JLabel("Pasiente");
        rolPasiente.setBounds(250, 345, 100, 30);
        rolPasiente.setHorizontalAlignment(SwingConstants.CENTER);
        rolPasiente.setForeground(Color.BLACK);
        rolPasiente.setFont(font);
        panelInicio.add(rolPasiente);
    }
    private void botonEvento() {
        // boton doctor he imagen
        Path imagePath = Paths.get("imagenes", "dr-icon.png");
        String imagePathString = imagePath.toAbsolutePath().toString();

        imgenBotonDoctor = new ImageIcon(imagePathString);
        botonDoctor = new JButton();
        botonDoctor.setBounds(50, 380, 100, 100);
        botonDoctor.setIcon(new ImageIcon(imgenBotonDoctor.getImage().getScaledInstance(botonDoctor.getWidth(),
                botonDoctor.getHeight(), Image.SCALE_SMOOTH)));
        botonDoctor.setOpaque(false);
        botonDoctor.setContentAreaFilled(false);
        botonDoctor.setBorderPainted(false);
        botonDoctor.setMargin(new Insets(0, 0, 0, 0));
        botonDoctor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonDoctor.setOpaque(true);
                botonDoctor.setBackground(new Color(131, 149, 167));
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                botonDoctor.setOpaque(false); // Disminuye el tamaño del botón al salir el mouse
            }
        });

        panelInicio.add(botonDoctor);
        // setEnabled(true); se establece como encendido o apagado el boton
        
        // boton pasiente he imagen
        Path imagePathP = Paths.get("imagenes", "estetoscopio.png");
        String imagePathStringP = imagePathP.toAbsolutePath().toString();
        imagenBotonPasiente = new ImageIcon(imagePathStringP);
        botonPasiente = new JButton();
        botonPasiente.setBounds(250, 380, botonDoctor.getWidth(), botonDoctor.getHeight());
        botonPasiente.setIcon(new ImageIcon(imagenBotonPasiente.getImage().getScaledInstance(botonDoctor.getWidth(),
                botonDoctor.getHeight(), Image.SCALE_SMOOTH)));
        botonPasiente.setOpaque(false);
        botonPasiente.setContentAreaFilled(false);
        botonPasiente.setBorderPainted(false);
        botonPasiente.setMargin(new Insets(0, 0, 0, 0));
        botonPasiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonPasiente.setOpaque(true);
                botonPasiente.setBackground(new Color(131, 149, 167));
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                botonPasiente.setOpaque(false); // Disminuye el tamaño del botón al salir el mouse
            }
        });
        
        panelInicio.add(botonPasiente);

    }

    /*
     * es donde se realiza la magia, se escucha los botones pasientes
     * y doctor, estos nos permiten navegar entre ventanas, el atrbitu controlar ventanas nos pemite saber 
     * y controlar en que ventan estamos y si queremos regresar
     */
    private void escuchaBotones() {
        // se crea un objeto de tipo ActionListener, pero como no es una clase si no una
        // interface
        // se intancia dicho objeto en una clase anonima
        ActionListener oyenteBotones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonDoctor) {
                    controlMenu = 1;
                    ocultarVentanaPrincipal();
                    mostrarLoguin();

                }
                if (e.getSource() == botonPasiente) {
                    controlMenu = 2;
                    ocultarVentanaPrincipal();
                    mostrarLoguin();
                }

            }

        };

        botonDoctor.addActionListener(oyenteBotones);
        botonPasiente.addActionListener(oyenteBotones);

    }

    public void mostrarVentanaPrincipal() {
        controlMenu = 0;
        super.setVisible(true);

    }

    public void ocultarVentanaPrincipal() {
        super.setVisible(false);
    }

    public void mostrarLoguin() {
        /*
         * addWindowListener es un metodo de la clase windows a el parecer todas las
         * clases lo tiene
         * addWindowListener recibe como parametro un objeto de tipo WindowListener la
         * cual es un interface
         * en ese objetos sobre escribitmos todos los metodos qur tiene WindowListener
         * windowClosing es el metodo que bucamos el cual Se invoca cuando el usuario
         * intenta cerrar la ventana desde el menú del sistema de la ventana.
         */
        Loguin loguin = new Loguin();
        loguin.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarVentanaPrincipal();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public static int getControlMenu() {
        return controlMenu;
    }

}