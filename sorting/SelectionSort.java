
public class SelectionSort {
    public static void selectionSort(int arr[]) {
        int size = arr.length;
        for(int i = 0; i<size; i++) {
            // curr index
            int minEle = i; // initially first ele in min
            for(int j = i + 1; j<size; j++) {
                if(arr[j] < arr[minEle]) {
                    minEle = j;
                }
            }

            // swap
            int temp = arr[minEle];
            arr[minEle] = arr[i];
            arr[i] = temp;

            System.out.print("Iteration " + (i+1) + ": ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] =  {20, 12, 10, 15, 2};
        selectionSort(arr);
    }
}