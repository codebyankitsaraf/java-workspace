package algorithms.part.one.binary.search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Index of 3: " + binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 8, 3));
        System.out.println("Index of 3: " + binarySearchRotatedArr(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 0, 8, 3));
    }

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
}
