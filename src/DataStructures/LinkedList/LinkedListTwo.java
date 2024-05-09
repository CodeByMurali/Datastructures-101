package DataStructures.LinkedList;


import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class LinkedListTwo {

    private class Node{
        private int value;
        private Node next;

        public void setValue(int value){
            this.value = value;
        }
    }

    int count;
    private Node first;
    private Node last;
    private Node previous;


    // addLast
    public void addLast(int value) {
        // Create a new node
        var node = createNode(value);

        // Verifies that there were no nodes created so far
        if (first == null) {
            // Point the head and the tail to the node that is created
            // As there is only one node
            first = last = node;
        } else {
            // Point the previous last node's next pointer to the node that is just created
            last.next = node;
            // Point the tail to the last node that is just added
            last = node;
        }
        count ++;
    }

    public void addFirst(int value) {
        // Create a new node
        var node = createNode(value);

        // Verifies that there were no nodes created so far
        if (first == null) {
            // Point the head and the tail to the node that is created
            // As there is only one node
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        count ++;
    }

    // Private method to create a node and set its value
    private Node createNode(int value) {
        // Create a new node
        var node = new Node();
        // Set the value to the node
        node.setValue(value);
        return node;
    }

    // indexOf
    public int indexOf(int value){
        //Element not found
        int index = -1;
        int iterator = 0;
        while (first.next != null){
            if(first.value == value){
                index = iterator;
            }
            first = first.next;
            iterator ++;
        }
        return index;
    }

    // deleteFirst
    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        // if there is only one node, since it also acts as the first that must be removed
        // Hence remove that node by setting it to null and return statement would end the execution
        if (first == last) {
            first = last = null;
        } else {
            Node secondNode = first.next;
            //Removing the link between first and the second node
            first.next = null;

            //Pointing the first to second node
            first = secondNode;
        }
        count --;
    }

    // deleteLast
    public void removeLast(){
        if (last == null) {
            throw new NoSuchElementException();
        }
        // if there is only one node, since it also acts as the last that must be removed
        // Hence remove that node by setting it to null and return statement would end the execution
        if (first == last){
            first = last = null;
        }
        else{
            var previous = getpreviousNode(last);
            last = previous;
            last.next = null;

        }
        count --;
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

    // contains
    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    //Size
    public int size(){
        return count;
    }

    //Convert to Array
    public int[] toArray(){
        int[] array = new int[count];
        int index = 0;
        Node currentNode = first;
        while (currentNode != null){
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }

//    public void reverse(){
//
//        // 10 -> 20 -> 30
//        Node previous = first; //10
//        Node current = first.next; //20
//
//
//        while (current != null){
//            Node next = current.next; //30
//
//            //20 -> 30
//            current.next = previous;
//            previous = current; //20
//            current = next; //30
//        }
////        var prevlast = last;
////        last = first;
////        first = prevlast;
//
//        last = first;
//        last.next = null;
//        first = previous;
//    }

    public void reverse(){

        var current = first.next;
        var previous = first;



        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }


}
