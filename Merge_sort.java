/**
 * @author Isuru Akalanka Cumaranathunga
 */

public class Merge_sort {
    public static void main(String[] args){
        // This is the input array
        int[] a = {5, 5, 5, 5, 5, 5, 5};
        System.out.print("Unsorted Array : ");
        printArray(a);
        MergeSort(a, 0, a.length - 1);
        System.out.print("\nSorted Array : ");
        printArray(a);
    }

    public static void printArray(int[] a){
        for (int i : a) {
            System.out.print(" "+ i);
        }
    }

    public static void MergeSort(int[] unsortedArray, int p, int r){
        if(p < r){
            int q = (int)Math.floor((p + r) / 2.0);
            MergeSort(unsortedArray, p, q);
            MergeSort(unsortedArray, q + 1, r);
            Merge(unsortedArray, p, q, r);
        }
    }

    public static void Merge(int[] unsortedArray, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        // This will create new arrays
        int[] a1 = new int[n1 + 1];
        int[] a2 = new int[n2 + 1];
        a1[n1] = (int)Double.POSITIVE_INFINITY;
        a2[n2] = (int)Double.POSITIVE_INFINITY;
        System.arraycopy(unsortedArray, p, a1, 0, n1);
        System.arraycopy(unsortedArray, q + 1, a2, 0, n2);
        int i = 0, j = 0;
        for(int k = p; k <= r; k++){
            if(a1[i] < a2[j]){
                unsortedArray[k] = a1[i];
                i++;
            }
            else{
                unsortedArray[k] = a2[j];
                j++;
            }
        }
    }
}
