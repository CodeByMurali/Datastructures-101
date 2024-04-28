package DataStructures.LinkedList;

import java.util.NoSuchElementException;

public class LinkedListTwo {
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty()){
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size ++;
    }
    public void addFirst(int item){
        var node = new Node(item);
        if (isEmpty()){
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    public int indexOf(int item){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        var currentNode = first;
        int index = 0;
        while (currentNode != null){
            if(currentNode.value == item){
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }
    public void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            var secondNode = first.next;
            first.next = null;
            first = secondNode;
        }
    }
    public void removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            last = getpreviousNode(last);
            last.next = null;
        }

        size --;
    }
    public int[] toArray(){
        int[] array = new int[size];
        var currentNode = first;
        int index = 0;

        while (currentNode !=  null){
            array[index] = currentNode.value;
            currentNode = currentNode.next;
            index++;
        }
        return array;
    }

    private Node getpreviousNode(Node node){
        var currentNode = first;
        while (currentNode != null){
            if(currentNode.next == node)
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
    private boolean isEmpty(){
        return first == null;
    }
    public boolean contains(int item){
        return false;
    }
}
