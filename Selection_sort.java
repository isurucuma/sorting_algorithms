/**
 * @author Isuru Akalanka Cumaranathunga
 */

public class Selection_sort {
    public static void main(String[] args){
        int[] a = {0, 2, 10, 1, 6, 0};
        System.out.print("Unsorted Array : ");
        printArray(a);
        selectionSort(a);
        System.out.print("\nSorted Array : ");
        printArray(a);
    }

    public static void printArray(int[] a){
        for (int i : a) {
            System.out.print(" "+ i);
        }
    }
    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
