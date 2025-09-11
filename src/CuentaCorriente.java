import java.time.LocalDate;
import java.util.List;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(Cliente titular, Moneda moneda, Entidad entidad) {
        super(titular, moneda, entidad);
        this.tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
    }

    @Override
    public void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora) {

    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {

    }

    @Override
    public void bloquearCuenta(Cuenta cuenta) {

    }

    @Override
    public List<Movimiento> obtenerMovimientos(Cuenta cuenta) {
        return List.of();
    }

    @Override
    public Movimiento buscarMovimientoPorFecha(Cuenta cuenta, LocalDate fecha) {
        return null;
    }
}