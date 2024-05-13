package DataStructures.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;


    // Logic - We must use 2 pointers here
    // Front and rear
    // [10, 20, 30, 40, 0]
    //  F=0 front of the queue
    //  R=3 End of the queue
    //  F          R
    // When we add an item - move rear pointer to the front and store the item
    // [10, 20, 30, 40, 50]
    //  F               R
    // Remove - Move the front pointer forward
    // [10, 20, 30, 40, 50]
    //      F           R
    // Here 10 is in memory but we dont see it

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
