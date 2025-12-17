package algorithms.part.one.linear;

public class LinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> prev, next;
    }

    private Node<T> first, last;
    private int size = 0;

    public LinkedList() {}

    public int size() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index > -1 && index <= size) {
            Node<T> newNode = new Node<>();
            newNode.data = data;

            if (index == 0) {
                newNode.next = first;
                if (first != null) first.prev = newNode;
                else last = newNode;
                first = newNode;
            } else if (index == size) {
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            } else {
                Node<T> current;
                if (index < size / 2) {
                    current = first;
                    for (int i = 0; i < index; i++) current = current.next;
                } else {
                    current = last;
                    for (int i = size - 1; i > index; i--) current = current.prev;
                }

                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
            size++;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public T get(int index) {
        if (index > -1 && index < size) {

            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = size - 1; i > index; i--) current = current.prev;
            }

            return current.data;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void set(int index, T data) {
        if (index > -1 && index < size) {

            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = size - 1; i > index; i--) current = current.prev;
            }

            current.data = data;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void remove(T data) {
        Node<T> current = first;

        while (current != null) {
            if (current.data.equals(data)) {
                unlink(current);
                return;
            }
            current = current.next;
        }
    }

    public void removeAll(T data) {
        Node<T> current = first;

        while (current != null) {
            Node<T> next = current.next;

            if (current.data.equals(data)) {
                unlink(current);
            }
            current = next;
        }
    }

    public T remove(int index) {
        if (index > -1 && index < size) {
            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = size - 1; i > index; i--) current = current.prev;
            }

            T data = current.data;
            unlink(current);
            return data;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    private void unlink(Node<T> node) {
        final Node<T> prev = node.prev;
        final Node<T> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        node.data = null;
        node.prev = node.next = null;
        size--;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add("i:" + i);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " -> ");
        }
        System.out.println();

        linkedList.remove("i:" + 2);
        linkedList.add(9, "i:2");
        linkedList.set(1, "i:9");

        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + " -> ");
        }
        System.out.println();

        linkedList.removeAll("i:9");

        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + " -> ");
        }
        System.out.println();
    }
}
