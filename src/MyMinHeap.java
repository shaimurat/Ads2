public class MyMinHeap<T extends Comparable<T>>  {

    private MyArrayList<T> heap = new MyArrayList<>();

    public MyMinHeap() {
    }

    public boolean empty() { // Returns whether the heap is empty
        return heap.size() == 0;
    }

    public int size() {//returns size of heap
        return heap.size();
    } // size function

    public T getMin() { // returns min element
        return heap.get(0);
    }

    public T extractMin() { // gets min and swaps with last element then removes last element
        T min = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(0);
        return min;
    }

    public void insert(T item) { // Adds the element to the heap
        heap.add(item);
        traverseUp(size()-1);
    }

    private void heapify(int ind) { // – can perform heapify actions starting from position ‘index’
        int leftChild = leftChildOf(ind);
        int rightChild = rightChildOf(ind);
        int i = ind;
        while(i != size()-1){
            if(heap.get(rightChild)!=null){
                if(heap.get(leftChild).compareTo(heap.get(i)) > 0){
                    swap(i,leftChild);
                    i = leftChild;
                    leftChild = leftChildOf(ind);
                    rightChild = rightChildOf(ind);
            }}
            else if(heap.get(rightChild)!=null) {
             if (heap.get(rightChild).compareTo(heap.get(i)) > 0) {
                System.out.println(rightChild);
                swap(i,rightChild);
                i = rightChild;
                leftChild = leftChildOf(ind);
                rightChild = rightChildOf(ind);}
            }
            i++;
        }
    }

    public void traverseUp(int ind) { // can perform traverseUp actions starting from position ‘index’
        int parent = parentOf(ind);
        int i = ind;
        while(i != 0){
            if(heap.get(parent).compareTo(heap.get(i)) > 0){
                swap(i,parent);
                i = parent;
                parent = parentOf(parent);
            }
            else{
                break;
            }
        }
    }

    private int leftChildOf(int i) {
        return 2 * i;
    } // returns the index of the left child item

    private int rightChildOf(int i) {
        return 2 * i+1;
    } // returns the index of the right child item

    private int parentOf(int i) {
        return i / 2;
    } // returns parent

    private void swap(int i, int j) { // swapping elements
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}