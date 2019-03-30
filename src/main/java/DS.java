
public class DS {

    // Java program to rotate an array by
    // d elements
    /* Function to left rotate arr[] of siz n by d */
    void leftRotate(int arr[], int d, int n) {
        int temp;
        int gcd = gcd(d, n);

        for (int i = 0; i < d; i++) {
            temp = arr[i];
            for (int j = i; j < n - gcd; j = j + gcd) {
                arr[j] = arr[j + gcd];
            }
            // if (n - gcd + i < n)
            arr[n - gcd + (i - 1)] = temp;
        }

    }

    /* UTILITY FUNCTIONS */

    /* function to print an array */
    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /* Fuction to get gcd of a and b */
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        DS rotate = new DS();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        rotate.leftRotate(arr, 5, 12);
        rotate.printArray(arr, 12);
    }
}

// This code has been contributed by Mayank Jaiswal
