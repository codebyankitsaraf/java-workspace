package algorithms.part.one.union.find;

import java.util.Scanner;

public class QuickFind {

    private static int []arr;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = init(n);

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

    private static boolean isConnected(int p, int q) {
        return arr[p] == arr[q];
    }

    private static void connect(int p, int q) {
        int rootValueOfP = arr[p];
        int rootValueOfQ = arr[q];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == rootValueOfP)  arr[i] = rootValueOfQ;
        }
    }
}
