/**
 * Created by jingxin on 8/22/17.
 */
public class ArrayDeque<Item> {

    private Item[] a;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    /**
     * Creates an empty Array deque
     */
    public ArrayDeque(){
        size = 0;
        length = 8;
        a = (Item[]) new Object[length];
        nextFirst = length - 1;
        nextLast = 0;
    }

    /**
     * Helper functions to perform circular index operations
     */
    private int minusone(int index){
        return (index - 1 + length) % length;
    }

    private int addone(int index){
        return (index + 1) % length;
    }

    /**
     * Resizes the array
     */
    private void resize(double ratio){
        int newlength = (int) (length * ratio);
        Item[] newa = (Item[]) new Object[newlength];
        for(int i = 0; i < size; i++){
            newa[i] = a[(addone(nextFirst) + i) % length];
        }
        length = newlength;
        nextFirst = length - 1;
        nextLast = size;
        a = newa;
    }

    /**
     * Adds an item to the front of the Deque
     */
    public void addFirst(Item x){
        if(size == length){
            //need to resize
            resize(2.0);
        }
        a[nextFirst] = x;
        nextFirst = minusone(nextFirst);
        size = size + 1;
    }

    /**
     * Adds an item to the back of the Deque
     */
    public void addLast(Item x){
        if(size == length){
            //need to resize
            resize(2.0);
        }
        a[nextLast] = x;
        nextLast = addone(nextLast);
        size = size + 1;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns the number of items in the Deque
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the Deque from first to last, separated by a space
     */
    public void printDeque(){
        for(int i = addone(nextFirst); i != nextLast; i = addone(i)){
            System.out.println(a[i] + " ");
        }
    }

    /**
     * Checks the usage of array; if the array is too empty, return true.
     */
    private boolean checkUsage(){
        final double Min_Ratio = 0.25;
        double actualRatio = (double) size / (double) length;
        return length >= 16 && actualRatio < Min_Ratio;
    }

    /**
     * Removes and returns the item at the front of the Deque. If no such item exists, return null.
     */
    public Item removeFirst(){
        if(size > 0){
            nextFirst = addone(nextFirst);
            Item front = a[nextFirst];
            a[nextFirst] = null;
            size = size - 1;
            if(checkUsage()){
                resize(0.5);
            }
            return front;
        }
        return null;
    }

    /**
     * Removes and returns the item at the back of the Deque. If no such item exists, return null.
     */
    public Item removeLast(){
        if(size > 0){
            nextLast = minusone(nextLast);
            Item back = a[nextLast];
            a[nextLast] = null;
            size = size - 1;
            if(checkUsage()){
                resize(0.5);
            }
            return back;
        }
        return null;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item
     * exists, return null. Must not alter the deque!
     */
    public Item get(int index){
        if(index < 0 || index > size) return null;
        return a[(addone(nextFirst) + index) % length];
    }
}

