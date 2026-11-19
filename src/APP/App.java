
package app;

import benchmark.Resultado;
import experimento.Controlador;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();

        List<Resultado> resultados = controlador.ejecutar();

        // Imprimir todos los resultados al finalizar
        for (Resultado r : resultados) {
            System.out.println(r);
        }
    }
}

