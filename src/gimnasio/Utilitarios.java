package gimnasio;

import java.time.LocalDate;

public interface Utilitarios {

    public static void harcodearDatos(Gym gym) {

        PersonalTrainer juan = new PersonalTrainer("Juan", "Perez", LocalDate.of(2022, 1, 1), 100000, 5, 50000.0);
        PersonalTrainer maria = new PersonalTrainer("Maria", "Lopez", LocalDate.of(2015, 1, 1), 200000, 10, 60000.0);
        PersonalTrainer carlos = new PersonalTrainer("Carlos", "Garcia", LocalDate.of(2018, 1, 1), 300000, 50, 45000.0);
        EntrenadorEquipo ana = new EntrenadorEquipo("Ana", "Martinez", LocalDate.of(2019, 1, 1), 400000);
        EntrenadorEquipo luis = new EntrenadorEquipo("Luis", "Rodriguez", LocalDate.of(2015, 1, 1), 500000);
        EntrenadorEquipo sofia = new EntrenadorEquipo("Sofia", "Fernandez", LocalDate.of(2012, 1, 1), 900000);

        gym.agregarEntrenador(juan);
        gym.agregarEntrenador(maria);
        gym.agregarEntrenador(carlos);
        gym.agregarEntrenador(ana);
        gym.agregarEntrenador(luis);
        gym.agregarEntrenador(sofia);
    }

    public static void mostrarSueldos(Gym gym) {
        System.out.println(gym.listarSueldos());
    }

}
