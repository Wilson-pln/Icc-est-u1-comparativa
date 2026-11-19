public class Benchmark {
    

    public static Results medir(Runnable accion, String nombre, String sample){
        
        // tiempo actual
        long actual = System.nanoTime();
        //accion
        accion.run();
        //tiempo final
        long fin = System.nanoTime();
        //retornar el tiempo duracion 
        

        Results results = new Results(nombre, (fin - actual), sample);
        return results;
    }

}
