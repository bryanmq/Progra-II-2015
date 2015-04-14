package ejemplos.archivos.objetos.lector;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ejemplos.archivos.objetos.personas.Persona;

public class LectorObjetos {

    private ObjectInputStream ois = null;
    private FileInputStream fis = null;
    private File archivo = null;
    private Persona persona = null;

    public LectorObjetos(String nombreArchivo) {
        try {
            archivo = new File("/media/datos/"+nombreArchivo);
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.err.println("Error al crear flujo al archivo");
            e.printStackTrace();
        }
    }

    public String readObjects() {
        String texto = "";
        try {
            Object aux = null;
            while ((aux = ois.readObject()) != null) {//mientras halla mas objetos
                if (aux instanceof Persona) {
                    persona = (Persona) aux;
                    texto += persona.getNombre() + "                           " + persona.getEdad() + "\n";
                }
            }
            ois.close();
        } catch (ClassNotFoundException c) {
        } catch (EOFException eof) {
        } catch (IOException e) {
        }
        return texto;
    }
}
