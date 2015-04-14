/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.archivos.xml;

/**
 *
 * @author Alvaro
 */
public class Categoria {

    private int codCategoria;
    private String nombreCategoria;

    public Categoria(int codCategoria, String nombreCategoria) {
        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
