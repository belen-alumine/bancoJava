import java.io.*;

public class FileIO {
    public static void escribirArchivo(Movimiento movimiento) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("comprobante.txt"));
            writer.write(movimiento.detalle);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void leerArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("comprobante.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea); // mostrar cada línea en consola
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
