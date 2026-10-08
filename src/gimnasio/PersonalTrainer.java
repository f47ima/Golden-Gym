package gimnasio;

import java.time.LocalDate;

public class PersonalTrainer extends Entrenador {

    private double sueldoMinimo;
    private int nroClientes;
    private double montoXcliente;

    public PersonalTrainer(String nombre, String apellido, LocalDate anioIngreso, double sueldoMinimo, int nroClientes, double montoXcliente) {
        super(nombre, apellido, anioIngreso);
        this.sueldoMinimo = sueldoMinimo;
        this.nroClientes = nroClientes;
        this.montoXcliente = montoXcliente;
    }

    @Override
    public double getSueldo() {
        double sueldo = sueldoMinimo;
        if (!verificarSueldoMinimo()) {
            sueldo = totalMontoClientes();
        }
        return sueldo;
    }

    public double getSueldoMinimo() {
        return sueldoMinimo;
    }

    private double totalMontoClientes() {
        return nroClientes * montoXcliente;
    }

    private boolean verificarSueldoMinimo() {
        return sueldoMinimo > totalMontoClientes();
    }

    public double getMontoXcliente() {
        return montoXcliente;
    }

    public int getNroClientes() {
        return nroClientes;
    }

    public void setSueldoMinimo(double nuevoMinimo) {
        sueldoMinimo = nuevoMinimo;
    }

    public void setNroClientes(int nroClientes) {
        this.nroClientes = nroClientes;
    }

    public void setMontoXcliente(double montoXcliente) {
        this.montoXcliente = montoXcliente;
    }

    public boolean tieneMasClientes(PersonalTrainer p) {
        return nroClientes > p.getNroClientes();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", sueldo minimo: " + sueldoMinimo
                + ", clientes=" + nroClientes
                + ", honorario por cliente=" + montoXcliente;
    }

    /*public PersonalTrainer personalConMasClientes(ArrayList<PersonalTrainer> listaPersonalT) {
        PersonalTrainer entrenadorMasClientes = null;
        for (PersonalTrainer p : listaPersonalT) {
            if (entrenadorMasClientes == null || p.tieneMasClientes(entrenadorMasClientes)) {
                entrenadorMasClientes = p;
            }
        }return entrenadorMasClientes;

    }*/
}
