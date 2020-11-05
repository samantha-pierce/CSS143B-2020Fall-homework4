package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        // homework
        if (data.length == 0) {
            return -1;
        }
        return binarySearch(data, 0, data.length - 1, target);
    }

    // helper method
    private static int binarySearch(int[] data, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return -1;
        }
        if (data[mid] == target) {
            return mid;
            // check left half
        } else if (target < data[mid]) {
            return binarySearch(data, start, mid - 1, target);
        }
        // check right half
        return binarySearch(data, mid + 1, end, target);
    }
}
