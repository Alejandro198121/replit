package co.edu.udistrital.controller;

public class OrdenarVariables {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 7;
        int d = 1;

        int[] variables = {a, b, c, d};
        int n = variables.length;
        
        // Algoritmo de burbuja para ordenar de menor a mayor
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (variables[j] > variables[j + 1]) {
                    // Intercambiar las variables si están en el orden incorrecto
                    int temp = variables[j];
                    variables[j] = variables[j + 1];
                    variables[j + 1] = temp;
                }
            }
        }

        // Imprimir las variables ordenadas con sus nombres
        String[] nombres = {"a", "b", "c", "d"};
        System.out.println("Variables ordenadas de menor a mayor:");
        for (int i = 0; i < n; i++) {
            System.out.println(nombres[i] + ": " + variables[i]);
        }
    }
}
