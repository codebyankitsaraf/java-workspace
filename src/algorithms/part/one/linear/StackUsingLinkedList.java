package algorithms.part.one.linear;

public class StackUsingLinkedList<T> {
    private final LinkedList<T> stack;
    private int size = 0;

    public StackUsingLinkedList() {
        this.stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingLinkedList<String> stackUsingLinkedList = new StackUsingLinkedList<>();
        stackUsingLinkedList.push("i: 0");
        stackUsingLinkedList.push("i: 1");
        System.out.println("peek: " + stackUsingLinkedList.peek());
        stackUsingLinkedList.push("i: 2");
        System.out.println("pop: " + stackUsingLinkedList.pop());
        System.out.println("pop: " + stackUsingLinkedList.pop());
        System.out.println("pop: " + stackUsingLinkedList.pop());
    }

    public void push(T data) {
        stack.add(data);
        size++;
    }

    public T pop() {
        T remove = stack.remove(size - 1);
        size--;
        return remove;
    }

    public T peek() {
        return stack.get(size - 1);
    }
}
