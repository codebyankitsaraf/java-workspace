package algorithms.part.one.union.find;

import java.util.Scanner;

public class WeightedQuickUnion {
    private final int[] arr;
    private final int[] size;

    public WeightedQuickUnion(int n) {
        arr = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }

    public boolean isConnected(int p, int q) {
        validate(p, arr.length);
        validate(q, arr.length);
        return root(p) == root(q);
    }

    public void connect(int p, int q) {
        validate(p, arr.length);
        validate(q, arr.length);
        int rootValueOfP = root(p);
        int rootValueOfQ = root(q);
        if (rootValueOfP == rootValueOfQ) return;
        if (size[rootValueOfP] > size[rootValueOfQ]) {
            arr[rootValueOfQ] = rootValueOfP;
            size[rootValueOfP] += size[rootValueOfQ];
        } else {
            arr[rootValueOfP] = rootValueOfQ;
            size[rootValueOfQ] += size[rootValueOfP];
        }
    }

    private int root(int p) {
        while(arr[p] != p) p = arr[p];
        return p;
    }

    private void validate(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index " + index + " out of bounds [0," + (length - 1) + "]");
        }
    }

    public static void main(String[] args) {
        System.out.println("WeightedQuickUnion");
        System.out.print("Enter number of objects (N): ");

        try(var scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            WeightedQuickUnion wq = new WeightedQuickUnion(n);

            System.out.println("Enter pairs (p q):");
            while(scanner.hasNextInt()){
                int p = scanner.nextInt();
                int q = scanner.nextInt();

                if(wq.isConnected(p, q)){
                    System.out.printf("%d %d -> ALREADY CONNECTED \n", p, q);
                } else {
                    System.out.printf("%d %d -> UNION\n", p, q);
                    wq.connect(p, q);
                    System.out.printf("%d %d -> CONNECTED \n", p, q);
                }
            }
        }
    }
}
