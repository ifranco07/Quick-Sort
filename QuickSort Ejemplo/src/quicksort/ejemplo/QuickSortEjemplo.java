/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort.ejemplo;

/**
 *
 * @author i_fra
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortEjemplo {
    
    // Función para intercambiar dos elementos en la matriz
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Función para realizar la partición
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Función principal de QuickSort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Función para imprimir la matriz
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese la cantidad de elementos a ordenar:");
        int n = Integer.parseInt(reader.readLine());
        
        int[] arr = new int[n];
        
        System.out.println("Ingrese los elementos:");
        String[] elements = reader.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }

        System.out.println("Arreglo desordenado:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Arreglo ordenado:");
        printArray(arr);
    }
}