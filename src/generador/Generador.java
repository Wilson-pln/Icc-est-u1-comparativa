package generador;

import java.util.Random;

public class Generador {

    // Genera n números aleatorios entre 0 y n
    public static int[] generar(int n) {

        if (n < 0 || n == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Tamaño no válido: " + n);
        }

        Random random = new Random();
        int[] muestra = new int[n];

        for (int i = 0; i < n; i++) {
            muestra[i] = random.nextInt(n + 1);
        }

        return muestra;
    }
}
