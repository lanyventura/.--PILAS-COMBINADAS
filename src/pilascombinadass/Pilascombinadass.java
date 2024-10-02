package pilascombinadass;

import java.util.Random;
import java.util.Scanner;

public class Pilascombinadass {

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        int tamañoPila;
        int tope = 0;

        try {
            //System.out.println("Ingresa el tamaño de las pilas");
            //tamañoPila = scc.nextInt();
            String[] arregloLetrasLlenado = new String[1]; // solo una daclaracion

            int[] pilaNumeros = new int[1];
            String[] pilaLetras = new String[1];

            do {
                System.out.println("\nQue deseas hacer? \n1.-Llenar pilas \n2.-Mostrar pilas");
                int opcion1 = scc.nextInt();

                switch (opcion1) {
                    case 1 -> {
                        System.out.println("Que pilas quieres llenar? \n1.-Pila de numeros \n2.-Pila de letras");
                        int opcion2 = scc.nextInt();
                        switch (opcion2) {
                            case 1 ->
                                pilaNumeros = llenarNumero(7);
                            case 2 ->
                                pilaLetras = llenarLetra();

                            default ->
                                System.out.println("Opción no válida.");
                        }
                        //primer case
                    }

                    case 2 -> {
                        System.out.println("\nQue pilas quieres mostrar? \n.1.-Pila de numeros \n2.-Pila de letras \n3.-Pilas unidas");
                        int opcion3 = scc.nextInt();

                        switch (opcion3) {
                            case 1 -> {
                                mostrarNumero(pilaNumeros);
                            }

                            case 2 ->
                                mostrarPilaLetras(pilaLetras);
                                
                            case 3 ->
                                //tienen que llevar el mismo orden
                                unionPilas(pilaNumeros, pilaLetras);

                            default ->
                                System.out.println("OPCION NO VALIDA INTENTA DE NUEVO");
                        }
                    }

                    default ->
                        System.out.println("OPCION NO VALIDA INTENTA DE NUEVO");
                }
                //primer case
            } while (true);
        } catch (Exception e) {
        }

    }

    // Método para llenar la pila automáticamente de manera aleatoria
    public static String[] llenarLetra() {
        String letra;
        int tope = 0;
        String[] letraGuardada = new String[26];
        char[] bancoDeLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};

        // Bucle para llenar el arreglo
        while (tope < 26) {
            letra = "" + bancoDeLetras[(int) (Math.random() * 26)];
            boolean repetida = false;

            // Verificar si la letra ya está en el arreglo
            for (int j = 0; j < tope; j++) {
                if (letra.equals(letraGuardada[j])) {
                    repetida = true;
                    break;
                }
            }

            // Si no está repetida, agregarla al arreglo
            if (!repetida) {
                letraGuardada[tope] = letra;
                tope++;
            }
        }
        return letraGuardada;
    }

    public static void mostrarPilaLetras(String[] pilaLetras) {
        if (pilaLetras.length == 0) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila de letras:");
            for (int i = 0; i < pilaLetras.length; i++) {
                System.out.print("["+pilaLetras[i]+"]");
            }
        }
    }

    public static int[] llenarNumero(int multiplo) {
        int tamano = 0;

        //for para saber cuantas posiciones debe tener el arreglo
        for (int i = 100; i < 200; i++) {
            if (i % multiplo == 0) {
                tamano++;
            }
        }

        //arreglo con la cantidad de espacios exactos 
        int[] pilaNumeros = new int[tamano];
        int indice = 0;

        //for para llenar el arreglo con los multiplos
        for (int i = 100; i < 200; i++) {
            if (i % multiplo == 0) {
                pilaNumeros[indice] = i;
                indice++;
            }
        }
        return pilaNumeros;

    }

    public static void mostrarNumero(int[] pilaNumeros) {
        if (pilaNumeros.length == 0) {
            System.out.println("La pila esta vacia");
        } else {
            System.out.println("Contenido de la pila de numeros:");
            for (int i = 0; i < pilaNumeros.length; i++) {
                System.out.print("["+pilaNumeros[i]+"]");
            }
        }
    }
    
    public static void unionPilas(int[] pilaNumeros, String[] pilaLetras){
        
        int longitudMinima = Math.min(pilaNumeros.length, pilaLetras.length);
        longitudMinima = longitudMinima-1;
        
        for(int i=longitudMinima; i>=0; i--){
            System.out.println("["+pilaNumeros[i]+pilaLetras[i]+"]");
        }
    }

}
