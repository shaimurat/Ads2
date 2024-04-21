public class Main {
    public static void main(String[] args) {
        ArrayListCheck();
        LinkedListCheck();
    }
    public static void ArrayListCheck(){
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(100);
        arr.add(12);
        arr.add(134);
        arr.add(14);
        arr.set(1,200);
        arr.add(1,2000);
        arr.remove(arr.indexOf(134));
        printArray(arr);
        System.out.println(arr.get(1));
        arr.sort();
        printArray(arr);
        arr.clear();
        System.out.println("arr:");
        printArray(arr);
    }
    public static void LinkedListCheck(){
        MyLinkedList<Integer> arr = new MyLinkedList<>();
        arr.add(1);
        arr.add(100);
        arr.add(12);
        arr.add(134);
        arr.add(14);
        arr.set(1,200);
        arr.add(1,2000);
        arr.remove(arr.indexOf(134));
        printArray(arr);
        System.out.println(arr.get(1));
        arr.sort();
        printArray(arr);
        arr.clear();
        System.out.println("arr:");
        printArray(arr);
    }
    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}