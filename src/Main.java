import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Se instancian personas
        LocalDate nacEduardo = LocalDate.of(1960, 9, 20);
        Cliente eduardo = new Cliente("Eduardo", "Gonzales", 23444222, nacEduardo);

        LocalDate nacHannaMontana = LocalDate.of(1993, 7, 3);
        Cliente hanna = new Cliente("Hanna", "Montana", 37290129, nacHannaMontana);

        LocalDate nacPepe = LocalDate.of(1973, 7, 19);
        Cliente kioscoPepe = new Cliente("Pepe", "Argento", 17290129, nacHannaMontana);

        // Se instancian bancos sin clientes
        Set<Cliente> clientes = new HashSet<Cliente>();
        Entidad banco = new Entidad("Banco Macro", clientes);

        Set<Cliente> clientes2 = new HashSet<Cliente>();
        Entidad banco2 = new Entidad("Banco Galicia", clientes2);

        System.out.println("Nombre del banco: " + banco.getNombre());
        System.out.println("Nombre del banco2: " + banco2.getNombre());

        // Se agregan clientes al banco
        clientes.add(eduardo);
        clientes.add(hanna);
        clientes.add(kioscoPepe);

        // Se abren cuentas
        eduardo.abrirCajaAhorro(banco, Moneda.PESO);
        Cuenta cuentaEduardo = eduardo.getCuentaDefault();
        eduardo.abrirCajaAhorro(banco, Moneda.PESO);

        hanna.abrirCajaAhorro(banco, Moneda.PESO);
        Cuenta cuentahanna = hanna.getCuentaDefault();

        kioscoPepe.abrirCajaAhorro(banco, Moneda.PESO);
        Cuenta cuentaPepe = kioscoPepe.getCuentaDefault();

        System.out.println("Cuenta: " + cuentaEduardo.getTipoCuenta() + " - " + cuentaEduardo.getNro());

        // Banco deposita a clientes
        System.out.println("Saldo: " + cuentaEduardo.getSaldo());
        banco.acreditar(eduardo, cuentaEduardo, 500000);
        System.out.println("Nuevo saldo: " + cuentaEduardo.getSaldo());

        // Cliente selecciona cuenta y realiza un pago.
        eduardo.pagar(cuentaEduardo, 3900, cuentaPepe);
        System.out.println("Saldo después de pagar: " + cuentaEduardo.getSaldo());
        System.out.println("Saldo después de que le paguen: " + cuentaPepe.getSaldo());

        // Selecciona cuenta secundaria sin saldo
        eduardo.seleccionarCuentaPorID(234442222);
        Cuenta cuentaSecEduardo = eduardo.getCuentaSeleccionada();
        eduardo.seleccionarCuentaPorID(234442222);
        System.out.println("Cuenta seleccionada: " + eduardo.getCuentaSeleccionada().getNro());
        // eduardo.pagar(cuentaSecEduardo, 7000, cuentaPepe); // error sin saldo

        // Ver movimientos realizados por el cliente - iteración, set, list, etc.
        List<Movimiento> movsEduardo = new ArrayList<>();
        movsEduardo = eduardo.obtenerMovimientos(cuentaEduardo);
        System.out.println("Cant de movimientos de eduardo: " + movsEduardo.size());
        LocalDate fechaBusq = LocalDate.of(2025, 9, 11);
        // eduardo.buscarMovimientoPorFecha(cuentaSecEduardo, fechaBusq);  // error, no encuentra mov
        Movimiento movDeHoy = eduardo.buscarMovimientoPorFecha(cuentaEduardo, fechaBusq);
        String detalleMov = movDeHoy.getDetalle();
        System.out.println("----------------------------------------");
        System.out.println(detalleMov);
        System.out.println("----------------------------------------");


        // Imprimir comprobante de movimientos - salida
        FileIO.escribirArchivo(movDeHoy);  // Guarda el comprobante en un comprobante.txt
        Archivo.buscarArchivo(); // busca el archivo de recién (modificar para que sea dinámico)
        FileIO.leerArchivo(); // lee el archivo que se creó recién. (modificar para que sea dinámico)

        // Bloquear cuenta - streams

        // Intentar transferir a una cuenta bloqueada - excepciones

        //
    }

}