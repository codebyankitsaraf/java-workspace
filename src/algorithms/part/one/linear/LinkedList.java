package algorithms.part.one.linear;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> first, last;
    private int size = 0;

    public LinkedList() {
    }

    public static void main(String[] args) {
        System.out.println("LinkedList");

        LinkedList<String> list = new LinkedList<>();

        System.out.println("1. After add(10 elements):");
        for (int i = 0; i < 10; i++) {
            list.add("i:" + i);
        }
        printList(list);

        System.out.println("2. After remove(\"i:2\"):");
        list.remove("i:2");
        printList(list);

        System.out.println("3. After add(9, \"i:2\"):");
        list.add(9, "i:2");
        printList(list);

        System.out.println("4. After set(1, \"i:9\"):");
        list.set(1, "i:9");
        printList(list);

        System.out.println("5. After removeAll(\"i:9\"):");
        list.removeAll("i:9");
        printList(list);

        System.out.println("6. get(0): " + list.get(0));
        System.out.println("   After remove(0):");
        list.remove(0);
        printList(list);
    }

    private static <T> void printList(LinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("size=" + list.size());
        System.out.println();
    }

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
        if (index >= 0 && index <= size) {
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
                    for (int i = 0; i < size - 1 - index; i++) current = current.prev;
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
        if (index >= 0 && index < size) {

            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = 0; i < size - 1 - index; i++) current = current.prev;
            }

            return current.data;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void set(int index, T data) {
        if (index >= 0 && index < size) {

            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = 0; i < size - 1 - index; i++) current = current.prev;
            }

            current.data = data;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public boolean remove(T data) {
        Node<T> current = first;

        while (current != null) {
            if (Objects.equals(data, current.data)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAll(T data) {
        Node<T> current = first;

        while (current != null) {
            Node<T> next = current.next;

            if (Objects.equals(data, current.data)) {
                unlink(current);
            }
            current = next;
        }
    }

    public T remove(int index) {
        if (index >= 0 && index < size) {
            Node<T> current;

            if (index < size / 2) {
                current = first;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = last;
                for (int i = 0; i < size - 1 - index; i++) current = current.prev;
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

    private static class Node<T> {
        T data;
        Node<T> prev, next;
    }
}
