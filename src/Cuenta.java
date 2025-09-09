public abstract class Cuenta implements Operacion{
    public TipoCuenta tipoCuenta;
    public int nro;
    public Cliente titular;
    public Moneda moneda;
    public int saldo;
    public Entidad entidad;

    public Cuenta(Cliente titular, Moneda moneda, Entidad entidad) {
        this.titular = titular;
        this.moneda = moneda;
        this.entidad = entidad;
        this.nro = generarNumeroDeCuenta();
    }

    @Override
    public void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora) {
        Entidad bancoReceptor = cuentaReceptora.getEntidadBancaria();
        Cliente clienteReceptor = cuentaReceptora.getTitular();
        this.descontarSaldo(cuenta, monto);
        entidad.realizarDeposito(cuentaReceptora, monto);
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
}
