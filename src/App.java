import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    Generador g = new Generador();

    Benchmark b = new Benchmark();


    List<Integer> list = g.generate((100000));
    System.out.println(list);
    Results benGenList = b.medir(
        () -> g.generate((100000)), 
        "Generacion de Listado", "100");

    System.out.println(benGenList);




        /* 
        long nanoTime = System.nanoTime();
        
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Nano Time: " + nanoTime);
        System.out.println("Current Time: " + currentTimeMillis);
        

        Runnable x = () -> {
            System.out.println("Ejecutando tarea 1");
            System.out.println("Ejecutando tarea 2");
        };
        List<Integer> list = new ArrayList<>();
        MetodosOrd mO = new MetodosOrd();
        mO.ordenarBurbuja(list);

        Runnable burbujaOrden = () -> mO.burbuja(list);
            //Callable<T> x
        System.out.println("Ejecucion de la funcion Runnable");
        x.run();
*/

    }
    
}
