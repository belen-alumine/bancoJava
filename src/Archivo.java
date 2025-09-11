import java.io.File;

public class Archivo {
    public static void buscarArchivo() {

        File comprobanteArchivo = new File("C:\\Users\\belen\\IdeaProjects\\Banco\\comprobante.txt"); // Ruta
        System.out.println("Archivo encontrado: " + comprobanteArchivo.exists());

    }
}
