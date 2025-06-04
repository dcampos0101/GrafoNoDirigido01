/*
Desarrollado por el Prof. David Campos C.
Curso: BISOFT-20.
 */
package com.bisoft20.grafonodirigido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario MSI
 */
public class GrafoNoDirigido {

    static List<Nodo> GrafoNoDirigido;

    public static void main(String[] args) {
        System.out.println("Grafo No Dirigido!");

        Scanner sc = new Scanner(System.in);

        Nodo nodo;

        GrafoNoDirigido = new ArrayList();
        int conta = 1;
        String opc = "";
        try {
            while (!opc.equals("4")) {
                System.out.print("=== MENU ===");
                System.out.print("\n1. Agregar Nodo");
                System.out.print("\n2. Agregar Arista");
                System.out.print("\n3. Imprimir Noodos");
                System.out.print("\n4. Salir\n:");
                opc = sc.next();
                switch (opc) {
                    case "1" -> {
                        boolean n = true;
                        while (n) {
                            System.out.println("Ingrese un valor para el Nodo " + conta++ + ":");
                            int valor = sc.nextInt();
                            // Crea un nodo 
                            nodo = new Nodo(valor);
                            GrafoNoDirigido.add(nodo);

                            System.out.println("¿Desea continuar agregando más nodos? (s/n)");
                            String valor1 = sc.next();
                            n = valor1.equals("s");
                        }
                    }
                    case "2" -> {
                        boolean m = true;
                        while (m) {
                            System.out.println("Ingrese una arista a un nodo: ");
                            System.err.println("Nodo: ");
                            int nodo1 = sc.nextInt();
                            System.err.println("Nodo adyacente: ");
                            int nodo2 = sc.nextInt();

                            // Crea un nodo 
                            for (Nodo nodoX : GrafoNoDirigido) {
                                if (nodoX.getKey() == nodo1) {
                                    for (Nodo nodoY : GrafoNoDirigido) {
                                        if (nodoY.getKey() == nodo2) {
                                            if (nodoX.getAdjacentNodes().contains(nodoY)) {
                                                System.err.println("Nodo no agregado, ya existe");
                                                break;
                                            }
                                            nodoX.AgregarAdyacencia(nodoY);
                                            nodoY.AgregarAdyacencia(nodoX);
                                            System.err.println("Se agregó una adyancencia entre el nodo [" + nodo1 + "] con el nodo [" + nodo2 + "]");
                                        }
                                    }
                                }

                            }
                            System.out.println("¿Desea continuar agregando más adyacencias? (s/n)");
                            String valor1 = sc.next();
                            m = valor1.equals("s");
                        }
                    }
                    case "3" -> {
                        Imprimir();
                    }
                    case "4" -> {
                        opc = "4";
                        System.out.println("=== FIN ===");
                        break;
                    }
                    default ->
                        throw new AssertionError();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void Imprimir() {
        try {
            System.out.println("Lista de nodos:");
            for (Nodo nodo : GrafoNoDirigido) {
                System.out.println("Nodo: " + nodo.getKey());
                System.out.println("Nodos adyacentes:");
                for (Nodo adyacente : nodo.getAdjacentNodes()) {
                    System.out.println("[" + adyacente.getKey() + "]");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
