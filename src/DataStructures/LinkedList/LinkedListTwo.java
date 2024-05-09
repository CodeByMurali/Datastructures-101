package DataStructures.LinkedList;


import org.w3c.dom.Node;

import java.util.Arrays;
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


    // Find the Kth node from the end
    // Of a linked list in one pass.

    // [10 -> 20 -> 30 -> 40 -> 50 ]
    //  *           *
    // K = 1 (50)
    // K = 2 (40)
    // K = 3 (30) (distance = 2) or d = k-1 nodes

    // Using the first pointer as the second pointer reaches the end
    // Of the list, the pointer can be found
    public int findKthNodeFromLast(int k){

       if(k <= 0 || k > count ){
           throw new IllegalArgumentException();
       } else if (k == 1) {
           return last.value;
       }

        Node ptrOne = first;
       Node lastNode = last;
       int distanceBetweenPointers = k - 1;
       Node ptrTwo = movePointerByCount(ptrOne, distanceBetweenPointers);

       while (ptrTwo != lastNode){
            ptrOne = ptrTwo;
            ptrTwo = movePointerByCount(ptrOne, distanceBetweenPointers);
       }
       return ptrOne.value;
    }

    private Node movePointerByCount(Node firstPointer, int count){
        var currentNode = firstPointer;
        for (int i = 1; i <= count; i++) {
            if (currentNode.next != null)
                currentNode = currentNode.next;
        }
        return currentNode;
    }

    //Mosch solution

    public int getKthNodeFromTheEnd(int k){
        if(k <= 0){
            throw new IllegalArgumentException();
        }
        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if(b.next == null){
                throw new IllegalArgumentException();
            }
        }

        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

//Find the middle of a linked list in one pass.
// If the list has an even number of nodes, there would be two middle nodes.
// (Note: Assume that you don’t know the size of the list ahead of time.)

    public int[] printMiddleElement(){

        var slowPointer = first;
        var fastPointer = first;
        var middle = first;


        // Odd
        while (fastPointer != last){
            slowPointer = movePointerByCount(slowPointer, 1);
            fastPointer = movePointerByCount(fastPointer, 2);
            middle = slowPointer;
        }

        //Even number of element in the list
            if (fastPointer.next == null){
                return new int[]{middle.value, middle.next.value};
            }
        return new int[]{middle.value};
    }

    //Mosch sol

    public void printMiddle(){
        var slowPointer = first;
        var fastPointer = first;

        // Even
        while (fastPointer != last && fastPointer.next != last) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        // Odd
        if (fastPointer == last)
            System.out.println(slowPointer.value);
        else
            System.out.println(slowPointer.value + ", " + slowPointer.next.value);

    }


    //Check to see if a linked list has a loop.Hint: use two pointers (slow and fast) to traverse the list.
    // Move the slow pointer one step forward and the fast pointer two steps forward.
    // If there’s a loop, at some point, the fast pointer will meet the slow pointer and overtake it.
    // This algorithm is called Floyd’s Cycle-finding Algorithm.Solution: LinkedList.hasLoop()

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static LinkedListTwo createWithLoop() {
        var list = new LinkedListTwo();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

}



