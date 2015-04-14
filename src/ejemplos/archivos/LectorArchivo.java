package ejemplos.archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LectorArchivo {

    File nombreArchivo;
    RandomAccessFile flujo;

    public LectorArchivo() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = file.showOpenDialog(null);
        System.out.println(file.getSelectedFile().getPath());

        nombreArchivo = file.getSelectedFile();
        try {
            flujo = new RandomAccessFile(nombreArchivo, "r");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTextArea readArchivo() {
        JTextArea registro = new JTextArea();
        registro.setText("Nombre          salario\n");

        if (nombreArchivo == null || nombreArchivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre invalido", "Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                while (flujo.getFilePointer() != flujo.length()) {
                    registro.append(flujo.readUTF() + "\t");
                    registro.append(flujo.readLong() + "\n");
                    flujo.readUTF();
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return registro;
    }

    public void cerrarArchivo() {
        try {
            flujo.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}