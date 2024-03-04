import java.util.Scanner;

public class CribaRefactorizado {

    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; 
            // Vector vacío
        }
        
        // Tamaño del array
        int dim = max + 1; 
        boolean[] esPrimo = new boolean[dim];

        // Inicializar el array
        for (int i = 0; i < dim; i++) {
            esPrimo[i] = true;
        }

        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;

        // Criba
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        // ¿Cuántos primos hay?
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }

        // Rellenar el vector de números primos
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();

        imprimirVectorInicial(dato);

        int[] vectorPrimos = generarPrimos(dato);

        imprimirVectorPrimos(vectorPrimos);
    }

    private static void imprimirVectorInicial(int dato) {
        System.out.println("\nVector inicial hasta: " + dato);
        for (int i = 0; i < dato; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
    }

    private static void imprimirVectorPrimos(int[] vectorPrimos) {
        System.out.println("\nVector de primos hasta: " + vectorPrimos.length);
        for (int i = 0; i < vectorPrimos.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vectorPrimos[i] + "\t");
        }
    }
}
