/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tree.binarytrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author antho
 */
public class BinaryTrees {
    private static BinaryTree tree;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        boolean fullLoad = false;
        String menu = """ 
********* Menu *********
1)  Insertar elemento
2)  Calcular la profundidad de un nodo
3)  Calcular la altura de un nodo
4)  Calcular el tamaño de un nodo
5)  Obtener el hermano de un nodo
6)  Obtener los ancestros (antepasados) de un nodo
7)  Obtener los descendientes de un nodo
8)  Recorrer en Preorden
9)  Recorrer en Inorden
10) Recorrer en Postorden
11) Recorrer por Niveles
12) Borrar un nodo
13) Determinar si un árbol es un árbol binario completo (ABC)
14) Salir

                """;

        while (!out) {
            while (!fullLoad) {
                System.out.println("\n\n");
                System.out.println("Ingrese el arbol que desea (1-6):");
                fullLoad = loadTree(scan.nextInt());
            }
            System.out.print("\nArbol: ");
            tree.getRoot().inorden();
            System.out.println();
            System.out.println(menu);
            switch (scan.nextInt()) {
                case 1:
                    // insert node
                    System.out.println("Dame el dato a insertar");
                    if (tree.isEmpty()) tree.setRoot(new BinaryNode(scan.nextInt()));
                    else tree.insertNode(scan.nextInt(), tree.getRoot());
                    break;
                case 2:
                    // Calculate the depth of a node
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    if (!tree.isEmpty()){
                        System.out.print("Preorden: ");
                        tree.getRoot().preorden();
                        System.out.println();
                    } else System.out.println("No existen elementos");
                    break;
                case 9:
                    if (!tree.isEmpty()){
                        System.out.print("Inorden: ");
                        tree.getRoot().inorden();
                        System.out.println();
                    } else System.out.println("No existen elementos");
                    break;
                case 10:
                    if (!tree.isEmpty()){
                        System.out.print("postorden: ");
                        tree.getRoot().postorden();
                        System.out.println();
                    } else System.out.println("No existen elementos");
                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:
                    fullLoad = false;
                    System.out.println("\n\nDesea probar con otro arbol?\n1)Si\n2)No");
                    out = scan.nextInt() == 2;
                    break;
                default:

                    break;

            }

        }
    }


    public static boolean loadTree(int nt){
        tree = new BinaryTree();
        String direccion = "";
        switch (nt) {
            case 1:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree1.txt";
                break;
            case 2:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree2.txt";
                break;
            case 3:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree3.txt";
                break;
            case 4:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree4.txt";
                break;
            case 5:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree5.txt";
                break;
            case 6:
                direccion = "src/main/java/com/tree/binarytrees/binaryTreesFiles/tree6.txt";
                break;
            default:
                System.out.println("Opcion no valida");
                return false;
        }

        try {
            File file = new File(direccion);
            Scanner scanner = new Scanner(file);
            String line;
            String[] str;

            line = scanner.nextLine();
            str = line.split(" ");

            for (String s : str) {
                if(tree.isEmpty()){
                    tree.setRoot(new BinaryNode(Integer.parseInt(s)));
                } else {
                    tree.insertNode(Integer.parseInt(s), tree.getRoot());
                }
            }
            return true;

        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
    }

    public static BinaryNode searchNode(int value, BinaryNode n){ // Si el nodo a buscar no existe, retorna null
        if (n == null) return null;
        if (n.getInfo() > value) return searchNode(value ,n.getLeftNode());
        if (n.getInfo() < value) return searchNode(value ,n.getRightNode());
        return n;
    }
}


