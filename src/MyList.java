

public interface MyList<T> extends Iterable<T>{
    void add(T item);
    void set(int index,T item);
    void add(int index, T item);
    void AddFirst(T item);
    void AddLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();

}
