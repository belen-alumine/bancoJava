import java.time.LocalDate;
import java.util.*;

public class Entidad implements Operacion{
    String nombreBanco;
    Set<Cliente> clientes = new HashSet<Cliente>();
    Set<Cuenta> cuentas = new HashSet<Cuenta>();
    //HashMap<String, String> credenciales = new HashMap<>();

    public Entidad(String nombreBanco, Set<Cliente> clientes) {
        this.nombreBanco = nombreBanco;
        this.clientes = clientes;
    }

    @Override
    public void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora) {

    }

    @Override
    public void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora) {
        Movimiento movimiento = new Movimiento(monto, cuenta, cuentaReceptora);
        cuenta.getMovimientos().add(movimiento);
    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {

    }

    @Override
    public void bloquearCuenta(Cuenta cuenta) {
        int idCuenta = cuenta.getNro();
        Cliente cliente = cuenta.getTitular();
        cliente.seleccionarCuentaPorID(idCuenta);
        Cuenta cuentaCliente = cliente.getCuentaSeleccionada();
        cuentas.stream()
                .filter(c -> c.getNro() == cuentaCliente.getNro())
                .forEach(c -> c.setEstadoDeCuenta(EstadoDeCuenta.BLOQUEADA));


        cuentaCliente.setEstadoDeCuenta(EstadoDeCuenta.BLOQUEADA);
    }

    @Override
    public List<Movimiento> obtenerMovimientos(Cuenta cuenta) {
        return List.of();
    }

    @Override
    public Movimiento buscarMovimientoPorFecha(Cuenta cuenta, LocalDate fecha) {
        return null;
    }

    String getNombre() {
        return this.nombreBanco;
    }

    Set<Cliente> getClientes() {
        return this.clientes;
    }

    public Cuenta abrirCuentaCuentaCorriente(Cliente cliente, Moneda moneda) {
        Cuenta cuentaNueva = new CuentaCorriente(cliente, moneda, this);
        cuentas.add(cuentaNueva);
        registrarCliente(cliente);
        return cuentaNueva;
    }

    public Cuenta abrirCuentaCajaAhorro(Cliente cliente, Moneda moneda) {
        Cuenta cuentaNueva = new CajaAhorro(cliente, moneda, this);
        cuentas.add(cuentaNueva);
        registrarCliente(cliente);
        return cuentaNueva;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void acreditar(Cliente cliente, Cuenta cuenta, int monto) {
        cuenta.saldo += monto;
    }

    public void realizarDeposito(Cuenta cuentaReceptora, int monto) {
        Cliente clienteReceptor = cuentaReceptora.getTitular();
        Entidad entidadReceptora = cuentaReceptora.getEntidadBancaria();
        if (clientes.contains(clienteReceptor)) {
            acreditar(clienteReceptor, cuentaReceptora, monto);
        } else  {
            entidadReceptora.acreditar(clienteReceptor, cuentaReceptora, monto);
        }
    }
}
