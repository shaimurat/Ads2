import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    MyNode<T> head;
    MyNode<T> tail;
    private int size = 0;
    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode(E data){
            this.data=data;
        }
    }
    public MyLinkedList(){
        head = null;
        tail = null;
    }
    public void indexCheck(int index){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
    @Override
    public void add(T item) {
        MyNode<T> newItem = new MyNode<>(item);
        if(head == null){
            head = tail = newItem;
        }
        else {
            tail.next = newItem;
            tail = newItem;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        indexCheck(index);
        MyNode<T> newItem = new MyNode<>(item);
        MyNode current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        current.data = newItem;
    }

    @Override
    public void add(int index, T item) {
        indexCheck(index);
        MyNode<T> newItem = new MyNode<T>(item);
        if(index == 0){
            newItem.next = head;
            head = newItem;
        }
        else if (index == size){
            tail.next = newItem;
            tail = newItem;
        }
        else{
            MyNode<T> current = head;
            for(int i=0;i<index;i++){
               current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        size++;
    }

    @Override
    public void AddFirst(T item) {
        add(0, item);
    }

    @Override
    public void AddLast(T item) {
        add(size, item);
    }

    @Override
    public T get(int index) {
        indexCheck(index);
        MyNode<T> current = head;
        for(int i = 0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        indexCheck(index);
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            MyNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current = null;
        }
        size--;
    }
    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {
            for (MyNode i = head; i != null; i = i.next) {
                for (MyNode j = i; j != null; j = j.next) {
                    if (((Comparable)j.data).compareTo(i.data) < 0) {
                        Object current = i.data;
                        i.data = j.data;
                        j.data = current;
                    }
                }
            }
        }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int ind = 0;
        while (current.data != object){
            current = current.next;
            ind++;
        }
        return ind++;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = head;
        int ind = 0;
        int saveInd=-999;
        while (current != null){
            if(current.data == object){
                saveInd = ind;
            }
            current = current.next;
            ind++;
        }
        return saveInd;
    }

    @Override
    public boolean exists(Object object) {
        MyNode current = head;
        while (current != null){
            if(current.data == object){
                return true;
            }
            current= current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        private MyNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T nextItem = current.data;
            current = current.next;
            return nextItem;
        }

    }
}
