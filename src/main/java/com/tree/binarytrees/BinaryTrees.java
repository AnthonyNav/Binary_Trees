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
                    showByLevels(tree.getRoot());
                    break;
                case 12:
                    System.out.println("Dame el nodo a eliminar");
                    delete(scan.nextInt());
                    break;
                case 13:
                    if (isComplete(tree.getRoot())) System.out.println("Es un Arbol binario completo");
                    else System.out.println("No es un Arbol binario completo");
                    break;
                case 14:
                    fullLoad = false;
                    System.out.println("\n\nDesea probar con otro arbol?\n1)Si\n2)No");
                    out = scan.nextInt() == 2;
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
                    break;
            }

        }
    }


    public static boolean loadTree(int nt){
        tree = new BinaryTree();
        String direccion;
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
            e.printStackTrace();
            return false;
        }
    }

    public static BinaryNode searchNode(int value, BinaryNode n){ // Si el nodo a buscar no existe, retorna null
        if (n == null) return null;
        if (n.getInfo() > value) return searchNode(value ,n.getLeftNode());
        if (n.getInfo() < value) return searchNode(value ,n.getRightNode());
        return n;
    }

    public static void delete(int value){
        BinaryNode n = searchNode(value, tree.getRoot());
        if (n != null) {
            if (n.getLeftNode()==null && n.getRightNode()==null){
                tree.deleteNodeNoChildren(value, tree.getRoot());
            } else if (n.getLeftNode()!=null && n.getRightNode()!=null) {
                // 3rd case
                BinaryNode k = getMaxNode(n.getLeftNode());
                delete(k.getInfo());
                n.setInfo(k.getInfo());
            } else tree.deleteNodeOneChildren(value,tree.getRoot());
        }
    }

    public static BinaryNode getMaxNode(BinaryNode n){
        if (n == null) return null;
        if (n.getRightNode() != null)return getMaxNode(n.getRightNode());
        return n;
    }

    public static void showByLevels(BinaryNode n){
        Queue q = new Queue();
        q.insert(n.getInfo());
        BinaryNode aux;
        System.out.println();
        System.out.print("Recorrido: ");
        while (!q.isEmpty()){
            aux = searchNode(q.delete().getInfo(), tree.getRoot());
            System.out.print(aux.getInfo() + " ");
            if(aux.getLeftNode()!=null) q.insert(aux.getLeftNode().getInfo());
            if(aux.getRightNode()!=null) q.insert(aux.getRightNode().getInfo());
        }
    }

    public static boolean isComplete(BinaryNode n){
        if (n == null) return true;
        Queue q = new Queue();
        BinaryNode out;
        boolean flag = false;
        q.insert(n.getInfo());

        while (!q.isEmpty()){
            out = searchNode(q.delete().getInfo(), tree.getRoot());

            if(flag && (out.getLeftNode() !=null || out.getRightNode()!=null)) return false;

            // if exist the left node but there isn't the right node, the tree isn't complete
            if(out.getLeftNode() == null && out.getRightNode() != null) return false;

            if (out.getLeftNode() != null) q.insert(out.getLeftNode().getInfo());
            else flag = true;

            if (out.getRightNode() != null) q.insert(out.getRightNode().getInfo());
            else flag = true;

        }
        return true;
    }

}


