import java.time.LocalDate;

public class Movimiento implements Operacion {
    public LocalDate fecha;
    public int monto;
    public Motivo motivo;
    public Cuenta cuentaEmisora;
    public Cuenta cuentaReceptora;

    // Constructor con selección de motivo
    public Movimiento(int monto, Motivo motivo, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        setterNuevoMovimiento(monto, cuentaEmisora, cuentaReceptora);
        this.motivo = motivo;
    }
    // Constructor sin selección de motivo
    public Movimiento(int monto, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        setterNuevoMovimiento(monto, cuentaEmisora, cuentaReceptora);
    }
    // Subtarea para sobrecarga de constructores
    public void setterNuevoMovimiento(int monto, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        this.fecha = LocalDate.now();
        this.monto = monto;
        this.cuentaEmisora = cuentaEmisora;
        this.cuentaReceptora = cuentaReceptora;
    }

    @Override
    public void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora) {
        registrarMovimiento(monto, cuenta, cuentaReceptora);
    }

    public void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora) {
        Movimiento movimiento = new Movimiento(monto, cuenta, cuentaReceptora);
        Cliente titularCuenta = cuenta.getTitular();
        Entidad banco = cuenta.getEntidadBancaria();

        titularCuenta.registrarMovimiento(movimiento);
        banco.registrarMovimiento(movimiento);
    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {

    }
}
