package DataStructures;

public class ArraysTwo {

    int[] items;
    int [] newArray;
    int count = 0;

    //Constructor
    public ArraysTwo (int length){
        items = new int[length];
    }


    public void insert(int item) {
        count = items.length;

        //1. Create a new array
        newArray = new int[count + 1];

        //2. Copy element from old array to new array
        for (int i = 0; i < count; i++) {
            newArray[i] = items[i];
        }

        //3. Add the new item at the end of the new array
        newArray[count] = item;

        //4. Copy over new array to old array
        items = newArray;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();

        //Shift the items to the left to fill the hole
        // [10, 20, 30, 40]

        for (int i = index; i < count; i ++){
            items[i] = items[i + 1];
            count --;
        }

    }


    public int indexOf(int item){
        return -1 ;
    }

    public void print(){
        for (int i = 0; i <= count; i++) {
            System.out.println(newArray[i]);

        }
    }
}
