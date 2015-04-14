/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.archivos.properties;

/**
 *
 * @author ronald
 */
public class PruebaProperties {
    
    public static void main(String args[]){
        ConfiguracionPropiedades analizador=ConfiguracionPropiedades.getInstance();
        analizador.incializarArchivo("src/ejemplos/archivos/properties/configuracion.properties");
        System.out.println(analizador.getPropiedad("1"));
    }  
}
