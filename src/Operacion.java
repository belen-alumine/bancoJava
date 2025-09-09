public interface Operacion {
    void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora);
    //String consultarSaldo(Cuenta cuenta);
    void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora);
    void registrarMovimiento(Movimiento movimiento);
}
