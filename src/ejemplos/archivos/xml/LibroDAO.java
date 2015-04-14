/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.archivos.xml;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Alvaro
 */
public class LibroDAO {

    private Element raiz;
    private Document documento;
    private String rutaDocumento;

    // Constructor que se encarga de crear el DOM y el Documento XML
    private LibroDAO(String rutaDocumento, String nombreRaiz) throws IOException {
        this.rutaDocumento = rutaDocumento;
        this.raiz = new Element(nombreRaiz);
        this.documento = new Document(raiz);
        guardar();
    }

    public static LibroDAO crearDocumento(String rutaDocumento) throws IOException {
        return new LibroDAO(rutaDocumento, "libros");
    }
    // Constructor que se encarga de parsear el Documento XML a un DOM

    private LibroDAO(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        //parseo
        this.documento = saBuilder.build(rutaDocumento);
        this.raiz = documento.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }

    public static LibroDAO abrirDocumento(String rutaDocumento) throws
            JDOMException, IOException {
        return new LibroDAO(rutaDocumento);
    }

    private void guardar() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(documento, System.out); // imprime en la consola
        xMLOutputter.output(documento, new PrintWriter(this.rutaDocumento));
    }

    public void insertarLibro(Libro libro) throws IOException {
        Element eLibro = new Element("libro");
        Element eTitulo = new Element("titulo");
        eTitulo.addContent(libro.getTituloLibro());
        Element eCodCategoria = new Element("codCategoria");
        eCodCategoria.addContent(
                String.valueOf(libro.getCategoria().getCodCategoria()));
        Attribute aSignatura = new Attribute("signatura", libro.getSignatura());
        eLibro.addContent(eTitulo);
        eLibro.addContent(eCodCategoria);
        eLibro.setAttribute(aSignatura);
        raiz.addContent(eLibro);
        guardar();
    }

    public void eliminar(Element libro) {
        raiz.removeContent(libro);
        try {
            guardar();
        } catch (IOException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(Libro libro) {
        Element libroEncontrado = this.buscar(libro.getSignatura());
        libroEncontrado.getChild("titulo").setText(libro.getTituloLibro());
        libroEncontrado.getChild("codCategoria").setText(Integer.toString(libro.getCategoria().getCodCategoria()));
        try {
            guardar();
        } catch (IOException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Element buscar(String signatura) {

        List<Element> elementosLibro = (List<Element>) raiz.getChildren();

        for (Element elemento : elementosLibro) {
            if (elemento.getAttributeValue("signatura").equals(signatura)) {
                return elemento;
            }
        }
        return null;
    }

    public ArrayList<Libro> getLibros() {
        List<Element> elementosLibro = (List<Element>) raiz.getChildren();
        ArrayList<Libro> libros = new ArrayList<Libro>();
        for (Element e : elementosLibro) {
            Libro libro = new Libro();
            libro.setSignatura(e.getAttributeValue("signatura"));
            libro.setTituloLibro(e.getChildText("titulo"));
            int codCategoria = Integer.parseInt(e.getChildText("codCategoria"));
            libro.setCategoria(new Categoria(codCategoria, ""));
            libros.add(libro);
        } //for
        return libros;
    }// getLibros
}
