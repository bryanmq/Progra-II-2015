package ejemplos.archivos.objetos.eventos;

import ejemplos.archivos.objetos.escritor.EscritorObjetos;
import ejemplos.archivos.objetos.interfaz.InterfazPersonas;
import ejemplos.archivos.objetos.lector.LectorObjetos;
import ejemplos.archivos.objetos.personas.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ManejadorEventos implements ActionListener {

    private JButton jbtnGuardar, jbtnLeer, jbtnSalir;
    private JTextField jtxtNombre, jtxtEdad;
    private EscritorObjetos escritor = new EscritorObjetos("personas.dat");
    private InterfazPersonas interfazPersonas = null;
    private JTextArea jtxtArea = null;

    public ManejadorEventos(InterfazPersonas interfazPersonas, JButton jbtnGuardar, JButton jbtnLeer, JButton jbtnSalir,
            JTextField jtxtNombre, JTextField jtxtEdad, JTextArea jtxtArea) {
        this.interfazPersonas = interfazPersonas;
        this.jbtnGuardar = jbtnGuardar;
        this.jbtnLeer = jbtnLeer;
        this.jbtnSalir = jbtnSalir;
        this.jtxtNombre = jtxtNombre;
        this.jtxtEdad = jtxtEdad;
        this.jtxtArea = jtxtArea;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnSalir) {
            escritor.cerrarArchivo();
            interfazPersonas.dispose();
        }

        if (e.getSource() == jbtnGuardar) {
            if ((jtxtNombre.getText().length() > 0) && (jtxtEdad.getText().length() > 0)) {
                Persona persona = new Persona(jtxtNombre.getText(), Integer.parseInt(jtxtEdad.getText()));
                if (escritor.añadirObject(persona) == true) {
                    System.err.println("Persona registrada");
                    jtxtNombre.setText("");
                    jtxtEdad.setText("");
                } else {
                    System.err.println("Error al registrar");
                }
            }
        } else {
            if (e.getSource() == jbtnLeer) {
                LectorObjetos lector = new LectorObjetos("personas.dat");
                jtxtArea.setText("");
                jtxtArea.append("Nombre                  Edad \n");
                jtxtArea.append(lector.readObjects());
            }
        }
    }
}
