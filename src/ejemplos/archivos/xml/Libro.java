/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos.archivos.xml;

/**
 *
 * @author Alvaro
 */
public class Libro {
    private String signatura;
    private String tituloLibro;
    private Categoria categoria;

    public Libro() {
    }

    public Libro(String signatura, String tituloLibro, Categoria categoria) {
        this.signatura = signatura;
        this.tituloLibro = tituloLibro;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }



}
