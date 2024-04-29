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


}
