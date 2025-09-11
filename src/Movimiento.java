import java.time.LocalDate;
import java.util.List;

public class Movimiento implements Operacion {
    public LocalDate fecha;
    public int monto;
    public Motivo motivo;
    public Cuenta cuentaEmisora;
    public Cuenta cuentaReceptora;
    public String detalle;

    // Constructor con selección de motivo
    public Movimiento(int monto, Motivo motivo, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        this.motivo = motivo;
        setterNuevoMovimiento(monto, cuentaEmisora, cuentaReceptora);
    }
    // Constructor sin selección de motivo
    public Movimiento(int monto, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        this.motivo = Motivo.OTRO;
        setterNuevoMovimiento(monto, cuentaEmisora, cuentaReceptora);
    }
    // Subtarea para sobrecarga de constructores
    public void setterNuevoMovimiento(int monto, Cuenta cuentaEmisora, Cuenta cuentaReceptora) {
        this.fecha = LocalDate.now();
        this.monto = monto;
        this.cuentaEmisora = cuentaEmisora;
        this.cuentaReceptora = cuentaReceptora;
        int nroCtaEmisora = cuentaEmisora.getNro() % 10000; // ver
        int nroCtaReceptora = cuentaReceptora.getNro() % 10000; // ver
        String nombreTitular = cuentaEmisora.getApellido() + " " + cuentaEmisora.getNombre();
        String nombreTercero = cuentaReceptora.getApellido() + " " + cuentaReceptora.getNombre();
        this.detalle =
                "Movimiento\n" +
                        "Titular: " + nombreTitular + " " + "\n" +
                        "Cuenta: " + "XXXX-" + nroCtaEmisora + "\n" +
                        "Monto: " + monto + "\n" +
                        "Destino: " + nombreTercero + " " + "XXXX-" + nroCtaReceptora + "\n" +
                        "Concepto: " + motivo;
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

    public LocalDate getFecha() {
        return fecha;
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

    public String getDetalle() {
        return detalle;
    }
}
