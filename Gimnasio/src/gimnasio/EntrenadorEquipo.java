package gimnasio;
import java.time.LocalDate;
import java.time.Period;

public class EntrenadorEquipo extends Entrenador {

    private double sueldo_fijo;
    private static final int PRIMER_AUMENTO = 4;
    private static final int SEGUNDO_AUMENTO= 12;
    private static final double ANTIGUEDAD_PRIMER_AUMENTO= 3;
    private static final double ANTIGUEDAD_SEGUNDO_AUMENTO = 6;
   
    public EntrenadorEquipo(String nombre, String apellido, LocalDate anioIngreso, double sueldo_fijo) {
        super(nombre, apellido, anioIngreso);
        this.sueldo_fijo = sueldo_fijo;
    }

    @Override
    public double getSueldo() {
        double sueldo = sueldo_fijo;
        int antiguedad = calcularAntiguedad();

        if (antiguedad >= ANTIGUEDAD_PRIMER_AUMENTO) {
            sueldo = calcularSueldoAumento(PRIMER_AUMENTO);
        } else if (antiguedad >= ANTIGUEDAD_SEGUNDO_AUMENTO) {
            sueldo = calcularSueldoAumento(SEGUNDO_AUMENTO);
        }
        return sueldo;
    }

    private double calcularSueldoAumento(int aumento) {
        return sueldo_fijo * aumento / 100;
    }

    private int calcularAntiguedad() {
        return Period.between(getAnioIngreso(), LocalDate.now()).getYears();
    }

    public double getSueldo_fijo() {
        return sueldo_fijo;
    }

    public  void setSueldoFijo(double nuevo_fijo) {
        sueldo_fijo = nuevo_fijo;
    }

            @Override
    public String toString() {
        return super.toString()+ 
                ", sueldo fijo: " + sueldo_fijo;
    }
}
