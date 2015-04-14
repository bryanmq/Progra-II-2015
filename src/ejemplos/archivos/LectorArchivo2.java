package ejemplos.archivos;


import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LectorArchivo2 {

    RandomAccessFile flujo;

    public LectorArchivo2() {

        try {
            flujo = new RandomAccessFile("D:\\ProgramacionII\\archivos\\nombre.txt", "r");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public LectorArchivo2(String ruta) {

        try {
            flujo = new RandomAccessFile(ruta, "r");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public JTextArea readArchivo() {
        JTextArea registro = new JTextArea();
        registro.setText("Nombre          salario\n");

        try {
            int cont = 0;
            do {
                cont++;
                int i = 1 + (int) (Math.random() * 9);
                System.err.println(i);
                System.err.println(flujo.getFilePointer());
                int x = 0;
                flujo.seek(0);

                while (x < i) {
                    flujo.readUTF();
                    flujo.readLong();
                    flujo.readUTF();
                    ++x;
                }
                registro.append(flujo.readUTF() + "\t");
                registro.append(flujo.readLong() + "\n");
                flujo.readUTF();
            } while (cont <= 3);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo ", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return registro;
    }

    public void cerrarArchivo() {
        try {
            flujo.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}