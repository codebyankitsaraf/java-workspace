package algorithms.part.one.binary.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        System.out.println("Normal Binary Search");
        int[] arrOne = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arrOne));
        int indexOne = bs.binarySearch(arrOne, 0, 8, 3);
        System.out.println("Index of 3: " + indexOne);

        System.out.println("\nRotated Array Binary Search");
        int[] arrTwo = new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(Arrays.toString(arrTwo));
        int indexTwo = bs.binarySearchRotatedArr(arrTwo, 0, 8, 3);
        System.out.println("Index of 3: " + indexTwo);
        System.out.println("Index of 5: " + bs.binarySearchRotatedArr(arrTwo, 0, 8, 5));
        System.out.println("Index of 10: " + bs.binarySearchRotatedArr(arrTwo, 0, 8, 10));
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (target > arr[mid]) return binarySearch(arr, mid, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }

    public int binarySearchRotatedArr(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;

        if (arr[mid] >= arr[left]) {
            if (target >= arr[left] && target < arr[mid])
                return binarySearchRotatedArr(arr, left, mid - 1, target);
            return binarySearchRotatedArr(arr, mid + 1, right, target);
        } else {
            if (target > arr[mid] && target <= arr[right])
                return binarySearchRotatedArr(arr, mid + 1, right, target);
            return binarySearchRotatedArr(arr, left, mid - 1, target);
        }
    }
}
