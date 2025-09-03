import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Se instancia una persona
        LocalDate nacEduardo = LocalDate.of(1960, 9, 20);
        Cliente eduardo = new Cliente("Eduardo", "Gonzales", 23444222, nacEduardo);


        // Se instancia un banco sin clientes
        List<Cliente> clientes = new ArrayList<Cliente>();
        Entidad banco = new Entidad("Banco Macro", clientes);

        System.out.println("Nombre del banco: " + banco.getNombre());

        // Se agrega un cliente
        clientes.add(eduardo);

        // Cliente abre cuenta
        eduardo.abrirCuenta(banco, TipoCuenta.CAJA_AHORRO, Moneda.PESO);
        Cuenta cuentaEduardo = eduardo.getCuentas().getFirst();
        System.out.println("Cuenta: " + cuentaEduardo.getTipoCuenta() + " - " + cuentaEduardo.getNro());

        // Banco deposita a cliente
        System.out.println("Saldo: " + cuentaEduardo.getSaldo());
        banco.acreditar(eduardo, cuentaEduardo, 500000);
        System.out.println("Nuevo saldo: " + cuentaEduardo.getSaldo());
        // Cliente selecciona cuenta y realiza un pago.
        eduardo.pagar(500);


    }

}