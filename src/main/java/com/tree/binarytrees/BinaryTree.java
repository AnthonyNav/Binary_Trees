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


}
