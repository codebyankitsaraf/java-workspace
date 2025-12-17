package algorithms.part.one.union.find;

import java.util.Scanner;

public class WeightedQuickUnion {

    private static int []arr;
    private static int []size;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = init(n);
        size = initSize(n);

        while(scanner.hasNextInt()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            if(isConnected(p, q)){
                System.out.printf("\n%d and %d are connected\n", p, q);
            } else {
                System.out.printf("\n%d and %d are not connected\n", p, q);
                connect(p, q);
                System.out.printf("\n%d and %d are connected\n", p, q);
            }
        }
    }

    private static int[] init(int n) {
        int []arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] initSize(int n) {
        size = new int[n];
        for(int i = 0; i < n; i++){
            size[i] = 1;
        }
        return size;
    }

    private static boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private static void connect(int p, int q) {
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

    private static int root(int p) {
        while(arr[p] != p) p = arr[p];
        return p;
    }
}
