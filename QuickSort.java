/**
 * @author Isuru Akalanka Cumaranathunga
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class QuickSort {

    public static void main(String[] args) throws IOException {
        System.out.print("This program will take an array of integers as input and sort it using quick sort.\n" + "n - " +
                "numbers of integers in the array.\n" + "Enter the array size(n): ");

        // BufferReader is the helper class that we are use to get the user input
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] inputArray  = new int[n];
        int inputSize;
        String input;

        // Here the user input size will get checked whether it is equal to n
        do{
            System.out.print("Enter" + n + " integers seperated by space, to sort (n1 n2 n3...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        }while(inputSize != n);

        String[] inputNumbers = input.split(" ");
        for(int i = 0; i < n; i++){
            inputArray[i] = Integer.parseInt(inputNumbers[i]);
        }

        System.out.print("Unsorted array : ");
        printArray(inputArray);
        quickSort(inputArray, 0, n - 1);// sorting method call
        System.out.print("\nSorted array : ");
        printArray(inputArray);
    }

    /**
     * printArray: This method is used to print the given array
     * @param a given array
     */
    public static void printArray(int[] a){
        //Enhanced for loop used to iterate through the array elements
        for (int i : a) {
            System.out.print(" "+ i);
        }
    }

    /**
     * quickSort: This method is the entry point to the quickSort algorithm
     *            also this method get called recursively throughout the program until the array gets sorted
     * @param a input array
     * @param p starting index
     * @param r ending index
     */
    public static void quickSort(int[] a, int p, int r){
        if(r > p){// this will check whether the array size is greater then one
            int i = randomizedPartition(a, p, r);
            quickSort(a, p, i - 1);// Recursive sort to the first half
            quickSort(a, i + 1, r);// Recursive sort to the second half
        }
    }

    /**
     * This method is used to do the randomized quicksort. The initial index (p) value and a random index value
     * will get swapped to ensure the randomized sort. Then the partition function will get called to do the partitioning
     * process.
     * @param a input array
     * @param p starting index
     * @param r ending index
     * @return the current pivot
     */
    public static int randomizedPartition(int[] a, int p, int r){
        Random random = new Random(); // This is the helper class to get a random number
        int i = random.nextInt(r - p + 1) + p; // This will generate a random number
        // Value at the random position and the initial position will get swapped
        int temp = a[p];
        a[p] = a[i];
        a[i] = temp;
        return partition(a, p, r);
    }

    /**
     * This method do the partitioning process. pivot point is the initial index (p).
     * Finally p will get shifted to the appropriate position.
     * @param a input array
     * @param p initial index
     * @param r end index
     * @return the current index
     */
    public static int partition(int[] a, int p, int r){
        int i = p;
        int x = a[p];// pivot point value saved in a separate variable x
        for(int j = i + 1; j <= r; j++){
            if(a[j] < x){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[p] = a[i];// pivot point moved to the appropriate position in the array
        a[i] = x;
        return i;// this is the current pivot point index
    }
}
