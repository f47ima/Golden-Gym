package gimnasio;

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

    public ArrayList<PersonalTrainer> filtrarPersonalTrainer() {
        ArrayList<PersonalTrainer> personalTrainers = new ArrayList<>();
        for (Entrenador e : entrenadores) {
            if (e instanceof PersonalTrainer p) {
                personalTrainers.add(p);
            }
        }
        return personalTrainers;
    }

    public PersonalTrainer entrenadorConMasClientes() {
        PersonalTrainer entrenadorMasClientes = null;
        ArrayList<PersonalTrainer> personalTrainers = filtrarPersonalTrainer();
        //contains si o si
        if (!personalTrainers.isEmpty()) {
            for (PersonalTrainer p : personalTrainers) {
                if (entrenadorMasClientes == null || p.tieneMasClientes(entrenadorMasClientes)) {
                    entrenadorMasClientes = p;
                }
            }
        } else {
            throw new NullPointerException("No hay Personal Trainers en este Gym");
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
