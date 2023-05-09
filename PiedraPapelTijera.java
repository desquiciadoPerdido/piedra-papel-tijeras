
import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Introduce tu nombre: ");
        String name = sc.nextLine();
        System.out.printf("Hola, %s. ", name);

        do {
            System.out.println("Elige 'piedra', 'papel' o 'tijeras' para jugar o '!salir' para terminar el programa.");
            String opcionUsuario = sc.nextLine().toLowerCase().trim();

            String opcionComputadora = opcionAleatoria(random);

            if (opcionUsuario.equals("!salir")) {
                System.out.println("¡Adiós!");
                sc.close();
                System.exit(0);
            }

            if (opcionValida(opcionUsuario)) {
                imprimirResultado(opcionUsuario, opcionComputadora);

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

    static void imprimirResultado(String opcionUsuario, String opcionComputadora) {
        if (opcionUsuario.equals(opcionComputadora)) {
            System.out.printf("Hay un empate. El ordenador también eligió %s.\n", opcionComputadora);
        } else {
            boolean ganador = ganador(opcionComputadora, opcionUsuario);
            System.out.printf(ganador ? "Bien hecho. El ordenador eligió %s y perdió\n" : "Lo siento, pero el ordenador eligió %s\n", opcionComputadora);
        }
    }
    
    /**
     * Método que devuelve si el usuario ha ganado al ordenador
     * @param opcionComputadora opción que elige el ordenador
     * @param opcionUsuario opción que elige el usuario
     * @return boolean
     */
    static boolean ganador(String opcionComputadora, String opcionUsuario) {
        return (opcionComputadora.equals("tijeras") && opcionUsuario.equals("piedra"))
                || (opcionComputadora.equals("piedra") && opcionUsuario.equals("papel"))
                || (opcionComputadora.equals("papel") && opcionUsuario.equals("tijeras"));
    }
}
