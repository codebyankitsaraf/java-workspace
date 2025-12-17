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

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("i: " + i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        int n = arrayList.size;
        for (int i = 0; i < n; i++) {
            arrayList.remove("i: " + i);
        }
        for (int i = 0; i < arrayList.size; i++) {
            System.out.println(arrayList.get(i));
        }

        arrayList.remove("i: 9");

    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index > -1 && index < size) {
            //noinspection unchecked
            return (T) array[index];
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public void add(T value) {
        if (size >= array.length) {
            resizeArray();
        }
        array[size++] = value;
    }

    public void add(int index, T value) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index out of bound");
        }

        if (size >= array.length) {
            resizeArray();
        }
        array[size++] = value;
    }

    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                remove(i);
            }
        }
    }

    private void remove(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Index out of bound");
        }
        int i = index;
        final int newSize = size - 1;
        while (i < newSize) array[i] = array[++i];
        array[size = newSize] = null;
    }

    private void resizeArray() {
        Object[] newArray = new Object[size * size];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
