/**
 * @author Cumaranathunga P.I.A.
 */

public class Insertion_sort {
    static int[] numArray = {5, 4, 3, 2, 1};
    public static void main(String[] args){
        System.out.println("This is the Insertion Sort...");
        printArray(numArray);
        InsertionSort();
        printArray(numArray);
    }

    public static void printArray(int[] arr){
        System.out.println("");
        System.out.print(arr[0]);
        for(int i = 1; i < arr.length; i++){
            System.out.print(", " + arr[i]);
        }
    }

    public static void InsertionSort(){
        for(int j = 1; j < numArray.length; j++){
            int key = numArray[j];
            int i = j - 1;
            while (i >= 0 && numArray[i] > key){
                numArray[i + 1] = numArray[i];
                i -= 1;
            }
            numArray[i + 1] = key;
        }
    }
}
