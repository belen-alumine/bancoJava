public class CajaAhorro extends Cuenta{

    public CajaAhorro(Cliente titular, Moneda moneda, Entidad entidad) {
        super(titular, moneda, entidad);
        this.tipoCuenta = TipoCuenta.CAJA_AHORRO;
    }

    @Override
    public void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora) {

    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {

    }
}
