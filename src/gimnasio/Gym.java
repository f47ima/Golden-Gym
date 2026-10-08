package gimnasio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Gym {

    private final ArrayList<Entrenador> entrenadores = new ArrayList<>();;

    public void agregarEntrenador(Entrenador e) {
        Objects.requireNonNull(e, "Entrenador nulo");
        if (entrenadores.contains(e)) {
            throw new IllegalArgumentException("Entrenador repetido");
        }
        entrenadores.add(e);
    }

    public PersonalTrainer entrenadorConMasClientes() {
        // Arranca en null, sin crear objetos falsos
        PersonalTrainer entrenadorMasClientes = null; 

        for (Entrenador e : entrenadores) {
            if (e.getClass().equals(PersonalTrainer.class)) {
                PersonalTrainer pt = (PersonalTrainer) e; // Cast para usar sus métodos

                // SI es el primero que encontramos (es null) OR si el actual tiene más clientes que el que ya guardamos
                if (entrenadorMasClientes == null || pt.tieneMasClientes(entrenadorMasClientes)) {
                    entrenadorMasClientes = pt; // Se convierte en el nuevo máximo
                }
            }
        }

        return entrenadorMasClientes;
    }   

    public String listarSueldos() {
        StringBuilder sb = new StringBuilder();
        for (Entrenador e : entrenadores) {
            sb.append(e.getNombreCompletoSueldo());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /*public PersonalTrainer entrenadorConMasClientes() {
        //LA ia propuso el null para que se trabaje ese null por fuera
        //mio PersonalTrainer entrenadorMasClientes = new PersonalTrainer(0, 0.0, "", "", "", 0);
        PersonalTrainer entrenadorMasClientes = null; //ia
        for (Entrenador e : entrenadores) {
            if (e instanceof PersonalTrainer p) {
                //mio if (p.tieneMasClientes(entrenadorMasClientes)) {
                if (entrenadorMasClientes == null || p.tieneMasClientes(entrenadorMasClientes)) {
                    entrenadorMasClientes = p;
                }
            }
        }
        return entrenadorMasClientes;
    }*/
}
