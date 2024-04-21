
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] array;
    private int length = 0;
    private static final int DEF_CAPACITY = 10;

    public MyArrayList(int initCap) { //Creating arrayList with given capacity
        if (initCap < 0) {
            throw new IllegalArgumentException("Less than 0");
        }
        array = new Object[initCap];
    }

    public MyArrayList() { // creating arrayList with default capacity if init cap not given
        this(DEF_CAPACITY);
    }

    private void increaseCapacity() {
        Object[] array2 = new Object[array.length * 2];
        for (int i = 0; i < length; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    private void index_check(int ind) { //checks is index exists in arraylist
        if (ind > length || ind < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    private void capacity_check() { // Checks to see if capacity needs to be increased
        if (array.length < length + 1) {
            increaseCapacity();
        }
    }

    @Override
    public void add(T item) { //add an object to the arrayList
        capacity_check();
        array[length++] = item;
    }

    @Override
    public void set(int index, T item) { //change an object in this index
        index_check(index);
        array[index] = item;
    }

    @Override
    public void add(int index, T item) { //add object to this index
        index_check(index);
        capacity_check();
        Object[] array2 = new Object[array.length];
        int arr1ind = 0;
        for (int i = 0; i < length+1; i++) {
            if (i == index) {
                array2[i] = item;
                continue;
            }
            array2[i] = array[arr1ind];
            arr1ind++;
        }
        length++;
        array = array2;
    }

    @Override
    public void AddFirst(T item) {
        add(0, item);
    }//add object to the zero index

    @Override
    public void AddLast(T item) {
        capacity_check();
        array[length++] = item;
    }//add object to the last index

    @Override
    public T get(int index) {//get item in this index
        index_check(index);
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }//get first object of the arrayList

    @Override
    public T getLast() {
        return (T) array[length - 1];
    }//get last object of the arrayList

    @Override
    public void remove(int index) {//remove object from this index
        index_check(index);
        Object[] array2 = new Object[array.length];
        int arr1ind = 0;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                array2[i] = array[++arr1ind];
                arr1ind++;
                continue;
            }
            array2[i] = array[arr1ind];
            arr1ind++;
        }
        array = array2;
        length--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }//remove first object

    @Override
    public void removeLast() {
        array[--length] = null;
    }//remove last object

    @Override
    public void sort() {//sorting arrayList in ascending order
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length-1-i; j++) {
                if (((Comparable)array[j]).compareTo(array[j+1]) > 0) {
                    Object temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    @Override
    public int indexOf(Object object) {//returns index of object
        for (int i = 0; i < length; i++) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) { //returns last index of object
        for (int i = length; i >= 0; i--) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean exists(Object object) {//Checks if the object exists in the arrayList
        for (int i = 0; i < length; i++) {
            if (object.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() { //returns array that contains all object from list
        Object[] toArr = new Object[length];
        for (int i=0;i<length;i++){
            toArr[i] = array[i];
        }
        return toArr;
    }

    public void clear() { //deleting all objects of the arrayList
        array = new Object[DEF_CAPACITY];
        length = 0;
    }

    @Override
    public int size() { //returns size of arrayList
        return length;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return (T) array[index++];
        }
    }
}



