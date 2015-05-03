package ejemplos.archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EscritorArchivo2 {
//
    File nombreArchivo;
    RandomAccessFile flujo;

    public EscritorArchivo2() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = file.showSaveDialog(null);

        nombreArchivo = file.getSelectedFile();
        try {
            flujo = new RandomAccessFile(nombreArchivo, "rw");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error l abrir el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeArchivo(String nombreEmpleado, long salario) {


        if (nombreArchivo == null || nombreArchivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre invalido", "Invalido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                flujo.writeUTF(nombreEmpleado);
                flujo.writeLong(salario);
                flujo.writeUTF("\n");


            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "fallo de archivo", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
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
