/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tree.binarytrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        int valor;
        int profundidad = 0;
        int altura = 0;
        int tam = 0;
        BinaryNode nodo;
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
                    // Calcular la profundidad de un nodo
                    System.out.println("Ingresa un nodo: ");
                    valor = scan.nextInt();
                    nodo = searchNode(valor, tree.getRoot());
                    if(nodo != null)
                    {
                        profundidad = tree.profundidad(tree.getRoot(), 0, valor);
                        System.out.println("La profundidad del nodo es: " + profundidad);
                    }else
                    {
                        System.out.println("El nodo no existe");
                    }
                    break;
                case 3:
                    //Calcular la altura de un nodo
                    System.out.println("Ingresa un nodo: ");
                    valor = scan.nextInt();
                    nodo = searchNode(valor, tree.getRoot());
                    if(nodo != null)
                    {
                        altura = tree.altura(nodo);
                        System.out.println("La altura del nodo es: " + altura);
                    }else
                    {
                        System.out.println("El nodo no existe");
                    }
                    break;
                case 4:
                    //Calcular el tamano de un nodo
                    System.out.println("Ingresa un nodo: ");
                    valor = scan.nextInt();
                    nodo = searchNode(valor, tree.getRoot());
                    if(nodo != null)
                    {
                        tam = tree.tam(nodo);
                        System.out.println("El tamano del nodo es: " + tam);
                    }else
                    {
                        System.out.println("El nodo no existe");
                    }
                    break;
                case 5:
                    // Obtener los hermanos de un nodo
                    System.out.println("Ingrese el valor del nodo del cual desea obtener el hermano:");
                    int nodeValue = scan.nextInt();
                    BinaryNode hermano = getHermano(tree.getRoot(), nodeValue);
                    if (hermano != null) {
                        System.out.println("El hermano de " + nodeValue + " es: " + hermano.getInfo());
                    } else {
                        System.out.println("El nodo " + nodeValue + " no tiene hermano en este arbol");
                    }
                    break;
                case 6:
                    // Obtener los ancestros de un nodo
                    System.out.println("Ingrese el valor del nodo del cual desea obtener los ancestros:");
                    int nodoAncestros = scan.nextInt();
                    List<Integer> ancestros = getAncestros(nodoAncestros);
                    if (!ancestros.isEmpty()) {
                        System.out.print("Los ancestros de " + nodoAncestros + " son: ");
                        for (int ancestro : ancestros) {
                            System.out.print(ancestro + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("El nodo " + nodoAncestros + " no tiene ancestros en este arbol");
                    }
                    break;
                case 7:
                    // Obtener los descendientes de un nodo
                    System.out.println("Ingrese el valor del nodo del cual desea obtener los descendientes:");
                    int nodoDescendientes = scan.nextInt();
                    List<Integer> descendientes = getDescendientes(nodoDescendientes);
                    if (!descendientes.isEmpty()) {
                        System.out.print("Los descendientes de " + nodoDescendientes + " son: ");
                        for (int descendiente : descendientes) {
                            System.out.print(descendiente + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("El nodo " + nodoDescendientes + " no tiene descendientes en este arbol");
                    }
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
                    if (isComplete(tree.getRoot())) {
                        altura = tree.altura(tree.getRoot()) + 1;
                        altura = (int) Math.pow(2,altura) -1;
                        if(altura == tree.tam(tree.getRoot())){
                            System.out.println("Es un Arbol binario completo");
                        }
                        else System.out.println("No es un Arbol binario completo, pero si un Cuasicompleto");
                    }
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

    public static BinaryNode getHermano(BinaryNode raiz, int value) {
        return encontrarHermano(raiz, value, null);
    }

    private static BinaryNode encontrarHermano(BinaryNode node, int value, BinaryNode parent) {
        if (node == null) {
            return null;
        }

        if (node.getInfo() == value) {
            if (parent == null) {
                return null; // El nodo dado es la raíz, no tiene hermano
            }

            if (parent.getLeftNode() != null && parent.getLeftNode().getInfo() == value) {
                return parent.getRightNode();
            } else {
                return parent.getLeftNode();
            }
        }

        // Buscar en el subárbol izquierdo y derecho
        BinaryNode hermanoIzquierdo = encontrarHermano(node.getLeftNode(), value, node);
        BinaryNode hermanoDerecho = encontrarHermano(node.getRightNode(), value, node);

        return hermanoIzquierdo != null ? hermanoIzquierdo : hermanoDerecho;
    }

    public static List<Integer> getAncestros(int value) {
        List<Integer> ancestros = new ArrayList<>();
        encontrarAncestros(tree.getRoot(), value, ancestros);
        return ancestros;
    }

    private static boolean encontrarAncestros(BinaryNode node, int value, List<Integer> ancestros) {
        if (node == null) {
            return false;
        }

        if (node.getInfo() == value) {
            return true;
        }

        // Buscar en el subárbol izquierdo y derecho
        if (encontrarAncestros(node.getLeftNode(), value, ancestros) || encontrarAncestros(node.getRightNode(), value, ancestros)) {
            ancestros.add(node.getInfo());
            return true;
        }

        return false;
    }

    private static List<Integer> getDescendientes(int value) {
        List<Integer> descendientes = new ArrayList<>();
        encontrarDescendientes(searchNode(value, tree.getRoot()), value, descendientes);
        return descendientes;
    }

    private static void encontrarDescendientes(BinaryNode node, int target, List<Integer> descendientes) {
        if (node == null) {
            return;
        }

        // Buscar en el subárbol izquierdo y derecho
        encontrarDescendientes(node.getLeftNode(), target, descendientes);
        encontrarDescendientes(node.getRightNode(), target, descendientes);

        // Agregar el nodo actual a la lista de descendientes
        if (node.getInfo() != target) {
            descendientes.add(node.getInfo());
        }
    }

}


