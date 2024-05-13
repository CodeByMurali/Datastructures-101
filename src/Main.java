import DataStructures.Queue.ArrayQueue;
import DataStructures.Queue.StackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//       Mortgage calc
//       calculateMortgage();

//       FizzBuzz
//       fizzBuzzCalc();

        //Arrays
//        ArraysPractice numbers = new ArraysPractice(3);
//        numbers.insert(10);
//        numbers.insert(20);
//        numbers.insert(30);
//        numbers.insert(50);
//        numbers.insert(60);
//        numbers.insert(70);
//        numbers.insert(80);
//        numbers.insertAt(0, 0);
//        numbers.reverse();
//        System.out.println(numbers.max());
//        numbers.removeAt(2);
//        numbers.removeAt(3);
//        System.out.println(numbers.indexOf(50));
//        numbers.print();
//        numbers.removeAt(1);
//        System.out.println(numbers.indexOf(50));
//        System.out.println(numbers.max());
//        int[] inputArray = {10, 20, 30};
//        numbers.intersection(inputArray);
//        numbers.insertAt(55, 1);
//        numbers.print();

        //LinkedList
//        LinkedListTwo list = new LinkedListTwo();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.addLast(40);
//        list.addLast(50);
//        list.addLast(60);
//        list.addLast(70);
//        list.reverse();
//        System.out.println(list.getKthNodeFromTheEnd(0));
//        list.printMiddle();
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);
//        list.addFirst(0);
//        System.out.println(list.indexOf(0));
//        list.removeFirst();
//        System.out.println(list.size());

//        var array = list.toArray();
//        System.out.println(Arrays.toString(array));
//        list.removeLast();
//        System.out.println(list.indexOf(20));
//        System.out.println(list.contains(20));
//        System.out.println(list.size());
//        System.out.println(Arrays.toString(list.toArray()));


        //Doubly LinkedList
//        DoublyLinkedList dlist = new DoublyLinkedList();
//        dlist.addLast(10);
//        dlist.addLast(20);
//        dlist.addFirst(0);
//        dlist.reverse();

        //Stacks
//        StacksProblems stackObj = new StacksProblems();
//        stackObj.reverseString("abcd");
//        System.out.println(stackObj.balancedExpression("(<sadasd!@#$#>(<)(<>))"));
//        System.out.println(stackObj.balancedExpression(""));
//        System.out.println(stackObj.balancedExpression("12ar@!#"));

//        Stack stack = new Stack(5);
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.pop();
//        stack.push(70);
//        stack.pop();
//        stack.peek();
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        System.out.println(stack.isEmpty());


        //Queue
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        reverse(queue);

//  Implement queue with Array
//        ArrayQueue arrayQueue = new ArrayQueue(5);
//        arrayQueue.enqueue(10);
//        arrayQueue.enqueue(20);
//        arrayQueue.enqueue(30);
//        arrayQueue.enqueue(40);
//        arrayQueue.enqueue(50);
//        System.out.println(arrayQueue.dequeue());
//        System.out.println(arrayQueue.dequeue());
//        arrayQueue.enqueue(50);
//        arrayQueue.enqueue(60);

//        System.out.println(arrayQueue.peek());
//        System.out.println(arrayQueue.isEmpty());
//        System.out.println(arrayQueue.isFull());



        //  Implement queue with Stack
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
    }


    //Reverse a Queue

//    // Input [10, 20, 30]
//    // Output [30, 20, 10]
//    public static void reverse(Queue<Integer> queue){
//        // add
//        // remove
//        // isEmpty
//        Queue<Integer> revQueue = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
//
//        while (!queue.isEmpty()){
//            int firstElementInQueue = queue.remove();
//            stack.push(firstElementInQueue);
//        }
//
//        while (!stack.isEmpty()){
//            revQueue.add(stack.pop());
//        }
//        System.out.println(Arrays.toString(revQueue.toArray()));
//    }

}