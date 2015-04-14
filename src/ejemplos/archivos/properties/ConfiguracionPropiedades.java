package ejemplos.archivos.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Esta clase es un Singleton encargado de trabajar con cualquier archivo de
 * tipo .properties el cual permite leer archivos en el formato clave=valor
 *
 * @author ogonzalez
 */
public class ConfiguracionPropiedades {

    private Properties properties = null;
    private String rutaArchivo = "";
    private File archivo = null;

    private ConfiguracionPropiedades() {
    }

    public static ConfiguracionPropiedades getInstance() {
        return ConfiguracionPropiedades_Client.instance;
    }

    /**
     * Este método permite abrir el archivo properties para cargarlo en memoria
     * y acceder a sus propiedades Si el archivo no existe , envía un mensaje y
     * se cierra la aplicación
     *
     * @param rutaArchivo
     */
    public void incializarArchivo(String rutaArchivo) {
        archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.err.println("Archivo no encontrado");
            System.exit(0);
        } else {
            this.setRuta(rutaArchivo);
            properties = new Properties();
            this.cargar(this.getRuta());
        }
    }

    private static class ConfiguracionPropiedades_Client {

        private static ConfiguracionPropiedades instance = new ConfiguracionPropiedades();
    }

    /**
     * Retorna la ruta del archivo
     *
     * @return
     */
    public String getRuta() {
        return rutaArchivo;
    }

    /**
     * Permite asignarle la ruta al archivo
     *
     * @param rutaArchivo
     */
    public void setRuta(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Retorna un Enumeration con todas las claves del archivo de properties
     *
     * @return
     */
    public Enumeration getClaves() {
        return properties.keys();
    }

    /**
     * Se encarga de asignar una nueva propiedad al archivo
     *
     * @param clave
     * @param valor
     */
    public void setPropiedad(String clave, String valor) {
        properties.setProperty(clave, valor);
    }

    /**
     * Este método retorna el valor de una clave del archivo de properties
     *
     * @param clave
     * @return
     */
    public String getPropiedad(String clave) {
        return properties.getProperty(clave);
    }

    /**
     * Este método carga en memoria el archivo de propiedades de acuerdo a la
     * ubicación , la carga de hace a través de un FileInputStream
     *
     * @param ruta
     */
    public void cargar(String ruta) {
        try {
            properties.load(new FileInputStream(ruta));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Este método permite abrir el archivo properties para cargarlo en memoria
     * y acceder a sus propiedades Si el archivo no existe , envía un mensaje y
     * se cierra la aplicación
     *
     * @param rutaArchivo
     */
    public void incializarArchivo(InputStream archivo, String ruta) {
        this.setRuta(ruta);
        InputStream in = getClass().getResourceAsStream(ruta);
        if (in == null) {
            System.err.println("Archivo no encontrado");
            System.exit(0);
        }
        properties = new Properties();
        this.cargar(in);
    }

    /**
     * Este método carga en memoria el archivo de propiedades de acuerdo a la
     * ubicación , la carga de hace a través de un FileInputStream
     *
     * @param ruta
     */
    public void cargar(InputStream archivo) {
        try {
            properties.load(archivo);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Si se agregaron nuevas propiedades al archivo este metodo salva los
     * cambios
     *
     */
    public void salvarCambios() {
        try {
            properties.store(new FileOutputStream(this.getRuta()), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}