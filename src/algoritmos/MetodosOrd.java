
package algoritmos;

public class MetodosOrd {

    // V1: Insertion Sort
    public static void insercion(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int actual = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > actual) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = actual;
        }
    }

    // V2: Merge Sort
    public static void mergeSort(int[] a) {

        if (a.length < 2) {
            return;
        }

        int medio = a.length / 2;

        int[] izq = new int[medio];
        int[] der = new int[a.length - medio];

        for (int i = 0; i < izq.length; i++) {
            izq[i] = a[i];
        }

        for (int i = 0; i < der.length; i++) {
            der[i] = a[medio + i];
        }

        mergeSort(izq);
        mergeSort(der);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izq.length && j < der.length) {

            if (izq[i] <= der[j]) {
                a[k] = izq[i];
                i++;
            } else {
                a[k] = der[j];
                j++;
            }

            k++;
        }

        while (i < izq.length) {
            a[k] = izq[i];
            i++;
            k++;
        }

        while (j < der.length) {
            a[k] = der[j];
            j++;
            k++;
        }
    }
}
