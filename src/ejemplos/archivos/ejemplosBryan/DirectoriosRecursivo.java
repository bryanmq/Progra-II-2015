/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.archivos.ejemplosBryan;

import java.io.File;
import java.util.Dictionary;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DirectoriosRecursivo {

    private String strNombreArchivos, strNombreDirectorios;
    private int intCantidadDirectorios;
    private File file[];
    private JFileChooser fileChooser;

    public DirectoriosRecursivo() {
        strNombreArchivos = "--------------NOMBRE DE ARCHIVOS--------------\n";
        strNombreDirectorios = "\n\n--------------NOMBRE DE DIRECTORIOS--------------\n";
    }

    public File getFile() {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile();
    }

    public String recorrerDirectorio(File directorio) {
        if (directorio.isDirectory()) {
            strNombreDirectorios += "\n" + directorio.getName();
            File listado[] = directorio.listFiles();
            for (int index = 0; index < listado.length; index++) {
                recorrerDirectorio(listado[index]);
            }
        } else {
            strNombreArchivos += "\n" + directorio.getName();
        }
        return strNombreArchivos + strNombreDirectorios;
    }

    public static void main(String[] args) {
        DirectoriosRecursivo directoriosRecursivo = new DirectoriosRecursivo();
        JOptionPane.showMessageDialog(null, directoriosRecursivo.recorrerDirectorio(directoriosRecursivo.getFile()));

    }

}
