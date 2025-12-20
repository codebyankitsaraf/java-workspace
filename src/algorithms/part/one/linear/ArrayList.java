package algorithms.part.one.linear;

import java.util.Arrays;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] array;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public static void main(String[] args) {
        System.out.println("ArrayList");

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(5);
        ArrayList<String> list3 = new ArrayList<>(25);

        for (int i = 0; i < 12; i++) {
            list1.add("A" + i);
            list2.add("B" + i);
        }

        System.out.println("list1 after growth (size=" + list1.size() + ", cap=" + list1.array.length + "): " +
                Arrays.toString(Arrays.copyOf(list1.array, list1.size())));
        System.out.println("list2 after growth (size=" + list2.size() + ", cap=" + list2.array.length + "): " +
                Arrays.toString(Arrays.copyOf(list2.array, list2.size())));

        System.out.println("list1.get(3): " + list1.get(3));
        list1.set(3, "MODIFIED");
        System.out.println("list1.get(3) after set: " + list1.get(3));

        list1.add(0, "NEW_FIRST");
        System.out.println("list1 after add(0): " +
                Arrays.toString(Arrays.copyOf(list1.array, list1.size())));

        list1.remove(2);
        System.out.println("list1 after remove(2): " +
                Arrays.toString(Arrays.copyOf(list1.array, list1.size())));

        list2.remove("B3");
        System.out.println("list2 after remove(B3): " +
                Arrays.toString(Arrays.copyOf(list2.array, list2.size())));

        for (int i = 0; i < 8; i++) {
            list2.add("DUPE");
        }
        list2.remove("B4");
        list2.remove("B5");
        System.out.println("list2 before removeAll(DUPE) (size=" + list2.size() + ", cap=" + list2.array.length + "): " +
                list2.size() + " elements");

        list2.removeAll("DUPE");
        System.out.println("list2 after removeAll(DUPE) - auto shrink (size=" + list2.size() + ", cap=" + list2.array.length + "): " +
                Arrays.toString(Arrays.copyOf(list2.array, list2.size())));

        System.out.println("list3 capacity before trim: " + list3.array.length);
        list3.trimToSize();
        System.out.println("list3 capacity after trim: " + list3.array.length);

        ArrayList<Integer> emptyList = new ArrayList<>();
        System.out.println("emptyList.size(): " + emptyList.size());
        emptyList.add(999);
        System.out.println("emptyList after add(999): " +
                Arrays.toString(Arrays.copyOf(emptyList.array, emptyList.size())));
    }

    public int size() {
        return size;
    }

    public void trimToSize() {
        shrink();
    }

    public T get(int index) {
        if (index > -1 && index < size) return (T) array[index];
        else throw new IllegalArgumentException("Index out of bound");
    }

    public void add(T value) {
        if (size == array.length) grow();
        array[size++] = value;
    }

    public void add(int index, T value) {
        if (index > -1 && index <= size) {
            if (size == array.length) grow();
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = value;
            size++;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void set(int index, T value) {
        if (index > -1 && index < size) array[index] = value;
        else throw new IllegalArgumentException("Index out of bound");
    }

    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                remove(i);
                return;
            }
        }
    }

    public void removeAll(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) remove(i);
        }
        shrink();
    }

    public void remove(int index) {
        if (index > -1 && index < size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    private void grow() {
        int newCapacity = array.length * 2;
        if (newCapacity < 0) newCapacity = DEFAULT_CAPACITY;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void shrink() {
        if (size >= array.length / 2) return;
        int newCapacity = Math.max(array.length / 2, DEFAULT_CAPACITY);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
