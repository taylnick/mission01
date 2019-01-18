package edu.isu.cs.cs3308.structures.impl;

public class Node<E> {
    /**
     * @data holds the name and score.
     */
    private E data;
    /**
     * @nextNode points to the next node in the list.
     */
    private Node<E> nextNode;

    /**
     * Node constructor
     */
    public Node(E data){
        this.data = data;
        this.setNextNode(null);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> next) {
        this.nextNode = next;
    }
}
