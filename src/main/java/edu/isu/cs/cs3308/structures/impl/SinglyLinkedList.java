package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;


/**
 * Singly Linked List to track inputs of scores
 * @param <E>
 */

public class SinglyLinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size;


    @Override
    public E first() {
        if(isEmpty()) return null;
        return head.getData();
    }

    @Override
    public E last() {
        if(isEmpty()) return null;
        if(size ==1) return head.getData();
        return tail.getData();
    }

    @Override
    public void addLast(E element) {
        if(element == null) return;

        Node<E> newNode = new Node<>(element);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.setNextNode(newNode);
            tail = newNode;
            size++;
        }

    }

    @Override
    public void addFirst(E element) {
        if(element == null) return;

        Node<E> newNode = new Node<>(element);

        if(isEmpty()){
            newNode.setNextNode(null);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.setNextNode(head);
        head = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()) return null;

        E removedData = head.getData();

        Node<E> tempNode = head;
        if(size ==1 ){
            head = null;
            tail = null;
            tempNode.setNextNode(null);
            size --;
            return removedData;
        }
        head = head.getNextNode();
        tempNode.setNextNode(null);
        size --;

        return removedData;
    }

    @Override
    public E removeLast() {
        if(size == 0) return null;
        if(size == 1){
            return removeFirst();
        }
        E removedData = tail.getData();

        Node<E> currentNode = head;
        Node<E> temp = head;
        while(currentNode != null){
            temp = currentNode;
            currentNode = currentNode.getNextNode();
        }
        tail = temp;
        size--;

        return removedData;
    }

    @Override
    public void insert(E element, int index) {
        if(index <= 0 || index > size) return;

        Node<E> newNode = new Node<>(element);

        Node<E> currentNode = head;

        for(int i = 0; i < index-1; i++){
            currentNode = currentNode.getNextNode();
        }

        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if(index <= 0 || index >= size) return null;

        Node<E> currentNode = head;
        for(int i = 0; i < index-1; i++){
            currentNode = currentNode.getNextNode();
        }
        Node<E> nodeToRemove = currentNode.getNextNode();
        E dataToRemove = nodeToRemove.getData();
        currentNode.setNextNode(nodeToRemove.getNextNode());
        nodeToRemove.setNextNode(null);
        size--;

        return dataToRemove;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) return null;
        if(index == 0) return head.getData();
        if(size == index) return tail.getData();

        Node<E> currentNode = head;
        for(int i = 0; i < index; i++){
            if(currentNode.getNextNode() == null)break;
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {

    }
}
