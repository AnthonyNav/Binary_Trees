package com.tree.binarytrees;

public class Queue {
    private BinaryNode init;

    public Queue() {
        this.init = null;
    }

    public BinaryNode getInit() {
        return init;
    }

    public void setInit(BinaryNode init) {
        this.init = init;
    }

    public void insert(int value){
        if (isEmpty()) init = new BinaryNode(value);
        else {
            BinaryNode aux = init;
            while (aux.getRightNode()!=null) {
                aux = aux.getRightNode();
            }
            aux.setRightNode(new BinaryNode(value));
        }
    }

    public BinaryNode delete(){
        BinaryNode aux = null;
        if (!isEmpty()){
            aux = init;
            init = init.getRightNode();
        }
        return aux;
    }


    public boolean isEmpty(){
        return init == null;
    }
}
