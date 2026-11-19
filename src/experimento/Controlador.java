package experimento;

import algoritmos.MetodosOrd;
import benchmark.Benchmark;
import benchmark.Resultado;
import generador.Generador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Controlador {

    public List<Resultado> ejecutar() {

        List<Resultado> resultados = new ArrayList<>();

        int[] tamanios = {10000, 50000, 100000};

        for (int n : tamanios) {

            // Una sola muestra original por tamaño
            int[] base = Generador.generar(n);

            // Preparar Integer[] para V4
            Integer[] baseInteger = new Integer[n];

            for (int i = 0; i < n; i++) {
                baseInteger[i] = base[i];
            }

            // V1: Insertion Sort
            int[] copia1 = base.clone();

            Resultado r1 = Benchmark.medir(
                () -> MetodosOrd.insercion(copia1),
                "V1 Inserción", copia1.length
            );

            validar(base, copia1, "V1 Inserción");
            resultados.add(r1);

            // V2: Merge Sort
            int[] copia2 = base.clone();

            Resultado r2 = Benchmark.medir(
                () -> MetodosOrd.mergeSort(copia2),
                "V2 Merge Sort", copia2.length
            );

            validar(base, copia2, "V2 Merge Sort");
            resultados.add(r2);

            // V3: Arrays.sort con int[]
            int[] copia3 = base.clone();

            Resultado r3 = Benchmark.medir(
                () -> Arrays.sort(copia3),
                "V3 Arrays.sort", copia3.length
            );

            validar(base, copia3, "V3 Arrays.sort");
            resultados.add(r3);

            // V4: Arrays.sort con Comparator
            Integer[] copia4 = baseInteger.clone();

            Comparator<Integer> comparador = (a, b) -> a.compareTo(b);

            Resultado r4 = Benchmark.medir(
                () -> Arrays.sort(copia4, comparador),
                "V4 Arrays.sort con Comparator", copia4.length
            );

            // Convertir a int[] fuera del cronómetro
            int[] resultado4 = new int[n];

            for (int i = 0; i < n; i++) {
                resultado4[i] = copia4[i];
            }

            validar(base, resultado4, "V4 Arrays.sort con Comparator");
            resultados.add(r4);
        }

        return resultados;
    }

    // Validar fuera del cronómetro
    private void validar(int[] original, int[] ordenado, String metodo) {

        // Comprobar que tenga la misma cantidad
        if (original.length != ordenado.length) {
            throw new IllegalStateException(
                metodo + ": cantidad de elementos incorrecta"
            );
        }

        // Comprobar orden ascendente
        for (int i = 1; i < ordenado.length; i++) {

            if (ordenado[i - 1] > ordenado[i]) {
                throw new IllegalStateException(
                    metodo + ": el arreglo no está ordenado"
                );
            }
        }

        // Comprobar que conserve los elementos
        int[] esperado = original.clone();
        Arrays.sort(esperado);

        if (!Arrays.equals(esperado, ordenado)) {
            throw new IllegalStateException(
                metodo + ": se perdieron o cambiaron elementos"
            );
        }
    }
}