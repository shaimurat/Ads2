public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> stack = new MyArrayList<>();
    public MyStack(){
    }
    public MyStack(MyArrayList<T> array){
        this.stack = array;
    }
    public boolean empty(){
        return stack.size() == 0;
    }//return true if stack is empty
    public int size(){
        return stack.size();
    }//returns size of stack;
    public T peek(){
        return stack.get(size()-1);
    }//Returns a reference to the topmost element of the stack
    public T push(T item){//Adds the element at the top of the stack
        stack.AddLast(item);
        return item;
    }
    public T pop(){//Retrieves and deletes the topmost element of the stack

        T ret = peek();
        stack.removeLast();
        return ret;
    }
}
