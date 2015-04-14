package ejemplos.archivos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro extends JFrame {

    JButton salvar, salir;
    JTextField jtnombre, jtsalario;
    JLabel jlnombre, jlsalario;
    int iniciador;
    static EscritorArchivo2 archivo;

    public Registro() {
        salvar = new JButton("Salvar");
        salir = new JButton("Salir");

        JPanel botones = new JPanel();
        botones.add(salvar);
        botones.add(salir);

        jtnombre = new JTextField(20);
        jlnombre = new JLabel("Nombre");
        jtsalario = new JTextField(10);
        jlsalario = new JLabel("Salario");
//SYSTEM32
        JPanel informacion = new JPanel();
        informacion.add(jlnombre);
        informacion.add(jtnombre);
        informacion.add(jlsalario);
        informacion.add(jtsalario);
      
        iniciador = 1;
        salvar.addActionListener(
                new ActionListener() {
                  
                    public void actionPerformed(ActionEvent event) {
                        if (iniciador++ == 1) {
                            archivo = new EscritorArchivo2();
                        }
                        archivo.writeArchivo(jtnombre.getText(), Long.parseLong(jtsalario.getText()));
                        jtnombre.setText("");
                        jtsalario.setText("");

                    }
                });

        salir.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });


        Container contenedor = getContentPane();
        contenedor.add(informacion, BorderLayout.CENTER);
        contenedor.add(botones, BorderLayout.SOUTH);

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String arg[]) {
        Registro ventana = new Registro();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}