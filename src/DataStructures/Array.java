package DataStructures;


public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();

        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        // Note that I've extracted the logic for
        // resizing the array into this private
        // method so we can reuse in insert() and
        // insertAt() methods.
        //
        // This also made our code cleaner and
        // more readable.
        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }


    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            // if the element is not found this method will return -1
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }


    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        //Shift the items to the left to fill the hole
        //index: 1
        //1 <- 2
        //2 -< 3
        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    //Complexity O(N)
    public int max(){
        int maxNum = 0;
        for (int i = 0; i < count; i++) {
            if(items[i] > maxNum){
             maxNum = items[i];
            }
        }
        return maxNum;
    }

    public void intersection(int [] inputArray){
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if(inputArray[j] == items[i]){
                    System.out.println(inputArray[j]);
                }
            }
        }
    }
}


