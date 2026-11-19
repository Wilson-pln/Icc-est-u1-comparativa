package benchmark;

public class Benchmark {

    public static Resultado medir(Runnable accion, String nombre, int sample) {

        // Tiempo inicial
        long actual = System.nanoTime();

        // Ejecutar la operación
        try {
            accion.run();
        } catch (RuntimeException | Error e) {
            throw new IllegalStateException(
                "Falló " + nombre + " con sample " + sample, e
            );
        }

        // Tiempo final
        long fin = System.nanoTime();

        // Crear el resultado fuera del cronómetro
        Resultado resultado = new Resultado(nombre, fin - actual, sample);

        return resultado;
    }
}
