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
}