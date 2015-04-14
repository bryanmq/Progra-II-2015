package ejemplos.archivos.objetos.escritor;

import ejemplos.archivos.objetos.miStream.MiFlujo;
import ejemplos.archivos.objetos.personas.Persona;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscritorObjetos {

    private MiFlujo miFlujo = null;
    private ObjectOutputStream oos = null;
    private FileOutputStream fos = null;
    private File archivo = null;
    private boolean cabeceraInicio = false;// me dice si escribo la cabecera de inicio

    public EscritorObjetos(String nombre) {
        try {
            archivo = new File("/media/datos/" + nombre);
            if (archivo.exists()) {//si el archivo existe entonces escribe sin dejar cabeceras
                fos = new FileOutputStream(archivo, archivo.exists());
                miFlujo = new MiFlujo(fos);
                System.out.println(archivo.exists());
            } else {
                fos = new FileOutputStream(archivo, false);
                System.out.println(archivo.exists());
                oos = new ObjectOutputStream(fos);
                cabeceraInicio = true;
            }
        } catch (IOException e) {
            System.err.println("Error al crear flujo al archivo");
        }
    }

    public boolean añadirObject(Persona persona) {
        boolean exito = false;
        try {
            if (cabeceraInicio == false) {//quiere decir que ya existe la cabecera de inicio , y que 
                //puedo escribir sin dejar cabeceras cada vez que abro el archivo
                miFlujo.writeUnshared(persona);
                miFlujo.reset();
                exito = true;
            } else {
                oos.writeUnshared(persona);
                oos.reset();
                exito = true;
            }
        } catch (IOException e) {
        }
        return exito;
    }

    public void cerrarArchivo() {
        try {
            if (cabeceraInicio == false) {
                miFlujo.close();
            } else {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
