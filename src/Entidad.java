import java.util.ArrayList;
import java.util.List;

public class Entidad implements Operacion{
    String nombreBanco;
    List<Cliente> clientes = new ArrayList<Cliente>();
    List<Cuenta> cuentas = new ArrayList<Cuenta>();


    public Entidad(String nombreBanco, List<Cliente> clientes) {
        this.nombreBanco = nombreBanco;
        this.clientes = clientes;
    }

    String getNombre() {
        return this.nombreBanco;
    }

    List<Cliente> getClientes() {
        return this.clientes;
    }

    @Override
    public void pagar(int monto) {

    }

    public Cuenta abrirCuenta(Cliente cliente, TipoCuenta tipoCuenta, Moneda peso) {
        Cuenta cuentaNueva = new Cuenta(tipoCuenta, cliente, Moneda.PESO);
        cuentas.add(cuentaNueva);
        registrarCliente(cliente);
        return cuentaNueva;
    }

    public void registrarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public void acreditar(Cliente cliente, Cuenta cuenta, int monto) {
        cuenta.saldo += monto;
    }
}
