package gimnasio;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Entrenador {

    private final int legajo;
    private static int LEGAJO_INICIAL = 50_000;
    private final String nombre;
    private final String apellido;
    private final LocalDate anioIngreso;

    public Entrenador(String nombre, String apellido, LocalDate anioIngreso) {
        this.legajo = LEGAJO_INICIAL++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public LocalDate getAnioIngreso() {
        return anioIngreso;
    }

    public abstract double getSueldo();

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getNombreCompletoSueldo() {
        return getNombreCompleto()+ " cobra: $" + getSueldo();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.legajo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || !(obj instanceof Entrenador e)) {
            return false;
        }
        return legajo == e.legajo;
    }

    @Override
    public String toString() {
        String nombreSimple = getClass().getSimpleName();
        return nombreSimple
                + " legajo: " + legajo
                + ", nombre: " + nombre
                + ", apellido: " + apellido
                + ", año de ingreso: " + anioIngreso
                + ", sueldo: $" + getSueldo();
    }
}
