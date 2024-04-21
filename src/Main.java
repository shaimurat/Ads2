public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(10);
        heap.insert(2);
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        System.out.println(heap.getMin());
    }
    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}