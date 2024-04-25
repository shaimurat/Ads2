public class MyMinHeap<T extends Comparable<T>>  {

    public MyArrayList<T> heap = new MyArrayList<>();

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
        heap.AddLast(item);
        traverseUp(size()-1);
    }

    private void heapify(int i) {
        int ind = i;
        int l = leftChildOf(ind);
        int r = rightChildOf(ind); //

        if (size()>l){
            if (heap.get(ind).compareTo(heap.get(l)) > 0)
                ind = l;}

        if (size()>r){
            if (heap.get(ind).compareTo(heap.get(r)) > 0)
                ind = r;}
        if (ind != i) {
            swap(i, ind);

            heapify(ind);
        }
    }
    public void traverseUp(int ind) { // can perform traverseUp actions starting from position ‘index’
        if(ind == 0) {
            return;
        }
        int p = parentOf(ind);
        if(heap.get(ind).compareTo(heap.get(p)) < 0) {

            swap(ind, p);
            traverseUp(p);
        }
    }

    private int leftChildOf(int i) {
        return (2 * i)+1;
    } // returns the index of the left child item

    private int rightChildOf(int i) {
        return (2 * i)+2;
    } // returns the index of the right child item

    private int parentOf(int i) {
        return (i - 1)/ 2 ;
    } // returns parent

    private void swap(int i, int j) { // swapping elements
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}