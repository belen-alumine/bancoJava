import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Operacion {
    List<Cuenta> cuentas = new ArrayList<Cuenta>();
    Cuenta cuentaSeleccionada;

    public Cliente(String nombre, String apellido, int dni, LocalDate nacimiento) {
        super(nombre, apellido, dni, nacimiento);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setSeleccionDeCuenta(Cuenta cuenta) {
        this.cuentaSeleccionada = cuenta;
    }

    public Cuenta getSeleccionDeCuenta() {
        return this.cuentaSeleccionada;
    }

    @Override
    public void pagar(int monto) {
        cuentaSeleccionada.pagar(monto);
    }


    public void abrirCuenta(Entidad banco, TipoCuenta tipoCuenta, Moneda moneda) {
        Cuenta cuentaNueva = banco.abrirCuenta(this, tipoCuenta, Moneda.PESO);

        cuentas.add(cuentaNueva);
    }

    public void tipoYNroDeCuenta() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }
}
