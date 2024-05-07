package DataStructures.Arrays;

import java.util.Arrays;

public class ArraysPractice {

    private int[] items;
    private int count;

    private int[] newArray;
    public ArraysPractice(int length){
        items = new int[length];
    }

    public void insert(int inputItem) {
        if (count >= items.length) {
            // Double the array size and copy elements
            doubleTheSizeAndCopy();
        }
        items[count++] = inputItem;
    }

    public void insertAt(int index, int value){
        //Check invalid index
        if(index < 0 || index >= items.length){
            throw new IllegalArgumentException();
        }
        if (count >= items.length) {
            // Double the array size and copy elements
            doubleTheSizeAndCopy();
        }

        for (int i = count - 1; i >= index; i--)
        {
            items[i + 1] = items[i];
        }
        items[index] = value;
        count++;

    }

    public void doubleTheSizeAndCopy() {
        int[] newArray = new int[items.length * 2]; // Double the size

        // Copy elements from the old array to the new array
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }

        // Assign the new array to the old array
        items = newArray;
    }

    public void removeAt(int index){
        //Check invalid index
        if(index < 0 || index >= items.length){
           throw new IllegalArgumentException();
        }

        // Remove the item from the specified index
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count --;
    }

    public int indexOf(int value){
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if(value == items[i]){
                index = i;
            }
        }
        return index;
    }

    //Intersect
    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            // if the element is not found this method will return -1
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }




    //Reverse
    public void reverse(){

        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }



    //Max
    public int max(){
        int max = 0;
        for (int i = 0; i < count; i++){
            if(items[i] > max){
                max = items[i];
            }
        }
        return max;
    }


    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
