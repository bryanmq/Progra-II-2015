package ejemplos.archivos;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Reporte extends JFrame{

   public Reporte()
   {
     Container contenedor=getContentPane();
     JTextArea reporte;

     LectorArchivo lector=new LectorArchivo();
     reporte=lector.readArchivo();

     contenedor.add(reporte,BorderLayout.CENTER);

     setSize(300,300);
     setVisible(true);

   }

   public static void main(String arg[])
   {
     Reporte reporte=new Reporte();
     reporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}