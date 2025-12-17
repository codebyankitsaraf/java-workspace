package algorithms.part.one.linear;

public class LinkedList<T> {

    private Node<T> head;
    private int size = 0;

    public LinkedList() {
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add("i: " + i);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        int n = linkedList.size;
        for (int i = 0; i < n; i++) {
            linkedList.remove("i: " + i);
        }
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i));
        }

        linkedList.remove("i: 9");
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (head == null) {
            head = newNode;
            head.next = null;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            int i = size - 1;
            Node<T> current = head;
            while (current != null && current.next != null) {
                if (i == index) {
                    return current.data;
                } else {
                    current = current.next;
                    i--;
                }
            }
            if (current != null && index == i) {
                return current.data;
            }
            return null;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void remove(T data) {
        if (head != null && head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> prev = head;
        Node<T> current = (head != null) ? head.next : null;
        while (current != null) {
            if (current.data.equals(data)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public T remove(int index) {
        int i = size - 1;
        if (head != null && i == index) {
            T oldData = head.data;
            head = head.next;
            size--;
            return oldData;
        }
        Node<T> prev = head;
        Node<T> current = (head != null) ? head.next : null;
        while (current != null) {
            if (--i == index) {
                T oldData = current.data;
                prev.next = current.next;
                size--;
                return oldData;
            }
            prev = current;
            current = current.next;
        }
        throw new IllegalArgumentException("Index out of bound");
    }

    private static class Node<T> {
        T data;
        Node<T> next;
    }
}
