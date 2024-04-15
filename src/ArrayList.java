import java.util.Iterator;

public class ArrayList<T> implements MyList{
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
        Object[] array2 = new Object[array.length];
        for(int i = 0; i < length; i++){
            array2[i] = array[i];
        }
        array = array2;
    }
    public void capacity_check(){
        if(array.length<length+1){
            increaseCapacity();
        }
    }
    @Override
    public void add(Object item) {
        capacity_check();
        array[length++] = item;
    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void AddFirst(Object item) {

    }

    @Override
    public void AddLast(Object item) {

    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object getFirst() {
        return array[0];
    }

    @Override
    public Object getLast() {
        return array[length-1];
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
        for (int i = length; i >= 0; i++) {
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
