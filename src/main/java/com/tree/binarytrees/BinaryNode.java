package com.tree.binarytrees;

public class BinaryNode {
    private int info;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public BinaryNode(int info) {
        this.info = info;
        leftNode = null;
        rightNode = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    public void inorden(){
        if (leftNode != null) leftNode.inorden();
        System.out.print(info + " ");
        if (rightNode != null) rightNode.inorden();
    }
    public void postorden(){
        if (leftNode != null) leftNode.inorden();
        if (rightNode != null) rightNode.inorden();
        System.out.print(info + " ");
    }
    public void preorden(){
        System.out.print(info + " ");
        if (leftNode != null) leftNode.inorden();
        if (rightNode != null) rightNode.inorden();
    }


    @Override
    public String toString() {
        return "info = " + info;
    }
}
