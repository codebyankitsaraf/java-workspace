package algorithms.part.one.union.find;

import java.util.Scanner;

public class QuickFind {
    private final int[] arr;

    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        validate(p, arr.length);
        validate(q, arr.length);
        return arr[p] == arr[q];
    }

    public void connect(int p, int q) {
        validate(p, arr.length);
        validate(q, arr.length);
        int rootValueOfP = arr[p];
        int rootValueOfQ = arr[q];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == rootValueOfP)
                arr[i] = rootValueOfQ;
        }
    }

    private void validate(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index " + index + " out of bounds [0," + (length - 1) + "]");
        }
    }

    public static void main(String[] args) {
        System.out.println("QuickFind");
        System.out.print("Enter number of objects (N): ");

        try(var scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            QuickFind qf = new QuickFind(n);

            System.out.println("Enter pairs (p q):");
            while(scanner.hasNextInt()){
                int p = scanner.nextInt();
                int q = scanner.nextInt();

                if(qf.isConnected(p, q)){
                    System.out.printf("%d %d -> ALREADY CONNECTED \n", p, q);
                } else {
                    System.out.printf("%d %d -> UNION\n", p, q);
                    qf.connect(p, q);
                    System.out.printf("%d %d -> CONNECTED \n", p, q);
                }
            }
        }
    }
}
