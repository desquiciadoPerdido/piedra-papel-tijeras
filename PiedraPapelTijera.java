
import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int puntuacion = 0;

        do {
            System.out.println("Elige 'piedra', 'papel' o 'tijeras' para jugar, !puntos para ver tu puntuación, o '!salir' para salir del programa.");
            String opcionUsuario = sc.nextLine().toLowerCase().trim();

            String opcionComputadora = opcionAleatoria(random);

            if (opcionUsuario.equals("!salir")) {
                System.out.println("¡Adiós!");
                sc.close();
                System.exit(0);
            }

            if (opcionUsuario.equals("!puntos")) {
                System.out.printf("Llevas %d puntos. ", puntuacion);

            } else if (opcionValida(opcionUsuario)) {
                puntuacion += resultadoYPuntuacion(opcionUsuario, opcionComputadora);

            } else if (opcionUsuario.isBlank()) {
                System.out.println("Anda, escribe algo...");

            } else {
                System.err.println("Opción inválida");
            }
            System.out.println("");
        } while (true);
    }

    static boolean opcionValida(String opcionUsuario) {
        return opcionUsuario.equals("piedra") || opcionUsuario.equals("papel") || opcionUsuario.equals("tijeras");
    }

    static String opcionAleatoria(Random random) {
        String[] opciones = {"piedra", "papel", "tijeras"};
        return opciones[random.nextInt(opciones.length)];
    }

    /**
     * Método que devuelve la puntuación en caso de jugar
     * @param opcionUsuario opción que elige el usuario
     * @param opcionComputadora opción que elige el ordenador
     * @return int puntos
     */
    static int resultadoYPuntuacion(String opcionUsuario, String opcionComputadora) {
        if (opcionUsuario.equals(opcionComputadora)) {
            int puntosEmpate = 50;
            System.out.printf("Hay un empate. El ordenador también eligió %s.\n", opcionComputadora);
            return puntosEmpate;
        } else {
            boolean ganador = ganador(opcionComputadora, opcionUsuario);

            int puntos = 0;
            if (ganador) {
                System.out.printf("Bien hecho. El ordenador eligió %s y perdió\n", opcionComputadora);
                puntos = 100;
            } else {
                System.out.printf("Lo siento, pero el ordenador eligió %s\n", opcionComputadora);
            }
            return puntos;
        }
    }

    static boolean ganador(String opcionComputadora, String opcionUsuario) {
        return (opcionComputadora.equals("tijeras") && opcionUsuario.equals("piedra"))
                || (opcionComputadora.equals("piedra") && opcionUsuario.equals("papel"))
                || (opcionComputadora.equals("papel") && opcionUsuario.equals("tijeras"));
    }
}
