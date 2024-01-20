package com.jasonz.algorithms.search;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 14:55
 * @project JasonJavaLibrary
 * @description:
 */
public class TernarySearch {


    // Function to perform Ternary Search by iteration
    public static int ternarySearchIterate(int l, int r, int key, int[] ar) {
        while (r >= l) {

            // Find the mid1  mid2
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            // Check if key is present at any mid
            if (ar[mid1] == key) {
                return mid1;
            }
            if (ar[mid2] == key) {
                return mid2;
            }

            // Since key is not present at mid, check in which region it is present
            // then repeat the Search operation in that region
            if (key < ar[mid1]) {
                // The key lies in between l and mid1
                r = mid1 - 1;
            } else if (key > ar[mid2]) {
                // The key lies in between mid2 and r
                l = mid2 + 1;
            } else {
                // The key lies in between mid1 and mid2
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }

        // Key not found
        return -1;
    }


    // Function to perform Ternary Search by Recursive
    public static int ternarySearchRecursive(int l, int r, int key, int[] arr) {
        if (r >= l) {

            // Find the mid1 and mid2
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            // Check if key is present at any mid
            if (arr[mid1] == key) {
                return mid1;
            }
            if (arr[mid2] == key) {
                return mid2;
            }

            // Since key is not present at mid, check in which region it is present
            // then repeat the Search operation in that region
            if (key < arr[mid1]) {
                // The key lies in between l and mid1
                return ternarySearchRecursive(l, mid1 - 1, key, arr);

            } else if (key > arr[mid2]) {
                // The key lies in between mid2 and r
                return ternarySearchRecursive(mid2 + 1, r, key, arr);

            } else {
                // The key lies in between mid1 and mid2
                return ternarySearchRecursive(mid1 + 1, mid2 - 1, key, arr);
            }
        }

        // Key not found
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int l, r, p, key;

        // Get the array Sort the array if not sorted
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Starting index
        l = 0;

        // end element index
        r = arr.length - 1;

        // Checking for 5, Key to be searched in the array
        key = 5;
        // Search the key using ternarySearch
        p = ternarySearchRecursive(l, r, key, arr);
        // Print the result
        System.out.println("Index of " + key + " is " + p);
        p = ternarySearchIterate(l, r, key, arr);
        // Print the result
        System.out.println("Index of " + key + " is " + p);

        // Checking for 50 Key to be searched in the array
        key = 50;
        // Search the key using ternarySearch
        p = ternarySearchRecursive(l, r, key, arr);
        // Print the result
        System.out.println("Index of " + key + " is " + p);
        p = ternarySearchIterate(l, r, key, arr);
        // Print the result
        System.out.println("Index of " + key + " is " + p);

    }
}
