package DataStructures.LinkedList;

import java.util.Arrays;

public class DoublyLinkedList {
    private class Node{

        public int value;
        public Node next;
        public Node previous;
        public Node(int value){
            this.value = value;
        }
    }

    Node first;
    Node last;
    int size;

    public void addLast(int item){
        var node = new DoublyLinkedList.Node(item);
        if(isEmpty()){
            first = last = node;
        }
        else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        size ++;
    }
    public void addFirst(int item){
        var node = new DoublyLinkedList.Node(item);
        if (isEmpty()){
            first = last = node;
        }
        else {
            first.previous = node;
            node.next = first;
            first = node;
        }
        size++;
    }

//    public void printReverse(){
//        int [] revArray = new int[size];
//        int index = 0;
//        var lastNode = last;
//        while (lastNode != null){
//            revArray[index] = lastNode.value;
//            lastNode = lastNode.previous;
//            index ++;
//        }
//        System.out.println(Arrays.toString(revArray));
//    }

    public void reverse(){
        if(isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = current.previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    private boolean isEmpty(){
        return first == null;
    }
}
