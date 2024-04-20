public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> array = new MyLinkedList<>();
        array.add(100);
        array.add(1,2);
        array.AddLast(4);
        array.add(100);

        printArray(array);
    }
    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}