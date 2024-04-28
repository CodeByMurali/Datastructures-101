package DataStructures.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node{

        //Node contains a value
        private int value;

        //Pointer to the next node
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //Node contains a pointer to head
    private Node first;

    //Node contains a pointer to tail
    private Node last;

    private int size;


    //Add a node to the beginning of the linked list
    public void addLast(int item){
        var node = new Node(item);

        //If there is no nodes in the list point the first and the last to the same node
        if(isEmpty()){
            last = first = node;
        }
        //If not, add the node to the end of the list and point last to the newly created node
        else {
            last.next = node;
            last = node;
        }
        size ++;
    }

    //Add a node to the beginning of the linked list

    public void addFirst(int item){
        var node = new Node(item);
        //If there is no nodes in the list point the first and the last to the same node
        if(isEmpty()){
            last = first = node;
        }
        //If not, find the current first node and add the node to the beginning of the list and point first to the newly created node
        else{
            //Point the new node to the first node
            node.next = first;
            first = node;
        }
        size ++;
    }


    //Find the index of and element
    public int indexOf(int item){
       int index = 0;
       Node current = first;
       while (current != null){ // Till we havent reached the end of the list
           if (current.value == item) {
            return index;
           }
           current = current.next;
           index ++;
       }
       return -1;
    }

    //Remove First
    public void removeFirst(){
        //if there are no nodes throw an exception
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // if there is only one node, since it also acts as the first that must be removed
        // Hence remove that node by setting it to null and return statement would end the execution
        if (first == last){
            first = last = null;
        }

        else{
            // Inorder for java garbage collector to identify the node that was removed
            // The link to that node must also be removed
            // However if we remove the link of the first node that is pointing to the next node
            // We cannot set the second node to first as there is no link
            // Hence we create a back up of the node

            Node secondNode = first.next;
            //Removing the link between first and the second node
            first.next = null;

            //Pointing the first to second node
            first = secondNode;
        }
        size --;
    }

    public void removeLast(){

        if(isEmpty()){
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

    public int size(){
        return size;
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

    //This is efficient as it reduces the run time complexity to O(1)
    //But when you traverse though the list the complexity becomes O(n)
    private boolean isEmpty(){
        return first == null;
    }

    //Verify if the list contains the element
    public boolean contains(int item){
        return indexOf(item) != -1;
    }
}