import java.util.List;

public class Cuenta implements Operacion{
    public TipoCuenta tipoCuenta;
    public int nro;
    public Persona titular;
    public Moneda moneda;
    public int saldo;

    public Cuenta(TipoCuenta tipoCuenta, Persona titular, Moneda moneda) {
        this.tipoCuenta = tipoCuenta;
        this.nro = generarNumeroDeCuenta();
        this.titular = titular;
        this.moneda = moneda;
    }

    public int generarNumeroDeCuenta() {
        return  (int) (Math.random() * 100 + 1);
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

    public Persona getTitular() {
        return titular;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    @Override
    public void pagar(int monto) {
        this.descontarSaldo(monto);
    }

    public void descontarSaldo(int monto) {
        this.saldo -= monto;
    }
}
