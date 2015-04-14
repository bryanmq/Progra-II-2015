package ejemplos.archivos.objetos.miStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiFlujo extends ObjectOutputStream
{
   public MiFlujo(OutputStream out) throws IOException
    {
        super(out);
    }
    @Override
   protected void writeStreamHeader() throws IOException{}
}