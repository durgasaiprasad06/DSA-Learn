import java.util.Scanner;

class Main {

    public static int findFloor(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;      // Store current floor index
                low = mid + 1;  // Search for a larger valid floor
            } else {
                high = mid - 1; // Search in left half
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value of x: ");
        int x = sc.nextInt();

        int index = findFloor(arr, x);

        if (index == -1) {
            System.out.println("Floor does not exist.");
        } else {
            System.out.println("Floor index = " + index);
            System.out.println("Floor element = " + arr[index]);
        }

        sc.close();
    }
}
