package algorithms.part.one.binary.search;

import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(int[] arr, int left, int right, int target) {
        if (left >= right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (target >= arr[mid]) return binarySearch(arr, mid, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }

    private static int binarySearchRotatedArr(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        if (arr[mid] >= arr[left]) {
            if (target >= arr[left] && target <= arr[mid]) return binarySearchRotatedArr(arr, left, mid, target);
            else return binarySearchRotatedArr(arr, mid + 1, right, target);
        } else {
            if (target > arr[mid] && target <= arr[right]) return binarySearchRotatedArr(arr, mid + 1, right, target);
            else return binarySearchRotatedArr(arr, left, mid, target);
        }
    }

    public static void main(String[] args) {

        // Normal Binary Search
        System.out.println("Normal Binary Search");
        int[] arrOne  = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arrOne));
        int indexOne  = binarySearch(arrOne, 0, 8, 3);
        System.out.println("Index of 3: " + indexOne);

        // Rotated Array Binary Search
        System.out.println("Rotated Array Binary Search");
        int[] arrTwo = new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(Arrays.toString(arrTwo));
        int indexTwo = binarySearchRotatedArr(arrTwo, 0, 8, 3);
        System.out.println("Index of 3: " + indexTwo);
    }
}
