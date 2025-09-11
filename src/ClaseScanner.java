import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClaseScanner {
    static Scanner t = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        // Se instancia Banco
        Set<Cliente> clientes = new HashSet<Cliente>();
        Entidad banco = new Entidad("Galicia", clientes);

        // Se crea cliente
        System.out.println("Bienvenido a Banco Galicia. Ingresá tus datos para hacerte cliente.");
        Cliente cliente = crearCliente();

        Cuenta cuenta = crearCuenta(cliente, banco);


        System.out.println("Genial tu número de cuenta es: " + cuenta.getNro());
        System.out.println("Qué querés hacer ahora?");
        // Opciones de menú.



        // pagar

        //  ver movimientos

        /*
        try {
            // buscar movimiento x
            // settear msj exito
        } catch () {
            // error no se encontró movimiento
            // Settear msj error
        } finally {
            // devolver msj
        }
        */

    }

    private static Cliente crearCliente() {
        String nombre;
        String apellido;
        int dni;
        String fechaNacimiento;

        System.out.println("Tu nombre:");
        nombre = t.nextLine();
        System.out.println("Tu apellido:");
        apellido = t.nextLine();
        System.out.println("Tu dni:");
        dni = t.nextInt();
        System.out.println("Tu fecha de nacimiento:");
        t.nextLine();
        fechaNacimiento = t.nextLine();

        // Se convierte fecha a LocalDate
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);

        // new cliente
        return new Cliente(nombre, apellido, dni, fecha);
    }

    private static Cuenta crearCuenta(Cliente cliente, Entidad banco) {
        String seleccion = "";
        TipoCuenta tipoCuenta;
        Moneda moneda; // Moneda por default

        // Salidas
        System.out.println("Perfecto, " + cliente.nombre + "." + "Ahora necesito que selecciones qué tipo de cuenta querés abrir");
        System.out.println("1 - Caja de Ahorros");
        System.out.println("2 - Cuenta Corriente");
        seleccion = t.nextLine();

        // Se evalua opción, si es cuenta corriente se settea, sino se deja valor por default (caja de ahorros)
        tipoCuenta = seleccion.equals("2") ? TipoCuenta.CUENTA_CORRIENTE : TipoCuenta.CAJA_AHORRO;


        System.out.println("Genial, a continuación seleccioná la moneda.");
        System.out.println("1 - Pesos");
        System.out.println("2 - Dólares");
        System.out.println("3 - Euros");
        seleccion = t.nextLine();

        moneda = Moneda.PESO;
        if (seleccion.equals("2")) moneda = Moneda.DOLAR;
        if (seleccion.equals("3")) moneda = Moneda.EURO;

        // new cuenta
        if (tipoCuenta == TipoCuenta.CAJA_AHORRO) {
            return new CajaAhorro(cliente, moneda, banco);
        } else {
            return new CuentaCorriente(cliente, moneda, banco);
        }
    }
}
