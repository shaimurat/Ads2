public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(4);
        myList.add(2);
        myList.add(3);
        myList.set(1,100);
        printArray(myList);


    }
    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}