import java.util.Iterator;

public class ArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] array;
    private int length = 0;
    private static final int DEF_CAPACITY = 10;
    public ArrayList(int initCap){
        if(initCap<0){
            throw new IllegalArgumentException("Less than 0");
        }
        array = new Object[initCap];
    }
    public ArrayList(){
        this(DEF_CAPACITY);
    }
    public void increaseCapacity(){
        Object[] array2 = new Object[array.length*2];
        for(int i = 0; i < length; i++){
            array2[i] = array[i];
        }
        array = array2;
    }
    public void index_check(int ind){
        if(ind>array.length || ind < 0){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
    public void capacity_check(){
        if(array.length<length+1){
            increaseCapacity();
        }
    }
    @Override
    public void add(T item) {
        capacity_check();
        array[length++] = item;
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {
        index_check(index);
        capacity_check();
        Object[] array2 = new Object[array.length];
        int arr1ind = 0;
        for (int i =0;i<length++;i++){
            if (i == index){
                array2[i] = item;
                i++;
                continue;
            }
            array2[i] = array[arr1ind];
            arr1ind++;
        }
        array = array2;
    }

    @Override
    public void AddFirst(T item) {
        Object[] array2 = new Object[array.length];
    }

    @Override
    public void AddLast(T item) {

    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }

    @Override
    public T getLast() {
        return (T) array[length-1];
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort(){

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (object == array[i]) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length; i >= 0; i--) {
            if (object == array[i]) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < length; i++) {
            if (object == array[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    public void clear() {
        array = new Object[DEF_CAPACITY];
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

