
package Lab03;

import java.util.Arrays;

public class BinarySearchAlgorithm {
    // Binary Search implementation
    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if key is at mid
            if (array[mid] == key) {
                return mid; // Found
            }

            // If key is greater, ignore left half
            if (array[mid] < key) {
                left = mid + 1;
            }
            // If key is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    // Generate a sorted array of random integers
    public static int[] generateSortedArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + (int) (Math.random() * (max - min + 1));
        }
        Arrays.sort(array); // Sort the array
        return array;
    }

    // Main function to test scenarios
    public static void main(String[] args) {
        // Generate a sorted array
        int[] sortedArray = generateSortedArray(10, 1, 100);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

        // Case 1: Best case (key is in the middle)
        int middleKey = sortedArray[sortedArray.length / 2];
        int result = binarySearch(sortedArray, middleKey);
        System.out.println("Best case: Key " + middleKey + " found at index: " + result);

        // Case 2: Average case (key is at a random position)
        int randomKey = sortedArray[(int) (Math.random() * sortedArray.length)];
        result = binarySearch(sortedArray, randomKey);
        System.out.println("Average case: Key " + randomKey + " found at index: " + result);

        // Case 3: Worst case (key does not exist)
        int notExistingKey = 999; // A value that is not in the range
        result = binarySearch(sortedArray, notExistingKey);
        System.out.println("Worst case: Key " + notExistingKey + " not found (result: " + result + ")");
    }
}
