/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.archivos.ejemplosBryan;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class AnalizadorDeArchivos {

    File nombreArchivo, file;
    RandomAccessFile flujo;

    public JFileChooser getFileChooser() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        file.showOpenDialog(null);

        return file;
    }

    public void mostrarNombreDelArchivo() {
        nombreArchivo = getFileChooser().getSelectedFile();
        System.out.println("El nombre del archivo selecionado es: \""+nombreArchivo.getName()+"\"");
    }

    public void mostrarDireccionDelArchivo() {
        System.out.println("La direccion del archivo seleccionado es: "+getFileChooser().getSelectedFile().getPath());
    }

    public void crearArchivo() {

        file = new File(getFileChooser().getSelectedFile().getPath());

        try {
            file.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void analizadorDeRuta() {
        
        File listado[];
        int contadorFile = 0, contadorDirectories = 0;
        
        file = getFileChooser().getSelectedFile();
        listado = file.listFiles();

            for (int contador = 0; contador < listado.length; contador++) {
                if (listado[contador].isDirectory()) {
                    contadorDirectories++;
                } else {
                    contadorFile++;
                }
            }
        System.out.println("El directorio contiene " + contadorDirectories + " directorios y " + contadorFile + " archivos");
    }

    public void borrarArchivo() {
        nombreArchivo = getFileChooser().getSelectedFile();
        System.out.println("El archivo :\""+nombreArchivo.getName()+"\" fue eliminado exitosamente!");
        nombreArchivo.delete();
        
    }

    public static void main(String args[]) {
        AnalizadorDeArchivos n = new AnalizadorDeArchivos();
        n.mostrarNombreDelArchivo();
        n.mostrarDireccionDelArchivo();
        n.crearArchivo();
        n.analizadorDeRuta();
        n.borrarArchivo();
    }

}
