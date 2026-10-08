package gimnasio;

import java.time.LocalDate;

public class Gimnasios {

    public static void main(String[] args) {
        Gym golden = new Gym();
        Utilitarios.harcodearDatos(golden);

        PersonalTrainer p = golden.entrenadorConMasClientes();
        Utilitarios.mostrarSueldos(golden);
        System.out.println(p);

    }



}
