import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cuenta implements Operacion{
    public TipoCuenta tipoCuenta;
    public int nro;
    public Cliente titular;
    public Moneda moneda;
    public int saldo;
    public EstadoDeCuenta estadoDeCuenta;
    public Entidad entidad;
    List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public Cuenta(Cliente titular, Moneda moneda, Entidad entidad) {
        this.titular = titular;
        this.moneda = moneda;
        this.entidad = entidad;
        this.nro = generarNumeroDeCuenta();
        this.estadoDeCuenta = EstadoDeCuenta.ACTIVA;
    }

    @Override
    public void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora) {
        Entidad bancoReceptor = cuentaReceptora.getEntidadBancaria();
        Cliente clienteReceptor = cuentaReceptora.getTitular();
        this.descontarSaldo(cuenta, monto);
        entidad.realizarDeposito(cuentaReceptora, monto);
    }

    @Override
    public List<Movimiento> obtenerMovimientos(Cuenta cuenta) {
        return getMovimientos();
    }

    @Override
    public Movimiento buscarMovimientoPorFecha(Cuenta cuenta, LocalDate fecha) {
        for (Movimiento movimiento : getMovimientos()) {
            if (movimiento.getFecha().equals(fecha)) {
                return movimiento;
            }
        }
        throw new MovimientoNotFoundException("No se encontro el movimiento");
    }

    public int generarNumeroDeCuenta() {
        assert titular != null;
        String dni = String.valueOf(titular.getDni());
        int cantidad = titular.getCuentas().size() + 1;
        String numeroCuentaStr = dni + cantidad;

        return Integer.parseInt(numeroCuentaStr);
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public int getNro() {
        return nro;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void descontarSaldo(Cuenta cuenta, int monto) {
        this.saldo -= monto;
    }

    public Entidad getEntidadBancaria() {
        return entidad;
    }

    public EstadoDeCuenta getEstadoDeCuenta() {
        return estadoDeCuenta;
    }

    public void setEstadoDeCuenta(EstadoDeCuenta estadoDeCuenta) {
        this.estadoDeCuenta = estadoDeCuenta;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public String getNombre() {
        return titular.getNombre();
    }

    public String getApellido() {
        return titular.getApellido();
    }

    public int getDni() {
        return titular.getDni();
    }
}
