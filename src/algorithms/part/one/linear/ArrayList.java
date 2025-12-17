package algorithms.part.one.linear;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size = 0;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
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

    public static void main(String[] args) {
        ArrayList<String> arrayListOne = new ArrayList<>();
        ArrayList<String> arrayListTwo = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            arrayListOne.add("i: " + i);
            arrayListTwo.add("j: " + 5);
        }

        for (int i = 0; i < arrayListOne.size(); i++) {
            System.out.print(arrayListOne.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayListTwo.size(); i++) {
            System.out.print(arrayListTwo.get(i) + " ");
        }
        System.out.println();

        arrayListOne.remove("i: 5");
        arrayListTwo.removeAll("j: 5");

        for (int i = 0; i < arrayListOne.size(); i++) {
            System.out.print(arrayListOne.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayListTwo.size(); i++) {
            System.out.print(arrayListTwo.get(i) + " ");
        }
        System.out.println();

        arrayListOne.add(4, "i: 5");
        arrayListOne.set(9, "i: 5");
        arrayListTwo.add("j: 5");

        arrayListOne.trimToSize();
        arrayListTwo.trimToSize();

        for (int i = 0; i < arrayListOne.size(); i++) {
            System.out.print(arrayListOne.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayListTwo.size(); i++) {
            System.out.print(arrayListTwo.get(i) + " ");
        }
        System.out.println();
    }
}
