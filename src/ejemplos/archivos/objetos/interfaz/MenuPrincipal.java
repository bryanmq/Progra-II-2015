package ejemplos.archivos.objetos.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JMenuBar jmnbBarra = null;
    private JMenu jmMenu = null;
    private JMenuItem jmiEscribir = null, jmniSalir = null;

    /**
     * This is the default constructor
     */
    public MenuPrincipal() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(this.getContentPane());
        jmnbBarra = new JMenuBar();
        jmMenu = new JMenu("Menu");
        jmiEscribir = new JMenuItem("Administración persona...");
        jmniSalir = new JMenuItem("Salir");
        jmMenu.add(jmiEscribir);
        jmiEscribir.addActionListener(this);
        jmMenu.add(jmniSalir);
        jmniSalir.addActionListener(this);
        jmnbBarra.add(jmMenu);
        this.add(jmnbBarra, BorderLayout.NORTH);
        setTitle("Mantenimiento Personas");
        setVisible(true);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmiEscribir) {
            new InterfazPersonas();
        } else {
            if (e.getSource() == jmniSalir) {
                System.exit(0);
            }
        }
    }

    public static void main(String args[]) {
        new MenuPrincipal();
    }
}