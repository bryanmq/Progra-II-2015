package ejemplos.archivos.objetos.interfaz;

import ejemplos.archivos.objetos.eventos.ManejadorEventos;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.*;



public class InterfazPersonas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jlblNombre = null;
    private JLabel jlblEdad = null;
    private JTextField jtxtNombre = null;
    private JTextField jtxtEdad = null;
    private JLabel jlblaños = null;
    private JButton jbtnGuardar = null;
    private JButton jbtnLeer = null;
    private ManejadorEventos misEventos = null;
    private JButton jbSalir = null;
    private JTextArea jtxtArea = null;
    private JScrollPane jcsrBarDescrp = null;

    /**
     * This is the default constructor
     */
    public InterfazPersonas() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(276, 289);
        this.setContentPane(getJContentPane());
        this.setTitle("Test Object Stream");
        this.setVisible(true);
        this.setResizable(false);
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jlblaños = new JLabel();
            jlblaños.setBounds(new Rectangle(107, 46, 36, 12));
            jlblaños.setText("años");
            jlblEdad = new JLabel();
            jlblEdad.setBounds(new Rectangle(7, 40, 60, 20));
            jlblEdad.setText("Edad :");
            jlblNombre = new JLabel();
            jlblNombre.setBounds(new Rectangle(7, 16, 60, 21));
            jlblNombre.setText("Nombre :");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jlblNombre, null);
            jContentPane.add(jlblEdad, null);
            jContentPane.add(getJtxtNombre(), null);
            jContentPane.add(getJtxtEdad(), null);
            jContentPane.add(jlblaños, null);
            jContentPane.add(getJbtnGuardar(), null);
            jContentPane.add(getJbtnLeer(), null);
            jContentPane.add(getJbSalir(), null);
            jContentPane.add(getJscrpBarDescrp(), null);
            misEventos = new ManejadorEventos(this, jbtnGuardar, jbtnLeer, jbSalir, jtxtNombre, jtxtEdad, jtxtArea);
            jbtnGuardar.addActionListener(misEventos);
            jbtnLeer.addActionListener(misEventos);
            jbSalir.addActionListener(misEventos);
        }
        return jContentPane;
    }

    /**
     * This method initializes jtxtNombre
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJtxtNombre() {
        if (jtxtNombre == null) {
            jtxtNombre = new JTextField();
            jtxtNombre.setBounds(new Rectangle(70, 21, 159, 16));
        }
        return jtxtNombre;
    }

    /**
     * This method initializes jtxtEdad
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJtxtEdad() {
        if (jtxtEdad == null) {
            jtxtEdad = new JTextField();
            jtxtEdad.setBounds(new Rectangle(70, 45, 32, 15));
        }
        return jtxtEdad;
    }

    /**
     * This method initializes jbtnGuardar
     *
     * @return javax.swing.JButton
     */
    private JButton getJbtnGuardar() {
        if (jbtnGuardar == null) {
            jbtnGuardar = new JButton("Guardar");
            jbtnGuardar.setBounds(new Rectangle(7, 217, 81, 29));
        }
        return jbtnGuardar;
    }

    /**
     * This method initializes jbtnLeer
     *
     * @return javax.swing.JButton
     */
    private JButton getJbtnLeer() {
        if (jbtnLeer == null) {
            jbtnLeer = new JButton("Leer");
            jbtnLeer.setBounds(new Rectangle(95, 217, 78, 29));
        }
        return jbtnLeer;
    }

    /**
     * This method initializes jbSalir
     *
     * @return javax.swing.JButton
     */
    private JButton getJbSalir() {
        if (jbSalir == null) {
            jbSalir = new JButton();
            jbSalir.setBounds(new Rectangle(181, 217, 75, 28));
            jbSalir.setText("Salir");
        }
        return jbSalir;
    }

    /**
     * This method initializes jtxtArea
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getJtxtArea() {
        if (jtxtArea == null) {
            jtxtArea = new JTextArea();
            jtxtArea.setBounds(new Rectangle(7, 70, 248, 137));
        }
        return jtxtArea;
    }

    private JScrollPane getJscrpBarDescrp() {
        if (jcsrBarDescrp == null) {
            jcsrBarDescrp = new JScrollPane(getJtxtArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jcsrBarDescrp.setSize(new Dimension(248, 137));
            jcsrBarDescrp.setLocation(new Point(7, 70));
        }
        return jcsrBarDescrp;
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
