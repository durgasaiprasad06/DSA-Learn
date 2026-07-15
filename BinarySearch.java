/**
 * Binary Search Implementation
 * Link : https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1
 * Topic : Binary Search
 */

import java.util.Scanner;

class Main {
    public static boolean binarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return true;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {2, 4, 6, 8, 10, 12, 14};

        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        if (binarySearch(arr, key)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
    }
}
