package com.tree.binarytrees;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    // Extra methods

    public boolean isEmpty(){
        return root == null;
    }
    // The first insertion will be checked in the main program
    public BinaryNode insertNode(int info, BinaryNode node){
        if (node == null) node = new BinaryNode(info);
        else if (info < node.getInfo()) node.setLeftNode(insertNode(info,node.getLeftNode()));
        else if (info > node.getInfo()) node.setRightNode(insertNode(info,node.getRightNode()));
        else System.out.println("No es posible insertar un elemento que ya existe (Duplicado)");
        return node;
    }
    // Delete a node (First case)
    public BinaryNode deleteNodeNoChildren(int key, BinaryNode n){
        if (n == null) return null;

        if (n.getLeftNode() !=null && n.getLeftNode().getInfo() == key) {
            n.setLeftNode(null);
            return n;
        }
        if (n.getRightNode() !=null && n.getRightNode().getInfo() == key) {
            n.setRightNode(null);
            return n;
        }

        if (n.getInfo() > key) return deleteNodeNoChildren(key ,n.getLeftNode());
        if (n.getInfo() < key) return deleteNodeNoChildren(key ,n.getRightNode());
        return n;
    }

    public BinaryNode deleteNodeOneChildren(int key, BinaryNode n){
        if (n == null) return null;

        if (n.getLeftNode() !=null && n.getLeftNode().getInfo() == key ) {
            BinaryNode k = (n.getLeftNode().getLeftNode() != null) ? n.getLeftNode().getLeftNode() : n.getLeftNode().getRightNode();
            n.setLeftNode(k);
            return n;
        }
        if (n.getRightNode() !=null && n.getRightNode().getInfo() == key ) {
            BinaryNode k = (n.getRightNode().getLeftNode() != null) ? n.getRightNode().getLeftNode() : n.getRightNode().getRightNode();
            n.setRightNode(k);
            return n;
        }

        if (n.getInfo() > key) return deleteNodeOneChildren(key ,n.getLeftNode());
        if (n.getInfo() < key) return deleteNodeOneChildren(key ,n.getRightNode());
        return n;
    }
    
    public int profundidad(BinaryNode nodo, int profundidadActual, int valor) {
    if (nodo == null) {
        return -1; // Si el nodo es nulo, no tiene profundidad
    }
    if (nodo.getInfo() == valor) {
        return profundidadActual; // Si encontramos el nodo con el valor especificado, devolvemos la profundidad actual
    }
    int profundidadIzquierda = profundidad(nodo.getLeftNode(), profundidadActual + 1, valor);
    int profundidadDerecha = profundidad(nodo.getRightNode(), profundidadActual + 1, valor);
    // Si el nodo no está en el subárbol izquierdo ni en el derecho, devuelve -1
    if (profundidadIzquierda == -1 && profundidadDerecha == -1) {
        return -1;
    }
    // Devuelve la profundidad máxima encontrada en el subárbol izquierdo y derecho
    return Math.max(profundidadIzquierda, profundidadDerecha);
    }
    
    public int altura(BinaryNode nodo) {
    if (nodo == null) {
        return -1; // Altura de un nodo nulo es 0
    }
    int alturaIzquierda = altura(nodo.getLeftNode());
    int alturaDerecha = altura(nodo.getRightNode());
    return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int tam(BinaryNode nodo) {
    if (nodo == null) {
        return 0; // Tamaño de un nodo nulo es 0
    }
    int tamIzquierda = tam(nodo.getLeftNode());
    int tamDerecha = tam(nodo.getRightNode());
    return tamIzquierda + tamDerecha + 1; // Sumamos 1 para contar el nodo actual
    }
}
