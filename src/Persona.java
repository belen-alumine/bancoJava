import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Persona {
    public String nombre;
    public String apellido;
    public int dni;
    public LocalDate nacimiento;
    public String telefono;
    List<Entidad> bancos = new ArrayList<Entidad>();


    public Persona(String nombre, String apellido, int dni, LocalDate nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = nacimiento;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
