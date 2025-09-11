import java.time.LocalDate;
import java.util.List;

public interface Operacion {
    void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora);
    //String consultarSaldo(Cuenta cuenta);
    void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora);
    void registrarMovimiento(Movimiento movimiento); // se borra ?
    void bloquearCuenta(Cuenta cuenta);
    List<Movimiento> obtenerMovimientos(Cuenta cuenta);
    Movimiento buscarMovimientoPorFecha(Cuenta cuenta, LocalDate fecha);
}
