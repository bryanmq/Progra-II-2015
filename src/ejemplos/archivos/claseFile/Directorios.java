/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos.archivos.claseFile;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Ronald
 */
public class Directorios {

    public static void main(String arg[]){
        Directorios directorio=new Directorios();
        //directorio.crearNiveles();
       directorio.mostrarRuta();
//        directorio.analizarRuta();
    }

    public void crearNiveles(){
        File file=new File("raiz");
        file.mkdir();
        file= new File("./raiz/nivel1");
        file.mkdir();
    }
    public void mostrarRuta(){
        File file;
        JFileChooser selector=new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        selector.showOpenDialog(null);

        file=selector.getSelectedFile();

        System.out.println(file.getAbsolutePath());
    }
    
    public void analizarRuta(){
        File file;
        File listado[];
        int contadorFile=0,contadorDirectories=0;
        JFileChooser selector=new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        selector.showOpenDialog(null);

        file=selector.getSelectedFile();

        listado=file.listFiles();

        for (int contador=0;contador<listado.length;contador++){
            if(listado[contador].isDirectory())
                contadorDirectories++;
            else
                contadorFile++;
        }
        System.out.println("El directorio contiene "+contadorDirectories+" directorios y "+contadorFile+" archivos");
    }


}
