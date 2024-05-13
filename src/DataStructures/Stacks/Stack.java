package DataStructures.Stacks;

import java.util.Arrays;

public class Stack {
    int initialSize;
    int[] stackArray;
    int counter;

    public Stack(int initialSize) {
        this.initialSize = initialSize;
        this.stackArray = new int[initialSize]; // Initialize stackArray here
        this.counter = 0;
    }


    // Push
    public void push(int input) {
            if(counter == initialSize){
                throw new StackOverflowError();
            }
            stackArray[counter++] = input;
    }


    public int pop() {
        if (counter == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stackArray[--counter];
    }

    // Pop
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stackArray, 0, counter);
        return Arrays.toString(content);
    }

    // peek
    public int peek(){
        return stackArray[counter - 1];
    }
    // isEmpty
    public boolean isEmpty(){
        return (counter == 0);
    }

}
