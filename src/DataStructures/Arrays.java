package DataStructures;

public class Arrays {

    int count = 0;
    int [] items;
    public Arrays (int length){
        items = new int[length];
    }

    public void print(){
        for (int i = 0; i < count; i ++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        // Create a new array and double its size
        if (items.length == count) {
            int[] newItemsArray = new int[count * 2];

            // Copy all the existing items to the new array
            for (int i = 0; i < count; i++) {
                newItemsArray[i] = items[i];

            //Set the new items array to the old items array
                items = newItemsArray;
            }
        }
        // Add and item to the end of the array
        items[count++] = item;
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


}
