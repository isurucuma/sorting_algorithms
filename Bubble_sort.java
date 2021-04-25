/**
 * @author Isuru Akalanka Cumaraanthunga
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Bubble_Sort {

    /**
     * bubbleSort: bubble sort without any optimizations.
     *
     * @param unsortedArray - unsorted array
     * @return sorted array
     */
    static int[] bubbleSort(int[] unsortedArray){
        // Number of comparisons and swaps are stored in the variables
        int comparisons = 0;
        int swaps = 0;

        int[] arr = unsortedArray.clone();// A copy of the unsorted array was taken
        int n = arr.length;
        for(int i = 0; i <  n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                comparisons++;
                if(arr[j] > arr[j + 1]){
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        displayCounts("Bubble_sort.BubbleSort", unsortedArray, arr, comparisons, swaps);// Display the output
        return arr;
    }

    /**
     * bubbleSort2: bubble sort with some optimizations.
     *
     * @param unsortedArray - The unsorted array
     * @return sorted array
     */
    static int[] bubbleSort2(int[] unsortedArray){
        // Number of comparisons and swaps are stored in the variables
        int comparisons = 0;
        int swaps = 0;

        int[] arr = unsortedArray.clone();// A copy of the unsorted array was taken
        int n = arr.length;

        boolean swapped;// This is used to check whether there are any swaps happened in the previous iteration

        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for(int j = 0; j < n - 1 - i; j++){
                comparisons++;
                if(arr[j] > arr[j + 1]){
                    swapped = true;
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!swapped){// If there were no swaps has happened then the array is already sorted
                break;
            }
        }
        displayCounts("BubbleSort2", unsortedArray, arr, comparisons, swaps);// Display the output
        return arr;
    }

    /**
     * optimizedBubbleSort: bubble sort with all optimizations.
     *
     * @param unsortedArray - unsorted array
     * @return sorted array
     */
    static int[] optimizedBubbleSort(int[] unsortedArray){
        // Number of comparisons and swaps are stored in the variables
        int comparisons = 0;
        int swaps = 0;

        int[] arr = unsortedArray.clone();// A copy of the unsorted array was taken
        int n = arr.length - 1;

        boolean swapped;// This is used to check whether there are any swaps happened in the previous iteration

        int newLimit = n;
        do{
            swapped = false;
            for(int i = 0; i < n; i++){
                comparisons++;
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    newLimit = i;
                    swapped = true;
                    swaps++;
                }
            }
            n = newLimit;

        }while(swapped);
        displayCounts("OptimizedBubbleSort", unsortedArray, arr, comparisons, swaps);// Display the output
        return arr;
    }

    /**
     * This method is used to display the outputs from the sorting arrays
     * @param algoName name of the algorithm
     * @param unsortedArray input unsorted array
     * @param sortedArray output sorted array
     * @param comparisons number of comparisons
     * @param swaps number of swaps
     */
    static void displayCounts(String algoName, int[] unsortedArray, int[] sortedArray, int comparisons, int swaps){
        System.out.println("\nStatistics of " + algoName + " algorithm");
        System.out.println("unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("sorted array: " + Arrays.toString(sortedArray));
        System.out.println("Number of comparisons : " + comparisons);
        System.out.println("Number of swapings : " + swaps + "\n");
    }

    public static void main(String[] args) throws IOException {
        System.out.print("This program will sort integer numbers in given array using bubble sort.\n" + "n - " +
                "number of integers in input array.\n" + "Enter input array size(n): ");

        // Getting input array from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] inputArray = new int[n];
        int inputSize;
        String input;
        do {
            System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            inputArray[j] = Integer.parseInt(numbers[j]);
        }
        bubbleSort(inputArray);
        bubbleSort2(inputArray);
        optimizedBubbleSort(inputArray);
    }
}
