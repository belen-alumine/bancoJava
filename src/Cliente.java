import java.time.LocalDate;
import java.util.*;

public class Cliente extends Persona implements Operacion {
    String id;
    String pass;
    //HashMap<String, String> credenciales = new HashMap<>();
    Set<Cuenta> cuentas = new HashSet<Cuenta>();
    List<Movimiento> movimientos = new ArrayList<Movimiento>();
    Cuenta cuentaSeleccionada;
    Cuenta cuentaDefault;

    public Cliente(String nombre, String apellido, int dni, LocalDate nacimiento) {
        super(nombre, apellido, dni, nacimiento);
        //this.credenciales.put(id, pass);
    }

    @Override
    public void pagar(Cuenta cuenta, int monto, Cuenta cuentaReceptora) {
        int saldo = cuenta.getSaldo();
        if (saldo > monto) {
            cuenta.pagar(cuenta, monto, cuentaReceptora);
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

    }

    @Override
    public void registrarMovimiento(int monto, Cuenta cuenta, Cuenta cuentaReceptora) {

    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {

    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public Cuenta getCuentaDefault() {
        return cuentaDefault;
    }

    public void setSeleccionDeCuenta(Cuenta cuenta) {
        this.cuentaSeleccionada = cuenta;
    }

    public Cuenta getSeleccionDeCuenta() {
        return this.cuentaSeleccionada;
    }

    public void abrirCuentaCorriente(Entidad banco, Moneda moneda) {
        Cuenta cuentaNueva = banco.abrirCuentaCajaAhorro(this, moneda);

        if (cuentas.isEmpty()) {
            this.cuentaDefault = cuentaNueva;
        }
        cuentas.add(cuentaNueva);
    }

    public void abrirCajaAhorro(Entidad banco, Moneda moneda) {
        Cuenta cuentaNueva = banco.abrirCuentaCajaAhorro(this, moneda);
        if (cuentas.isEmpty()) {
            this.cuentaDefault = cuentaNueva;
        }
        cuentas.add(cuentaNueva);
    }

    public Set<Cuenta> verCuentas() {
        return cuentas;
    }

    public void seleccionarCuentaPorID(int id) {
        for (Cuenta cuenta : cuentas) {
            int nro = cuenta.getNro();
            if (nro == id) {
                setSeleccionDeCuenta(cuenta);
            }
        }
    }

    public Cuenta getCuentaSeleccionada() {
        return this.cuentaSeleccionada;
    }

    public void tipoYNroDeCuenta() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }
   /*
    public String generarId() {
        int min = 100000;
        int max = 999999;
        int num = (int)(Math.random() * (max - min + 1)) + min;
        return String.valueOf(num);
    }

    public void generarPass() {
        int dni = this.getDni();
        pass = String.valueOf(dni).substring(0, pass.length() - 4);
        this.pass = pass;
    }

    public void cambiarPass(String id, String nuevaPass) {
        this.credenciales.put(id, nuevaPass);
    }

    public HashMap<String, String> getIdYPass() {
        return this.credenciales;
    }
    */
}
